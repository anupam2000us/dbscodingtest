$(document).ready(function() {

	triggerFolderSearch = function(name) {
		$("#searchDir").val(name);
		onGetFilesClick();
	}

	sanitizeFilePath = function(filePath) {
		return filePath.replace(/\\/g, "/");
	}

	onGetFilesClick = function() {
		searchingFoldersDiv
		$("#searchingFoldersDiv").css("display", "block");
		$("#noFolderResultsDiv").css("display", "none");
		var inputDir = $("#searchDir")[0].value;
		var url = "api/fileservice/files?fn=" + sanitizeFilePath(inputDir);
		$.ajax({
			url: url,
			success: function(resp) {
				console.log(resp);
				$("#searchingFoldersDiv").css("display", "none");
				var resultHtml = '<div><b>' + resp.length + '</b> Files / Folders upto 3 directory levels.</div>'
						+ '<div style="font-style:italic; font-weight:600; font-size:small;">Yellow background items are folders. Click them to navigate further.</div><br/>';
				for(var x = 0; x < resp.length; x++) {
					var r = resp[x];
					if(r.isDirectory) {
						var folderTemplate = '<div class="folder" onclick="triggerFolderSearch(\''+ sanitizeFilePath(r.path) +'\')" >'	
						+	'<div class="file-details">'
						+	'	<div class="folder-name">'
						+	'		<a href="#">' + r.name + '</a>'
						+	'	</div>'
						+	'	<div class="file-size">--</div>'
						+	'</div>'
						+	'<div class="file-path" title="' + r.path + '">'
						+	r.path
						+	'</div>'
						+'</div>';
						resultHtml += folderTemplate;
					} else {
						var fileTemplate = '<div class="file">'	
						+	'<div class="file-details">'
						+	'	<div class="file-name">'
						+	'		<a href="#">' + r.name + '</a>'
						+	'	</div>'
						+	'	<div class="file-size">' + r.size + 'KB</div>'
						+	'</div>'
						+	'<div class="file-path" title="' + r.path + '">'
						+	r.path
						+	'</div>'
						+'</div>';
						resultHtml += fileTemplate;
					}
				}
				$("#folderResultData").html(resultHtml);
			},
			error: function(err) {
				$("#noFolderResultsDiv").css("display", "block");
				$("#searchingFoldersDiv").css("display", "none");
				$("#folderResultData").html("");
				console.log("Failure to invoke getFiles service. " + err);
			}
		});
	};

	onGetFileDetailsClick = function() {
		var inputFile = $("#searchFile")[0].value;
		var url = "api/fileservice/files/file?name=" + sanitizeFilePath(inputFile);
		$.ajax({
			url: url,
			success: function(resp) {
				console.log(resp);
				$("#noResultsDiv").css("display", "none");
				var fileTemplate = '<div class="file">'	
						+	'<div class="file-details">'
						+	'	<div class="file-name">'
						+	'		<a href="#">' + resp.name + '</a>'
						+	'	</div>'
						+	'	<div class="file-size">' + resp.size + 'KB</div>'
						+	'</div>'
						+	'<div class="file-permission">' + resp.permission + '</div>'
						+	'<div class="file-path" title="' + resp.path + '">'
						+	resp.path
						+	'</div>'
						+'</div>';

				$("#resultData").html(fileTemplate);
			},
			error: function(err) {
				$("#noResultsDiv").css("display", "block");
				$("#resultData").html("");
				console.log("Failure to invoke getFiles service. " + err);
			}
		});
	}



});