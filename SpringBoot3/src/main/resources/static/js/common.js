$(function(){ 

	/* 툴팁 */
	var balloon = $('<div class="balloon"></div>').appendTo('body');
	
	function updateBalloonPosition(x,y){
		balloon.css({ left: x +15 , top: y + 15});
		//balloon.css('left','x+15').css('top','y');
	}
	
	function showBalloon(){
		balloon.stop().css('opacity',0).show().animate({opacity:1},1000);
	}
	function hideBalloon(){
		balloon.stop().animate({opacity:0},1000,function(){
			balloon.hide();
		});
	}
	
	$('.showBalloon').each(function(){
		var element = $(this);
		var text = element.attr('title');
		element.attr('title','');
		element.hover(
			function(event){
				balloon.text(text);
				updateBalloonPosition(event.pageX, event.pageY); //pageX pageY : 브라우저에서 마우스의 위치
				showBalloon();
			},
			function(){
				hideBalloon();
			}
		);
		element.mousemove(function(event){
			updateBalloonPosition(event.pageX, event.pageY);
		});
	});


	/* 퀵메뉴 */
	var defaultTop = parseInt($('#quick_menu').css('top'));
	// defaultTop = top:176px;
	$(window).on('scroll',function(){
		var scv = $(window).scrollTop();
		if(scv<465){scv=465;};
		$('#quick_menu').stop().animate({top:scv+defaultTop+'px'}, 1000);
	});
	$('#quick_menu').css({top:'645px'},1000);
	


	/* 전체메뉴 */
	bb=true;
	$('.fifthMenu').on('click', function(){
		if(bb==true){
			$('.fifthMenu> .twoDepthWrap').slideDown();
			bb=false;
		} else {
			$('.fifthMenu> .twoDepthWrap').slideUp();
			bb=true;
		}
		return false;
	});


	/* 전체 메뉴 닫기 버튼 */
	$('#totalClose a').on('click', function(){
		$('.fifthMenu> .twoDepthWrap').slideUp();
		bb=true;
		return false;
	}); 

});