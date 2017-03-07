/**
 * Created by nur-sh on 2017-03-06.
 */
$('.liker').click(function(e) {
    $('.counter').html(function(i, val) { return +val+1 });
})