<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Animal Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>Animal Details</h1>
        
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${animal.name}</h5>
                <p class="card-text">
                    <strong>ID:</strong> ${animal.animalId}<br>
                    <strong>Description:</strong> ${animal.description}
                </p>
                <div class="mt-3">
                    <a href="/animals/update/${animal.animalId}" class="btn btn-warning">Edit</a>
                    <a href="/animals/all" class="btn btn-secondary">Back to List</a>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html> 