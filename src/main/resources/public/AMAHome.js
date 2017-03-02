/**
 * Created by ahmadholpa on 3/2/2017.
 */
$(document).ready(function() {

    $.ajax({
        url: "http://rest-service.guides.spring.io/greeting"
    }).then(function(data) {
        /*
        for (i=0; data.length;i++) {
            $('.AMA-author').append(data[i].author);
            $('.AMA-description').append(data[i].description);
        }
        */
        $('.AMA-author').append(data.id);
        $('.AMA-description').append(data.content);
    });
});