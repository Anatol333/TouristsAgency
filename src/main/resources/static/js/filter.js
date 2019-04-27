// var priceInput = $('#age');
// var nameInput = $('#name');
// var url = $('#dynamic-url');
//
// priceInput.on('change', function() {
//
//     if($(this).val() !== "" && nameInput.val() !== "") {
//         url.attr('href', '/buy(age=' + $(this).val() + ', name=' + name.val() + ')');
//     } else if ($(this).val() !== "") {
//         url.attr('href', '/buy(age=' + $(this).val() + ')');
//     } else if (nameInput.val() !== "") {
//         url.attr('href', '/buy(name=' + nameInput.val() + ')');
//     }
//
// });
//
// nameInput.on('change', function() {
//     if($(this).val() !== "" && priceInput.val() !== "") {
//         url.attr('href', '/userinfo(age=' + priceInput.val() + ', name=' + $(this).val() + ')');
//     } else if ($(this).val() !== "") {
//         url.attr('href', '/userinfo(name=' + $(this).val() + ')');
//     } else if (priceInput.val() !== "") {
//         url.attr('href', '/userinfo(age=' + priceInput.val() + ')');
//     }
// })

var priceInput = $('#price');
var nameInput = $('#name');
var url = $('#dynamic-url');

priceInput.on('change', function () {
    //
    // if($(this).val() !== "" && nameInput.val() !== "") {
    //     url.attr('href', '/buy/' + $(this).val() + '/' + name.val());
    // } else if ($(this).val() !== "") {
    //     url.attr('href', '/buy/' + $(this).val());
    // } else if (nameInput.val() !== "") {
    //     url.attr('href', '/buy/' + nameInput.val());
    // }
    // if (nameInput.val() !== "" && $(this).val() !== "") {
    //     url.attr('href', '/buy/' + priceInput.val() + '/' + name.val());
    // } else {
    //     url.attr('href', '/buy/' + priceInput.val());
    // }
    if ($(this).val() !== "" && nameInput.val() !== "") {
        url.attr('href', '/buy/' + priceInput.val() + '/' + $(this).val());
    } else if ($(this).val() !== "") {
        url.attr('href', '/buy/' + priceInput.val() + '/' + "null");
    }
});

nameInput.on('change', function () {
    if ($(this).val() !== "" && priceInput.val() !== "") {
        url.attr('href', '/buy/' + priceInput.val() + '/' + $(this).val());
    } else if ($(this).val() !== "") {
        url.attr('href', '/buy/' + 0 + '/' + $(this).val());
    }
    //
    // if ($(this).val() !== "" && priceInput.val() !== "") {
    //     url.attr('href', '/buy/' + priceInput.val() + '/' + $(this).val());
    // } else if ($(this).val() !== "") {
    //     url.attr('href', '/buy/' + 999999999 + '/' + $(this).val());
    // } else if (priceInput.val() !== "") {
    //     url.attr('href', '/buy/' + priceInput.val());
    // }
});