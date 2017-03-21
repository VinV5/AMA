/**
 * Created by ahmadholpa on 3/2/2017.
 */    var amaid = $('#amaid').text();
       var list = $('.answerlist');
    $.ajax({
        url: "/ama/"  + amaid + "/answer"
           }).then(function(data) {
               var list = $('.answerlist');
               $.each(data, function(key, value) {
                   var par = '<div class="well well-lg">'
                   par += '<div class="vote test">'
                   par +=    '<span class="glyphicon glyphicon-circle-arrow-up liker block" aria-hidden="true"></span>'
                   par +=   '<span class="counter block">0</span> </div>'
                   par += '<p><a href="ama/' + value.id + '">' +  value.content+ '</a></p>'
                   par += '</div>';
                   list.append(par);

               });

           });
