/**
 * @author Rosteach
 */

$(document).ready(function(){
    /* start */
    $(".item").hover(
        function(){
	       $(this).css("background","whitesmoke");
        }
        ,             
        function(){
            $(this).css("background","gainsboro");
        }
    );
    /* end */
});