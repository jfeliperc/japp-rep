function rota(){
    var metodo = $('input#metodo').val();
    $.post("./front/RouteBase.php", 
        {metodo: metodo},
        function(data){
        $('div#main').html(data);
    });
}

function rota(idDivRefresh){
    var metodo = $('input#metodo').val();
    $.post("./front/RouteBase.php", 
        {metodo: metodo},
        function(data){
        $('div#'+idDivRefresh).html(data);
    });
}

function rotaMenu(opcao){
    var metodo = $('input#opcao').val();
    $.post("./front/RouteMenu.php", 
        {metodo: metodo},
        function(data){
        $('div#wrapper').html(data);
    });
}

$(document).ready(function() {
    $('#testeBtn').click(function (){
        var param = $('input#campoTxt').val();
        $.post("./front/RouteBase.php", {metodo: param},function(data){
            $('div#main').html(data);
        });
    });
});



//$('#teste-red').on('click', function (){
//    alert('teste0002');
////    var param = $('input#campo-txt').val();
////    $.post("", {param: param},function(data){
////        $('div#main').text(data);
////    })
//});