/**
 * Created by nur-sh on 2017-03-06.
 */
$('.liker').click(function(e) {
    $('.counter').html(function(i, val) { return +val+1 });
});

$('.question').click(function(e) {
    var input = $('input');
    if(input.hasClass('hidden')){
        e.preventDefault();
    } else {
        $(this).unbind('submit').submit();
    }
    $('input').toggleClass('hidden');
})
$('#menu-toggle').click( function(){
    $(this).find('i').toggleClass('glyphicon-arrow-right').toggleClass('glyphicon-arrow-left');
});

function foo(){
    if( typeof foo.counter == 'undefined' ) {
        foo.counter = 0;
    }
    foo.counter++;
    alert(foo.counter);
}

$(document).ready( function(){
//        var logFlag= true;
//        alert(logFlag);
//        $(".navbar-right").append("<li><a href=\"login\"><span id=\"menu-login\" class=\"glyphicon glyphicon-log-in \"></span> Login</a></li>");
////            $('.navbar-nav navbar-right').append("<li><a href=\"logout\"><span id=\"menu-logout\" class=\"glyphicon glyphicon-log-out \"></span> Logout</a></li>");
//        logFlag = false;
});