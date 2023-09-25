const subjectResultsBox = document.querySelector(".subject-result-box");
const subjectInputBox = document.getElementById("subject-input-box");

subjectInputBox.onkeyup = function () {
    let subjectResult = [];
    let subjectInput = subjectInputBox.value;
    if (subjectInput.length) {
        subjectResult = availableSubjects.filter((keyword) => {
            return keyword.toLowerCase().includes(subjectInput.toLowerCase());
        });
    }
    subjectDisplay(subjectResult);

    if (!subjectResult.length) {
        subjectResultsBox.innerHTML = '';
    }
};

function subjectDisplay(subjectResult) {
    const content = subjectResult.map((list) => {
        return "<li onclick=subjectSelectInput(this)>" + list + "</li>";
    });

    subjectResultsBox.innerHTML = "<ul>" + content.join('') + "</ul>";
}

function subjectSelectInput(list) {
    subjectInputBox.value = list.innerHTML;
    subjectResultsBox.innerHTML = "";
    subjectInputBox.focus();
}



