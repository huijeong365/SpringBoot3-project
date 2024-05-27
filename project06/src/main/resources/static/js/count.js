
    /* D-DAY COUNT */
	// 숫자 자릿수 나누기
	function unit(x){ //1의 자리 숫자 구하기
		var m = x%10
		return m
	}
	
	function tenth(y){ //10의 자리 숫자 구하기
		var m = y/10%10
		m = Math.floor(m)
		return m
	}
	
	function hund(z){ //100의 자리 숫자 구하기
		var m = z/100
		m = Math.floor(m)
		return m
	}
	
	// 카운트 함수 정의 
	
	function ddaycount(){
		imgArr = [
			'images/num0.png',
			'images/num1.png',
			'images/num2.png',
			'images/num3.png',
			'images/num4.png',
			'images/num5.png',
			'images/num6.png',
			'images/num7.png',
			'images/num8.png',
			'images/num9.png'
		]
		
		doomsday = new Date('May 30, 2025 00:00:00')
		today = new Date()
		howfar = doomsday - today
		
		if(howfar>0){
			setTimeout('ddaycount()',1000)
		} else {
			clearTimeout('ddaycount()')
			document.getElementById('countment').innerHTML='카운트가 종료되었습니다.'
			return false
		}
		
		days = Math.floor (howfar/(1000*60*60*24))
		hours = Math.floor (howfar/(1000*60*60))
		mins = Math.floor (howfar/(1000*60))
		secs = Math.floor (howfar/(1000))
		
		d = days
		h = hours-days*24
		m = mins-hours*60
		s = secs-mins*60
		
		document.getElementById('day100').setAttribute('src', imgArr[hund(d)])
		document.getElementById('day10').setAttribute('src', imgArr[tenth(d)])
		document.getElementById('day1').setAttribute('src', imgArr[unit(d)])
		document.getElementById('hour10').setAttribute('src', imgArr[tenth(h)])
		document.getElementById('hour1').setAttribute('src', imgArr[unit(h)])
		document.getElementById('min10').setAttribute('src', imgArr[tenth(m)])
		document.getElementById('min1').setAttribute('src', imgArr[unit(m)])
		document.getElementById('sec10').setAttribute('src', imgArr[tenth(s)])
		document.getElementById('sec1').setAttribute('src', imgArr[unit(s)])
		
		if(d<10){d='00'+d}else if(d<100){d='0'+d}
		if(h<10){h='00'+h}
		if(m<10){m='00'+m}
		if(s<10){s='00'+s}
	}

    ddaycount()
