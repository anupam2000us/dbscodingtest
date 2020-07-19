<html>
<head>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" type="text/javascript"></script>
	<script src="scripts/restUtil.js" type="text/javascript"></script>
</head>
<body>
	<style>

		input[type=text] {
			height: 34px;
			padding: 0px 5px;
			border-radius: 3px;
			border: 1px solid #a3a3a3;
		}

		button {
			height: 34px;
			padding: 0px 10px;
			;
		}

		.text-input {
			width: 60%;
			height: 24px;
			line-height: 24px;
		}

		.search-container {
			width: 45%;
			height: 500px;
			padding: 15px;
		}

		.result-container {
			margin-top: 20px;
			margin-bottom: 20px;;
			padding: 15px;
			border: 1px solid #d3d3d3;
			background-color: #f7f7f7;
			height: 600px;
			overflow-y: auto;
			overflow-x: hidden;
		}

		.parent-search-container {
			width: 100%;
			padding: 20px;

		}

		.btn-search {
			margin-left: 10px;
		}
		.file-details, .file-permission {
			width: 100%;
		}

		.file, .folder {
			padding: 10px;
			border: 1px solid #d3d3d3;
			margin-bottom: 5px;
			background-color: white;
			border-radius: 3px;
		}
		
		.file-permission {
			font-style: italic;
			padding: 0px 5px;
			float: left;
		}
		
		.file-name, .folder-name {
			width: 70%;
			float: left;
			margin-bottom: 5px;;
			line-height: 24px;
			padding: 0px 5px;
		}

		.folder {
			background-color: #FBFBA2;
			border: 1px solid #BDBD2E;
			cursor: pointer;
		}

		.file-size {
			width: 20%;
			text-align: right;
			float:right
		}
		.file-path {
			width: 100%;
			padding: 0px 5px;
			word-break: break-all;
			display: -webkit-box;
			-webkit-line-clamp: 1;
			-webkit-box-orient: vertical;  
			overflow: hidden;
		}
	</style>
    <!--<h2>Jersey RESTful Web Application!</h2>
    
    <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>
    for more information on Jersey! -->
    
    
    <div class="parent-search-container">
		<div id="fileSearchContainer" class="search-container" style="margin-right: 20px; float: left;">
			<input type="text" class="text-input" id="searchFile" placeholder="Enter file name" />
			<button id="searchBtn" class="btn-search" onclick="onGetFileDetailsClick()">Find File Detail</button>
			<div id="searchResultContainer" class="result-container">
				<div id="noResultsDiv" style="text-align: center; padding-top: 20px;">No File Details</div>
				
				<div id="resultData">

				</div>
			</div>
		</div>
    	<div id="dirSearchContainer" class="search-container" style="float:right;" >
    		<input type="text" class="text-input" id="searchDir" placeholder="Enter folder name" />
			<button id="searchBtn" class="btn-search" onclick="onGetFilesClick()">Find Files</button>
			<div id="directorySearchResultContainer" class="result-container">
				<div id="noFolderResultsDiv" style="text-align: center; padding-top: 20px;">No Files</div>
				<div id="searchingFoldersDiv" style="display: none; text-align: center; padding-top: 30px;">
					<img src="./images/spinner-2.gif" alt="Searching.." style="height: 100px;"/>
				</div>
				<div id="folderResultData">

				</div>
			</div>
    	</div>
	</div>
</body>
</html>
 