$(document).ready(function(){
$('#loadFilms').on("click",function(){
    const character = $('#charInput').val();
    if(character){
        loadCharacter(character);
    }
})
})
function loadCharacter(character){
    $.ajax({
        url: `${apiBase}`,
        method: "GET",
        data: {name: character},
        success: function(response) {
            displayFilms(response.data);
        },
        error: function(error){
            console.error("Error fetching data", error);
        }
        
    })
}

function displayFilms(character) {
    const $filmList = $("#filmList");
    $filmList.empty();
    if(!character || (!character.films && !character.shortFilms && !character.tvShows)){
        $filmList.text("No films found for this character.");
        return;
    }

    const films = character.films || [];
    const shortFilms = character.shortFilms || [];
    const tvShows = character.tvShows || [];
    $filmList.append($("<h3>").text("Films"));
    const filmsList = $("<ul>");
    if(films.lenght === 0){
        filmsList.append($("<li>").text("No films available."));
    } else {
        films.forEach(film => {
            const filmItem = $("<li>").text(film);
            filmsList.append(filmItem);
        });
    }
    $filmList.append(filmsList);

    $filmList.append($("<h3>").text("Short Films"));
    const shortFilmsList = $("<ul>");
    if(shortFilms.lenght === 0){
        shortFilmsList.append($("<li>").text("No short films available."));
    } else {
        shortFilms.forEach(shortFilm => {
            const sfilmItem = $("<li>").text(shortFilm);
            shortFilmsList.append(sfilmItem);
        });
    }
    $filmList.append(shortFilmsList);
    
    $filmList.append($("<h3>").text("TV Shows"));
    tvShowsList = $("<ul>");
    if(tvShows.lenght === 0){
        tvShowsList.append($("<li>").text("No short films available."));
    } else {
        tvShows.forEach(show => {
            const showItem = $("<li>").text(show);
            tvShowsList.append(showItem);
        });
    }
    $filmList.append(tvShowsList);
}
