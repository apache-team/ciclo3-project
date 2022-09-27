function DeleteTransaction(id) {
    Swal.fire({
        title: '¿Esta segur@?',
        text: "¡No podrás revertir esto!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sí, eliminar!',
        cancelButtonText: 'Cancelar!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: "/deleteTransaction/" + id,
                success: function (res) {
                    $("#data").load(window.location + " #data");
                }
            });
            Swal.fire(
                'Eliminado!',
                'Registro eliminado con éxito.',
                'success'
            )
        }
    })
}