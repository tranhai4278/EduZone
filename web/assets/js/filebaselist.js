// file-list.js
import { getStorage, ref, listAll, getDownloadURL } from "https://www.gstatic.com/firebasejs/10.3.1/firebase-storage.js";

// List files in Firebase Storage
listAll(ref(getStorage(), '/')).then((result) => {
    result.items.forEach((itemRef) => {
        const listItem = document.createElement('li');
        const downloadLink = document.createElement('a');

        downloadLink.href = '#';
        downloadLink.innerText = itemRef.name;
        downloadLink.addEventListener('click', () => {
            getDownloadURL(itemRef).then((url) => {
                window.open(url);
            }).catch((error) => {
                console.error('Error getting download URL:', error);
                alert('File download failed. Please try again.');
            });
        });

        listItem.appendChild(downloadLink);
        document.getElementById('fileList').appendChild(listItem);
    });
}).catch((error) => {
    console.error('Error listing files:', error);
    alert('File listing failed. Please try again.');
});
