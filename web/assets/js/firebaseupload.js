// file-upload.js
import { getStorage, ref, uploadBytes } from "https://www.gstatic.com/firebasejs/10.3.1/firebase-storage.js";

// Handle file upload form submission
document.getElementById('fileUploadForm').addEventListener('submit', (e) => {
     

    const file = document.getElementById('fileInput').files[0];

    if (file) {
        const storage = getStorage();
        const storageRef = ref(storage, file.name);

        uploadBytes(storageRef, file).then(() => {
            alert('File uploaded successfully!');
            document.getElementById('fileInput').value = ''; // Clear the file input
        }).catch((error) => {
            console.error('Error uploading file:', error);
            alert('File upload failed. Please try again.');
        });
    } else {
        alert('Please select a file to upload.');
    }
});
