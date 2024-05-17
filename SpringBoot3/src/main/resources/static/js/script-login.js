$(function(){
    /* 로그인 guideText */
    //'guide' = css(.guide)
    var guideClass = 'guide';
    $('#login .guideText').each(function(){
        var guideText = this.defaultValue;
        var element = $(this);
        var id = $('#login #id');
        var pwd = $('#login #pwd');
        pwd.focus(function(){
            if(pwd.val()===guideText){
                pwd.val('');
                pwd.removeClass(guideClass);
            }
            pwd.attr('type','password');
        });
        id.focus(function(){
            if(id.val()===guideText){
                id.val('');
                id.removeClass(guideClass);
            }
        });
        element.blur(function(){
            if(element.val()===''){
                element.val(guideText);
                element.addClass(guideClass);
                pwd.attr('type','text');
            }
        });
        if(element.val()===guideText){
            element.addClass(guideClass);
        }
    });

   
});