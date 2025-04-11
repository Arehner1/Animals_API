<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Animal List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Animal List</h1>
        <a href="/animals/new" class="btn btn-primary mb-3">Add New Animal</a>

        <form action="/animals/search" method="get" class="mb-3">
            <div class="input-group">
                <input type="text" name="name" class="form-control" placeholder="Search by name" required>
                <button class="btn btn-outline-primary" type="submit">Search</button>
            </div>
        </form>
        
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <#list animals as animal>
                <tr>
                    <td>${animal.animalId?c}</td>
                    <td>${animal.name}</td>
                    <td>${animal.description}</td>
                    <td>
                        <a href="/animals/${animal.animalId?c}" class="btn btn-info btn-sm">View</a>
                        <a href="/animals/update/${animal.animalId?c}" class="btn btn-warning btn-sm">Edit</a>
                        <a href="/animals/delete/${animal.animalId?c}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>


                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>