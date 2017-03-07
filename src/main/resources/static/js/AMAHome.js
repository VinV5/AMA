/**
 * Created by ahmadholpa on 3/2/2017.
 */


    $.ajax({
        url: "http://rest-service.guides.spring.io/greeting"
    }).then(function(data) {
        $('.AMA-author').append(data.id);
        $('.AMA-description').append(data.content);
    });