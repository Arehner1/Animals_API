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
                    <td>${animal.animalId}</td>
                    <td>${animal.name}</td>
                    <td>${animal.description}</td>
                    <td>
                        <a href="/animals/${animal.animalId}" class="btn btn-info btn-sm">View</a>
                        <a href="/animals/update/${animal.animalId}" class="btn btn-warning btn-sm">Edit</a>
                        <form action="/animals/delete/${animal.animalId}" method="post" style="display: inline;">
                            <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</button>
                        </form>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html> 