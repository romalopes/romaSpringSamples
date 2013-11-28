$(document).ready(function() {
    $.ajax({      //jquery method to use ajax
        url: "http://localhost:8080/greeting"
    }).then(function(data) {    //receive the JSON data
       $('.greeting-id').append(data.id);
       $('.greeting-content').append(data.content);
    });
});