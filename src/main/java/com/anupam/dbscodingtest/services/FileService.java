package com.anupam.dbscodingtest.services;

import java.util.List;

import com.anupam.dbscodingtest.models.DBSFile;
import com.anupam.dbscodingtest.utils.DBSFileUtil;

public class FileService implements IFileService {

	@Override
	public List<DBSFile> getFiles(String name) {
		try {
			List<DBSFile> files = new DBSFileUtil().getFiles(name);
			return files;
			
		} catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	public DBSFile getFileDetail(String name) {
		try {
			return new DBSFileUtil().getFileDetail(name);
			
		} catch(Exception ex) {
			throw ex;
		}
	}

}
