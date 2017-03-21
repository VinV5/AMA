
/**
 * Created by nur-sh on 2017-03-21.
 */


$('.done').click(function(e) {
    e.preventDefault();
    if($('#name').empty() || $('#password').empty()){
        $('.alert').append("The fields cannot be empty");
        $('.alert').removeClass('hidden');
    } else {
        $(this).unbind('submit').submit();
    }
})