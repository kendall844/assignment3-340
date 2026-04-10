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
            <a class="navbar-brand" href="index.html">Female Anime Character Gallery</a>
            <form class="d-flex ms-4">
                <input class="form-control form-control-sm" type="search" placeholder="Search">
            </form>


            <ul class="navbar-nav flex-row ms-auto">
                <li class="nav-item mx-2">
                    <a class="nav-link" href="index.html">Home</a>
                </li>
                <li class="nav-item mx-2">
                    <a class="nav-link" href="details.html">Details</a>
                </li>
                <li class="nav-item mx-2">
                    <a class="nav-link" href="about.html">About</a>
                </li>
                <li class="nav-item mx-2">
                    <a class="nav-link" href="new-character-form.html">Add a Character</a>
                </li>
            </ul>
        </div>
        <div class="container my-5">
            <h1 class="mb-4 text-center">${title}</h1>

            <form>

                <div class="mb-3">
                    <label for="character-name" class="form-label">Character Name</label>
                    <input type="text" id="character-name" class="form-control" placeholder="Enter character name">
                </div>

                <div class="mb-3">
                    <label for="character-image" class="form-label">Image Filename or URL</label>
                    <input type="text" id="character-image" class="form-control" placeholder="images/character.jpg">
                </div>

                <div class="mb-3">
                    <label for="character-role" class="form-label">Role</label>
                    <input type="text" id="character-role" class="form-control" placeholder="Enter the role">
                </div>

                <div class="mb-3">
                    <label for="character-universe" class="form-label">Universe</label>
                    <input type="text" id="character-universe" class="form-control" placeholder="Enter the universe">
                </div>

                <div class="mb-3">
                    <label for="character-description" class="form-label">
                        Character Description
                    </label>
                    <textarea id="character-description" class="form-control" rows="4"
                        placeholder="Add a description here."></textarea>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-primary">
                        Add Character
                    </button>
                </div>

            </form>
        </div>

</body>

</html>
</nav>

</body>

</html>