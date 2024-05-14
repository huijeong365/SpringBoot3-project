$(function(){
    /* 로그인 guideText */
    //'guide' = css(.guide)
    var guideClass = 'guide';
    $('.guideText').each(function(){
        var guideText = this.defaultValue;
        var element = $(this);
        var name = $('#name');
        var pwd = $('#userPassword');
        var email = $('#email');
        var password = $('#password');
        var address = $('#address');
        password.focus(function(){
            if(password.val()===guideText){
                password.val('');
                password.removeClass(guideClass);
            }
            password.attr('type','password');
        });
        name.focus(function(){
            if(name.val()===guideText){
                name.val('');
                name.removeClass(guideClass);
            }
        });
        email.focus(function(){
            if(email.val()===guideText){
                email.val('');
                email.removeClass(guideClass);
            }
        });
        address.focus(function(){
            if(address.val()===guideText){
                address.val('');
                address.removeClass(guideClass);
            }
        });
        element.blur(function(){
            if(element.val()===''){ 
                element.val(guideText);
                element.addClass(guideClass);
                password.attr('type','text');
            }
        });
        if(element.val()===guideText){ 
            element.addClass(guideClass);
        }		
    });

   
});