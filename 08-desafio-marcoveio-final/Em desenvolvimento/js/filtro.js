function filtrar() {
   $('.botao-filtro').on('click', function () {
        var $target = $(this).data('etiqueta');
        if ($target != 'todos') {
            $('.table tr').css('display', 'none');
            $('.table tr[data-status="' + $target + '"]').fadeIn('slow');
        } else {
            $('.table tr').css('display', 'none').fadeIn('slow');
        }
    });
}

