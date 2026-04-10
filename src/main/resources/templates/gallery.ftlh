<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Character Gallery</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/style.css">

</head>

<body>

    <nav class="navbar navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/characters/">Female Anime Character Gallery</a>

            <form class="d-flex ms-4">
                <input class="form-control form-control-sm" type="search" placeholder="Search">
            </form>

            <ul class="navbar-nav flex-row ms-auto">
                <li class="nav-item mx-2">
                    <a class="nav-link" href="/characters/">Home</a>
                </li>
                <li class="nav-item mx-2">
                    <a class="nav-link" href="/characters/about">About</a>
                </li>
                <li class="nav-item mx-2">
                    <a class="nav-link" href="/characters/add">Add a Character</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container my-4">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-5 g-3">

            <#list gallery as character>

                <div class="col">
                    <div class="card h-100">

                        <a href="/characters/view/${character.characterId}">
                            <img src="/images/${character.picturePath!'kikoru.jpg'}" class="card-img-top" alt="${character.name}">
                        </a>

                        <div class="card-body">
                            <h5 class="card-title">${character.name}</h5>
                            <p class="card-text">${character.description}</p>
                        </div>

                    </div>
                </div>
            </#list>

        </div>
    </div>


</body>

</html>