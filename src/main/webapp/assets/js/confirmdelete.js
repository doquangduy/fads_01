$(function() {
	$('a.delete').click(function(e) {
		if (window.confirm('Are you delete record, you wish to continue?')) {
			window.open($(this).attr('href'));
		}
		e.preventDefault();
	});
});