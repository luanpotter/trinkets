var $ = require('jquery');
var yawp = require('yawp');

$('#convert').on('click', function () {
	var table = $('#input').val();
	$('#output').text('Loading...');
	yawp('/trinkets').json({ table : table }).put('table-maker').then(function (r) {
		$('#output').text(r.table);
	});
});
