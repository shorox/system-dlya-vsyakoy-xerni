$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/employee"
    }).then(function(data) {
       $('.greeting-id').append(data._links.profile.href);
       $('.greeting-content').append(data.page.size);
    });
});