jQuery(document).ready(function($) {

			/* for top navigation */
			$(" #menu ul ").css({
						display : "none"
					}); // Opera Fix
			$(" #menu li").hover(function() {
						$(this).find('ul:first').css({
									visibility : "visible",
									display : "none"
								}).slideDown(400);
					}, function() {
						$(this).find('ul:first').css({
									visibility : "hidden"
								});
					});

			$('a[href=#top]').click(function() {
						$('html, body').animate({
									scrollTop : 0
								}, 'slow');
						return false;
					});
		});