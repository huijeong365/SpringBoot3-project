$(function(){
    /* 날씨 (서울)*/
    $.getJSON('http://api.openweathermap.org/data/2.5/weather?id=1835848&appid=eb57196cf4ecd600ea40fe1ab4bd682e&units=metric', function(data){
				
		var minTemp = Math.ceil(data.main.temp_min) + ' ℃';
		var maxTemp = Math.ceil(data.main.temp_max) + ' ℃';
		var cTemp = Math.ceil(data.main.temp) + ' ℃';
		var cIcon = data.weather[0].icon;
		
		var now = new Date(Date.now());
		var month = now.getMonth()+1;
		var hours = now.getHours();
		var hour = now.getHours() + '시 ' + now.getMinutes() + '분 ';
		var date = month + '월 ' + now.getDate()+ '일 ';
    
		
		if(hours >= 18){
			$('.weather1').css('background','linear-gradient(135deg, #7d7e7d 0%,#0e0e0e 100%)');
		} else if(hours >= 12) {
			$('.weather1').css('background','linear-gradient(135deg, #ffb76b 0%,#ffa73d 5%,#ff7c00 50%,#ff7f04 100%)');
		} else if(hours >= 7) {
			$('.weather1').css('background','linear-gradient(135deg, #7db9e8 5%,#7db9e8 17%,#2989d8 54%,#2989d8 54%,#1e5799 94%,#1e5799 100%)');
		} else {
            $('.weather1').css('background','linear-gradient(135deg, rgba(35,83,138,1) 0%,rgba(167,207,223,1) 100%)');
        }
	
	
		$('.ctemp1').append(cTemp);
		$('.clowtemp1').append(minTemp);
		$('.chightemp1').append(maxTemp);
		$('.hour1').append(hour);
		$('.date1').append(date);
		$('.cicon1').append('<img src="images/weather/'+cIcon+'.png"/>');
	
		
	});

     /* 날씨 (런던)*/
    $.getJSON('http://api.openweathermap.org/data/2.5/weather?id=2643743&appid=eb57196cf4ecd600ea40fe1ab4bd682e&units=metric', function(data){
				
		var minTemp = Math.ceil(data.main.temp_min) + ' ℃';
		var maxTemp = Math.ceil(data.main.temp_max) + ' ℃';
		var cTemp = Math.ceil(data.main.temp) + ' ℃';
		var cIcon = data.weather[0].icon;
		
		var now = new Date(Date.now());
		var month = now.getMonth()+1;
		var hours = now.getHours()-9;
		var hour = now.getHours()-9 + '시 ' + now.getMinutes() + '분 ';
		var date = month + '월 ' + now.getDate()+ '일 ';
		
		if(hours >= 18){
			$('.weather2').css('background','linear-gradient(135deg, #7d7e7d 0%,#0e0e0e 100%)');
		} else if(hours >= 12) {
			$('.weather2').css('background','linear-gradient(135deg, #ffb76b 0%,#ffa73d 5%,#ff7c00 50%,#ff7f04 100%)');
		} else if(hours >= 7) {
			$('.weather2').css('background','linear-gradient(135deg, #7db9e8 5%,#7db9e8 17%,#2989d8 54%,#2989d8 54%,#1e5799 94%,#1e5799 100%)');
		} else {
            $('.weather2').css('background','linear-gradient(135deg, rgba(35,83,138,1) 0%,rgba(167,207,223,1) 100%)');
        }
	
	
		$('.ctemp2').append(cTemp);
		$('.clowtemp2').append(minTemp);
		$('.chightemp2').append(maxTemp);
		$('.hour2').append(hour);
		$('.date2').append(date);
		$('.cicon2').append('<img src="images/weather/'+cIcon+'.png"/>');
	
	});
});