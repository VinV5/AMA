function loadQuestions() {
    var amaid = $('#amaid').text();
 $.ajax({
     url: "/ama/"  + amaid + "/questions"
    }).then(function(data){
            var list = $('.questionlist');
            $.each(data, function(key, value) {
                var par = '<div class="well">';
                par += '<p> '+ value.content +'</p>';
                par += '</div>';
                list.append(par);
            });
    });
}