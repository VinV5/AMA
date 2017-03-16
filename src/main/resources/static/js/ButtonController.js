/**
 * Created by nur-sh on 2017-03-06.
 */
$('.liker').click(function(e) {
    $('.counter').html(function(i, val) { return +val+1 });
});

$('.question').click(function(e) {
    var input = $(this).siblings('input')
    if(input.hasClass('hidden')){
        e.preventDefault();
    } else {
        $(this).unbind('submit').submit();
    }
    input.toggleClass('hidden');
})


$( '.questionlist' ).on('click', '.answer', function(e) {
    alert( $(this).siblings('input').val() );
});