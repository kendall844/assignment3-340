<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
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

    <div class="container" style="margin-top: 15px;">
        <h1>${title}</h1>
        <p>${errorMessage}</p>
        <a href="/gallery" class="btn btn-outline-primary">Back to Home</a>

</body>

</html>