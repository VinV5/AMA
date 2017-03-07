/**
 * Created by vincentvu on 3/7/2017.
 */
$('.nav.nav-pills > li').on('click', function(e) {
    $('.nav.nav-pills > li').removeClass('active');
    $(this).addClass('active');
});