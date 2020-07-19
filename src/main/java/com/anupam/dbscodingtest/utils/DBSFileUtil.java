package com.anupam.dbscodingtest.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

import com.anupam.dbscodingtest.models.DBSFile;
import com.anupam.dbscodingtest.models.Permission;

/**
 * DBSFileUtil - The class implements the primary methods to handle file
 * directory operations. Look into the method documentation to get the API
 * Details.
 * 
 * @author Anupam
 * @version 1.0
 *
 */
public class DBSFileUtil {

	// private final static Logger LOGGER =
	// Logger.getLogger(DBSFileUtil.class.getName());
	private static DBSLoggerUtil logger = new DBSLoggerUtil(DBSFileUtil.class.getName());
	private List<DBSFile> allFiles = new ArrayList<>();
	private static int levelsToRecurseThrough = 3;

	/**
	 * Method to fetch the file details such as Name, Permissions, File size and so
	 * on.
	 * 
	 * @param fName - String - Mandatory - File name. Throws null pointer exception
	 *              if not supplied.
	 * @return DBSFile object - Contains the details of the file, such as name,
	 *         permission and file size.
	 */
	public DBSFile getFileDetail(String fName) {
		String err = "";
		if (fName == "" || fName == null) {
			err = "File name cannot be empty";
			logger.log(Level.SEVERE, err, "getFileDetail");
			throw new NullPointerException(err);
		}

		DBSFile file = new DBSFile(fName);

		try {
			File f = new File(fName);
			if (!f.exists()) {
				err = "File with input name " + fName + " not found";
				logger.log(Level.SEVERE, err, "getFileDetail");
				throw new NullPointerException();
			}
			if (f.isDirectory()) {
				logger.log(Level.WARNING, "The input is to a directory", "getFileDetail");
			} else {
				file = new DBSFile(f.getName(), f.getAbsolutePath(), f.length(), 
						getPermission(f.canRead(), f.canExecute(), f.canWrite()),
						f.isDirectory());
				logger.log(Level.INFO, "File found.", "getFileDetail");
			}

		} catch (Exception ex) {
			logger.log(Level.SEVERE, "An exception has occured. Details : " + ex.getMessage(), "getFileDetail");
			throw ex;
		}

		return file;

	}

	/**
	 * Find files utility given a directory name
	 * 
	 * @param dirName - String - Name of the directory.
	 */
	private void findFiles(File[] files, int idx, int lvl) {
		if (idx == files.length || lvl == levelsToRecurseThrough)
			return;
		File file = files[idx];
		DBSFile dbf = new DBSFile(file.getName(), file.getAbsolutePath(), file.length(), 
				getPermission(file.canRead(), file.canExecute(), file.canWrite()), 
				file.isDirectory());
		allFiles.add(dbf);

		if (file.isDirectory()) {
			findFiles(files[idx].listFiles(), 0, lvl + 1);
		}

		findFiles(files, ++idx, lvl);
	}

	/**
	 * Method to fetch the files / directories given a file path.
	 * 
	 * @param fName String - Mandatory - File path of the directory. Throws null pointer exception if empty.
	 * List<DBSFile> - It returns List of files or folders within the specified directory.
	 */
	public List<DBSFile> getFiles(String fName) {
		String err = "";
		if(fName == "" || fName == null) {
			err = "Directory name cannot be empty";
			logger.log(Level.SEVERE, err, "getFiles");
			throw new NullPointerException(err);
		}
		
		try {
			File f = new File(fName);
			if(!f.exists()) {
				err = "File with input name " + fName + " not found";
				logger.log(Level.SEVERE, err, "getFileDetail");
				throw new NullPointerException();
			}
			
			if(!f.isDirectory()) {
				logger.log(Level.WARNING, "File is not a directory", "getFiles");
				return allFiles;
			}

			File[] files = f.listFiles();
			findFiles(files, 0, 0);
			logger.log(Level.INFO, "Found files", "getFiles");
			
		} catch(Exception ex) {
			logger.log(Level.SEVERE, "An exception has occured. Details : " + ex.getMessage(), "getFiles");
			throw ex;
		}
		
		
		return allFiles;
		
	}

	private Permission getPermission(Boolean canRead, Boolean canExecute, Boolean canWrite) {
		Permission p = Permission.noAcess;
		if (canWrite)
			p = Permission.readAndWrite;
		else if (canRead) {
			p = Permission.readOnly;
		} else if (canExecute) {
			p = Permission.execute;
		}

		return p;

	}

}
