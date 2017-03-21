
    var amaid = $('#amaid').text();
    var list = $('.questionlist');
    list.empty();


    $.ajax({
     url: "/ama/"  + amaid + "/questions"
    }).then(function(data){
            $.each(data, function(key, value) {
                if(value.content !== "") {
                 var par = '<div class="well">';
                    par += '<p><a href="question/'+value.id+'">'+ value.content +'</a></p>';
                    par += '</div>';
                    list.append(par);
                }// end if
            });// end  each loop
    });// end data function
