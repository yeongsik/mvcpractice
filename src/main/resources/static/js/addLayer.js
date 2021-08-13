$(document).ready(function(){
    $("#addLayer").hide();

    $("#modal-btn").on("click" , function (){
        $(".main-content-container").css({'opacity' : 0.3});
        $("#addLayer").fadeIn();
        $("#addAuthor").focus();
        return false;
    });
    $("#addCancel").on("click" , function(){
        $("#addLayer").fadeOut();
        $(".main-content-container").css({'opacity' : 1});

    })
})