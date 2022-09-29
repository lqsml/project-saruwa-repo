/* headerTmp */
$(function() {
    $("ul#gnbMainMenu>li.gnbMainLi").mouseover(function(){
        $("ul.gnbSubMenu").stop().fadeIn();
    });
    $("ul#gnbMainMenu>li.gnbMainLi").mouseout(function(){
        $("ul.gnbSubMenu").stop().fadeOut();
    });
});
