$(document).ready(function(){
    /* start */
    $(".files").on('change', function(e){
        var filesCollection = [];
        var files = e.target.files;
            
        $.each(files, function(i,file){
            filesCollection.push("- "+file.name+"\n");    
        });
        $(".textL").val(filesCollection);
    });
    /* end */
    /* start back */
    $(".back img").hover(
        function(){
	        $(this).stop().animate({width: "35px", height:"35px"});
        }
        ,             
        function(){
            $(this).stop().animate({width: "30px", height:"30px"});
        }
    );
    /* end */
    /* start info */
    $(".info img").hover(
        function(){
	        $(this).stop().animate({width: "35px", height:"35px"});
        }
        ,             
        function(){
            $(this).stop().animate({width: "30px", height:"30px"});
        }
    );
    /* end */
    /* start */
    $(".leftTA").hover(
        function(){
	       $(this).stop().css({"border-color": "#6AAFCC"});
        }
        ,             
        function(){
            $(this).stop().css({"border-color": "#c0c0c0"});
        }
    );
    $(".rightTA").hover(
        function(){
	       $(this).stop().css({"border-color": "#6AAFCC"});
        }
        ,             
        function(){
            $(this).stop().css({"border-color": "#c0c0c0"});
        }
    );
    $(".buttons").hover(
        function(){
	       $(this).stop().css({"border-color": "#8a2820"});
        }
        ,             
        function(){
            $(this).stop().css({"border-color": "#c0c0c0"});
        }
    );
    /* end */
    /* start */
    $(".butt").hover(
        function(){
	       $(this).stop().css({"border-color": "#8a2820"});
        }
        ,             
        function(){
            $(this).stop().css({"border-color": "whitesmoke"});
        }
    );
    /* end */
    /* start */
    $(".push").hover(
        function(){
	       $(this).stop().css({"backgroundColor": "#C7FFE1"});
        }
        ,             
        function(){
            $(this).stop().css({"backgroundColor":"#E6E3DC"});
        }
    );
    $(".uplFile").hover(
        function(){
	       $(this).stop().css({"backgroundColor": "#FFF2DB"});
        }
        ,             
        function(){
            $(this).stop().css({"backgroundColor":"#E6E3DC"});
        }
    );
    /* end */
    /* start */
    $(".butt:last").click(
    	function(){
        	$("textarea").val("");
            $(".files").val("");
        }      
    );
    /* end */
    /* bottom Bar */
    $(".bottomButt").hover(
    	function(){
	       $(this).stop().css({"backgroundColor": "#C8CCC2"});
        }
        ,             
        function(){
            $(this).stop().css({"backgroundColor":"whitesmoke"});
        }
    );
    /* end */
    /* bottom Bar */
    $(".pushButtRight").click( function(event){ // лoвим клик пo ссылки
		   //event.preventDefault(); // выключaем стaндaртную рoль элементa
		   $("#overlay").fadeIn(200, // снaчaлa плaвнo пoкaзывaем темную пoдлoжку
		 	function(){ // пoсле выпoлнения предъидущей aнимaции
				$("#loader") 
					.css("display", "block") // убирaем у мoдaльнoгo oкнa display: none;
					.animate({opacity: 1, top: "50%"}, 200); // плaвнo прибaвляем прoзрaчнoсть oднoвременнo сo съезжaнием вниз
		 });
	 });
    /* end */ 
});