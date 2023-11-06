// file-download.js
import { getStorage, ref, getDownloadURL } from "https://www.gstatic.com/firebasejs/10.3.1/firebase-storage.js";

function downloadFile(fileRef, fileName) {
    const storage = getStorage();
    const fileStorageRef = ref(storage, fileRef);

    getDownloadURL(fileStorageRef)
        .then((url) => {
            const link = document.createElement("a");
            link.href = url;
            link.download = fileName; // Specify the desired file name
            link.click();
        })
        .catch((error) => {
            console.error('Error getting download URL:', error);
            alert('File download failed. Please try again.');
        });
}

export { downloadFile };
