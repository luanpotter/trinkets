var $ = require('jquery');
var yawp = require('yawp');

$('#convert').on('click', function () {
	yawp('/trinkets').json({ key : 'test' }).get('table-maker').then(function (r) {
		console.log(r);
	});
	$('#output').text($('#input').val());
});
