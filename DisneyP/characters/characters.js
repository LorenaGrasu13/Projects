const apiBase = "https://api.disneyapi.dev/character";
let characterPage=1;

$(document).ready(function(){
$('#loadChar').on("click",function(){
    loadCharacters();
})
})
function loadCharacters(){
    $.ajax({
        url: `${apiBase}`,
        method: "GET",
        data: {page: characterPage, pageSize:10},
        success: function(response) {
            displayCharacters(response.data);
            characterPage++;
        },
        error: function(error){
            console.error("Error fetching data", error);
        }
        
    })
}

function displayCharacters(characters) {
    characters.forEach(character => {
        const card = $(`
            <div class="characterCard" data-character-name="${character.name}">
            <i id="favMark" class="fa-regular fa-star"></i>
            <div id="tableHeader">
                <p id="character-name">${character.name}</p>
            </div>
                <img src="${character.imageUrl}" alt="${character.name}" />
            </div>
        `);
        card.find("#favMark").on("click", function() {
            $(this).toggleClass("favorite");
        });
        if($(this).hasClass("favorite")){
            $("#favList").append(card.clone());
        } else{
            const characterName = character.name;
            const safeCharacterName = characterName.replace(/'/g, "\\'");
            $("#favList").find(`[data-character-name='${safeCharacterName}']`).remove();
        }
        $("#characterList").append(card);
    });
}
