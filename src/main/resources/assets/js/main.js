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
            ),
            $("<input/>", {
                    type: 'button',
                    id: 'request',
                    value: 'Request'
                }
            )
        )
    );

    $("#keyForm input").click( function (event) {
        event.preventDefault();
        if ($(this).attr('value') === "Submit") {
                $.ajax({
                    url:'/make-document',
                    type:'POST',
                    data:$("#keyForm").serialize(),
                    success:function(data){
                        console.log(data.toString());
                    }
                });
        }
        if ($(this).attr('value') === "Request") {
                $.ajax({
                    url:'/get-document',
                    type:'GET',
                    data:$("#keyForm").serialize(),
                    success:function(data) {
                        console.log(data.toString());
                    }
                });
        }
    });

    // $("#keyForm").submit(function ( event ) {
    //     event.preventDefault();
    //     console.log("HALLO");
    //     $.ajax({
    //         url:'/make-document',
    //         type:'POST',
    //         data:$(this).serialize(),
    //         success:function(data){
    //             console.log(data.toString());
    //         }
    //     });
    // });

    // $("#keyForm button[id='request']").click(function (event) {
    //     event.preventDefault();
    //     console.log('HALLO');
    //     $.ajax({
    //         url:'/get-document',
    //         type:'GET',
    //         data:$(this).serialize(),
    //         success:function(data) {
    //             console.log(data.toString());
    //         }
    //     });
    // });


});



function changeButton() {
    document.getElementById("button").innerHTML = "YOU cLiCkEd ME!";
}

function log() {
    var document = $.getJSON("/get-document");
    console.log(document)
}
