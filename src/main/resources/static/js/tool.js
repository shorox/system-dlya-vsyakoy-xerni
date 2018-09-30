$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/department"
    }).then(function(data) {
       $('.department-id').append(data.id);
       $('.department-name').append(data.name);
    });
});