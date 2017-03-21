
/**
 * Created by nur-sh on 2017-03-21.
 */


$('.done').click(function(e) {
    e.preventDefault();
    if($('#name').val() === '' || $('#password').val() === ''){
        $('.alert').append("The fields cannot be empty");
        $('.alert').removeClass('hidden');
    } else {
        $('.signup').submit();
    }
})