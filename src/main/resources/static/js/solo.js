/**
 * Created by nur-sh on 2017-03-06.
 */
$('a').click(function(e) {
    e.preventDefault();
})

$('.liker').click(function(e) {
    $('.counter').html(function(i, val) { return +val+1 });
})