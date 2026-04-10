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
    </nav>

    <div class="container my-5 text-center">
        <img src="/images/kikoru.jpg" alt="Kikoru Shinomiya" class="img-fluid mb-4">

        <h1>${foundCharacter.name}</h1>

        <h2> Role </h2>
        <p> ${foundCharacter.description}</p>

        <h2> Universe </h2>
        <p> ${foundCharacter.universe} </p>

        <h2> A Little Bit About Kikoru</h2>
        <p> ${foundCharacter.role} </p>
    </div>
</body>

</html>