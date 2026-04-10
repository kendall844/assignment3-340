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
    <div class="container my-5">
        <h1 class="mb-4 text-center">${title}</h1>

        <form action="/characters/" method="post" enctype="multipart/form-data">

            <div class="mb-3">
                <label class="form-label">Character Name</label>
                <input type="text" name="name" class="form-control">
            </div>

            <div class="mb-3">
                <label class="form-label">Image</label>
                <input type="file" name="picture" class="form-control">
            </div>

            <div class="mb-3">
                <label class="form-label">Role</label>
                <input type="text" name="role" class="form-control">
            </div>

            <div class="mb-3">
                <label class="form-label">Universe</label>
                <input type="text" name="universe" class="form-control">
            </div>

            <div class="mb-3">
                <label class="form-label">Description</label>
                <textarea name="description" class="form-control" rows="4"></textarea>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Add Character</button>
            </div>

        </form>
    </div>

</body>

</html>
</nav>

</body>

</html>