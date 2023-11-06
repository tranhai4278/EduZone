<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Firebase File Upload</title>
    </head>
    <body>
        <h1>Firebase File Upload</h1>

        <!-- File Upload Form -->
        <h2>Upload File</h2>
        <form id="fileUploadForm">
            <input type="file" id="fileInput"/>
            <button type="submit">Upload</button>
        </form>

        <!-- Available Files List -->
        <h2>Available Files</h2>
        <ul id="fileList"></ul>

        <!-- Firebase Configuration -->
        <script type="module" src="assets/js/firebaseconfig.js"></script>

        <!-- Other JavaScript modules that depend on the Firebase configuration -->
        <script type="module" src="assets/js/firebaseupload.js"></script>
        <script type="module" src="assets/js/filebaselist.js"></script>
        <script type="module" src="assets/js/firebasedownload.js"></script>

    </body>
</html>
