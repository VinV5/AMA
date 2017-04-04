/**
 * Created by nur-sh on 2017-03-06.
 */


$('.question').click(function(e) {
    var input = $(this).siblings('input')
    if(input.hasClass('hidden')){
        e.preventDefault();
    } else {
        $(this).unbind('submit').submit();
    }
    input.toggleClass('hidden');
});

