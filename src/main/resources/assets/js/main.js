function changeButton() {
    document.getElementById("button").innerHTML = "YOU cLiCkEd ME!";
}

function log() {
    var document = $.getJSON("/get-document");
    console.log(document)
}

// + "function changeButton() { document.getElementById('button').innerHTML = 'YOU CLICKED ME!' ;}"
// + "function log() { console.log('answer: ' + http://127.0.0.1:8088/get-document) }"
//                    + "function log() { console.log('HALO') }"
