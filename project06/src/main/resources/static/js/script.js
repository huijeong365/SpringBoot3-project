window.open("popup/popup.html", "", "resizable=no, toolbar=no, width=620px, height=500px")

$(function(){
	/* notice banner */
	var current = 0;
	var banner = $('.noticeBanner a');
	var stop;
	
	function timer(){
		stop=setInterval(function(){
		var prev = banner.eq(current);
		move(prev, '0%', '-100%');
		current++;
		if(current==banner.size()) current=0;
		var next = banner.eq(current);
		move(next, '100%', '0%');
		},2000);
	}
	
	function move(tg, start, end){
		tg.css('left',start).stop().animate({left:end},{duration:500, ease:'easeOutCubic'});
	}
	
	banner.hover(
		function(){
			clearInterval(stop);
		},
		function(){
			timer();
		}
	);
	timer(); 
	
	
	
	/* airservice 슬라이드 메뉴 */
	window.mySwipe = $('#mySwipe').Swipe({
		auto: 2000, 
		continuous : true,
		stopPropagation: true,
		callback : function(index, element){
			$('.touch_bullet .active').attr('src', $('.touch_bullet .active').attr('src').replace('on.png','off.png')).removeClass('active');
			$('.touch_bullet img').eq(index).attr('src', $('.touch_bullet img').eq(index).attr('src').replace('off.png','on.png')).addClass('active');
		}
	}).data('Swipe');
    
	/* 비주얼 이전, 다음 버튼 */
	$('.touch_left_btn a').on('click', function(){
		mySwipe.prev();
		return false;
	});
	$('.touch_right_btn a').on('click', function(){
		mySwipe.next();
		return false;
	});
		$('.start a').on('click', function(){
		mySwipe.begin();
		return false;
	});
	$('.stop a').on('click', function(){
		mySwipe.stop();
		return false;
	});

	
	
	
	


	/* 탭메뉴 (#airServiceBooking)*/
	$('#airServiceBooking').each(function(){
		var topDiv = $(this);
		var anchors = topDiv.find('ul.tabs a');
		var panelDivs = topDiv.find('div.tabItem');
		var lastAnchor;
		var lastPanel;
		
		anchors.show();
		lastAnchor = anchors.filter('.on');
		lastPanel = $(lastAnchor.attr('href'));
		panelDivs.hide();
		lastPanel.show();
		
		anchors.click(function(event){
			event.preventDefault();
			var currentAnchor = $(this);
			var currentPanel = $(currentAnchor.attr('href'));
			
			//같은 탭이라면 중단
			if(currentAnchor.get(0) === lastAnchor.get(0)){
				return;
			}
			
			lastPanel.stop().slideUp(200, function(){
				lastAnchor.removeClass('on');
				currentAnchor.addClass('on');
				currentPanel.stop().slideDown(200);
				lastAnchor = currentAnchor;
				lastPanel = currentPanel;
			});
		});
	});

    /* 아이콘배너 */
	$('#iconBanner li').hover(
		function(){
			$(this).parents('#mainIconBanner').stop().animate({height:'300px'},300);
		},function(){
			$(this).parents('#mainIconBanner').stop().animate({height:'220px'},300);
		}
	);

	$('#iconBanner li').hover(
		function(){
			$(this).find('.bannerText').show();
		},function(){
			$(this).find('.bannerText').hide();
		}
	);

	/* 팝업 */

	if($.cookie('pop12')!='no12') {$('.popWrap').show();};
	$('.popWrap').css('cursor','move').draggable();

	$('.popCloseBtn').on('click',function(){
		$('.popWrap').fadeOut('fast');
		return false;
	});

	$('.popTodayBtn').on('click',function(){
		$.cookie('pop12','no12',{expire:1});
		$('.popWrap').fadeOut('fast');
		return false;
	});

	/* 가이드 배너 */
	 var swiper = new Swiper('.mainGuide', {
      slidesPerView: 3,
	  autoplay : true,
	  continuous : true,
	  loop: true,
      direction: getDirection(),
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      }
      
    });

    function getDirection() {
      var windowWidth = window.innerWidth;
      var direction = window.innerWidth <= 760 ? 'vertical' : 'horizontal';

      return direction;
    }

	

});

