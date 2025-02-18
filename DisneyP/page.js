$(document).ready(function(){
    $('#homePage').removeClass('hidden');
    $('#ch').css('display','none');
    $('#film').css('display','none');
    $('#linkHome').click(function(event) {
        event.preventDefault();
        loadSection('homePage');
    });
    $('#linkChar').click(function(event) {
        event.preventDefault();
        loadSection('ch');
    });
    $('#linkFilm').click(function(event) {
        event.preventDefault();
        loadSection('film');
    });
    $('#linkFav').click(function(event) {
        event.preventDefault();
        loadSection('fav');
    });
})
function loadSection(sectionId) {
    $('#homePage').addClass('hidden');
    $('#ch').css('display','none');
    $('#film').css('display','none');
    $('#fav').addClass('hidden');

    $('#' + sectionId).removeClass('hidden');
    if(sectionId === 'ch') {
        $('#ch').css('display','flex');
    }
    else if(sectionId === 'film'){
        $('#film').css('display','flex');
    }
}