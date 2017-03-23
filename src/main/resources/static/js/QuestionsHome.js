
    var amaid = $('#amaid').text().trim();
    var list = $('.questionlist');
    list.empty();


    $.ajax({
     url: "/ama/"  + amaid + "/questions"
    }).then(function(data){
            $.each(data, function(key, value) {
                if(value.content !== "") {
                 var par = '<div class="well">';
                    par += '<p><a href="'+amaid+'/question/'+value.id+'">'+ value.content +'</a>QuestionHome</p>';
                    par += '</div>';
                    list.append(par);
                    console.log(value.id);
                }// end if
            });// end  each loop
    });// end data function
