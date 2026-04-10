<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
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

    <div class="container my-5 text-center">
        <img src="/images/${character.picturePath!'default.jpeg'}" alt="${character.name}">
        <h1>${character.name}</h1>

        <h2> Role </h2>
        <p> ${character.role}</p>

        <h2> Universe </h2>
        <p> ${character.universe} </p>

        <h2> A Little Bit About ${character.name}</h2>
        <p> ${character.description} </p>
    </div>

    <form action="/characters/update/${character.characterId?c}" method="post" enctype="multipart/form-data">

        <input type="text" name="name" value="${character.name}" />
        <input type="text" name="universe" value="${character.universe}" />
        <input type="text" name="role" value="${character.role}" />
        <textarea name="description">${character.description}</textarea>

        <input type="file" name="picture" />

        <button type="submit">Update</button>

        <a href="/characters/delete/${character.characterId?c}" class="btn btn-danger" style="float:right;">
            Delete
        </a>
    </form>
</body>

</html>