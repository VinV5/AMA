/**
 * Created by ahmadholpa on 3/2/2017.
 */

    var amaid = $('#amaid').text().trim();
    var questionid = $('#questionid').text().trim();

    var list = $('.answerlist');
    $.ajax({
        url: "/ama/"  + amaid +"/question/"+ questionid +"/answers"
        }).then(function(data) {
            var list = $('.answerlist');
            $.each(data, function(key, value) {
                var par = '<div class="well well-lg">'
                    par += '<div class="vote test">'
                    par += '<p>' + value.content+ '</p>'
                    par += '</div>';
                list.append(par);

        });
    });