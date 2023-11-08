import { initializeApp } from "https://www.gstatic.com/firebasejs/10.3.1/firebase-app.js";
import { getAnalytics } from "https://www.gstatic.com/firebasejs/10.3.1/firebase-analytics.js";
import { getStorage, ref, listAll, uploadBytes, getDownloadURL } from "https://www.gstatic.com/firebasejs/10.3.1/firebase-storage.js";

// Your web app's Firebase configuration
const firebaseConfig = {
    apiKey: "AIzaSyAHlHXi0btAaCP1R8hXstMVcmjEJiHNRZU",
    authDomain: "sms-eduzone.firebaseapp.com",
    projectId: "sms-eduzone",
    storageBucket: "sms-eduzone.appspot.com",
    messagingSenderId: "1026159732005",
    appId: "1:1026159732005:web:168fdb0de95cbdfcd8a6cc"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
