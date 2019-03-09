$(document).ready(function () {
    $("div#documentForm").append(
        $("<h3/>").text("Maak een document of vraag een document aan"), $("<form/>", {
            id: 'keyForm'
        }).append(
            $("<input/>", {
                type: 'text',
                id: 'key',
                name: 'key',
                placeholder: 'Document key',
                width: '400px'
                }
            ),
            $("<br/>"),
            $("<input/>", {
                type: 'submit',
                id: 'submit',
                value: 'Submit'
                }
            )
        )
    );

    $("#keyForm").submit(function ( event ) {
        event.preventDefault();
        $.ajax({
            url:'/make-document',
            type:'POST',
            data:$(this).serialize(),
            success:function(){
                console.log("REQUEST GEMAAKT");
            }
        });
    });

});



function changeButton() {
    document.getElementById("button").innerHTML = "YOU cLiCkEd ME!";
}

function log() {
    var document = $.getJSON("/get-document");
    console.log(document)
}
