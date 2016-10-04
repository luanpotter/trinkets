var $ = require('jquery');
var yawp = require('yawp');

$('#convert').on('click', function () {
	var table = 'hue';
	yawp('/trinkets').json({ table : table }).put('table-maker').then(function (r) {
		console.log(r);
	});
	$('#output').text($('#input').val());
});
