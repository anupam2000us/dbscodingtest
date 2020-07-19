/**
 * 
 */
package com.anupam.dbscodingtest.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;
import com.anupam.dbscodingtest.models.*;
import com.anupam.dbscodingtest.services.*;

/**
 * Unit tests for DBSFileUtil
 * @author Anupam
 *
 */
public class DBSFileUtilTest {

	private IFileService fs = new FileService();

	
	
	/**
	 * throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.anupam.dbscodingtest.utils.DBSFileUtil#getFileDetail(java.lang.String)}.
	 */
	@Test
	public final void testGetFileDetail() {
		//fail("Not yet implemented"); // TODO
		
		/*
		 * Create a File aaa.txt
		 * Call GetFileDetails
		 * verify if it contains aaa.txt
		 * Delete aaa.txt
		 * 
		 */
		
	try {
			File f1=new File("aaa.txt");
			
			if(f1.createNewFile())
			{
				//file created 
			}
			
			// Call Service to Test
		    
    		DBSFile file = fs.getFileDetail(f1.getName());

    		assertTrue(file.getName().contains(f1.getName()));
			
			if(f1.delete()) 
			{
					//  aaa.txt deleted
			}
		}catch(Exception ex){}	
	}

	/**
	 * Test method for {@link com.anupam.dbscodingtest.utils.DBSFileUtil#getFiles(java.lang.String)}.
	 */
	@Test
	public final void testGetFiles() {
		// fail("Not yet implemented"); // TODO
				/**
				 * Create a folder - TestFolder
				 * Create 2 files- aaa.txt, bbb.txt
				 * Call getfiles for TestFolder
				 * verify if it contains aaa.txt
				 * Delete TestFolder
				 *
				 */
				try {
					
					File dir1=new File("TestFolder");
					File f1=null;
					if (dir1.mkdir()) //folder created
					{
						f1=new File(dir1.getAbsolutePath()+"/aaa.txt");
						if(f1.createNewFile())
						{
							//file aaa.txt created under Dir1 
						}
					}
					// CallService to Test
				    
		    		List<DBSFile> files = fs.getFiles(dir1.getAbsolutePath());

		    		assertTrue(files.get(0).getName().contains(f1.getName()));
					
					
					if(f1.delete()) //delete aaa.txt
					{
						if (dir1.delete())
						{
							// delete TestFolder
						}
						
					}
				}catch(Exception ex){}
	}

}
