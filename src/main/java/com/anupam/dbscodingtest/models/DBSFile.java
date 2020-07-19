package com.anupam.dbscodingtest.models;

public class DBSFile {
	
	private String name;
	private Long sizeInKb;
	private Permission permission;
	private Boolean isDirectory = false;
	private String path;
	private String details = "";
	
	public DBSFile(String inputName, String inputPath, Long inputSize, Permission inputPerm, Boolean inputIsDirectory) {
		name = inputName;
		sizeInKb = inputSize / 1024;
		permission = inputPerm;
		isDirectory = inputIsDirectory;
		path = inputPath;
	}
	
	public DBSFile(String inputName) {
		name = inputName;
	}
	
	public Boolean getIsDirectory() {
		return isDirectory;
	}
	
	public void setIsDirectory(Boolean val) {
		isDirectory = val;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String val) {
		name = val;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String val) {
		name = details;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String val) {
		path = val;
	}

	public Long getSize() {
		return sizeInKb;
	}
	
	public void setSize(Long val) {
		sizeInKb = val / 1024;
	}

	public Permission getPermission() {
		return permission;
	}
	
	public void setPermission(Permission val) {
		permission = val;
	}

}
