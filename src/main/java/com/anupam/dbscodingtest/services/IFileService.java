package com.anupam.dbscodingtest.services;

import java.util.List;

import com.anupam.dbscodingtest.models.DBSFile;

public interface IFileService {
	public List<DBSFile> getFiles(String name);
	public DBSFile getFileDetail(String name);

}
