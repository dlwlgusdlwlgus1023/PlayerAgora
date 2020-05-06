
var $window = $(window),
	$mainHeader = $('#main-header'),
	$defaultLogo = 'images/Logo.JPG' ,
	$smallLogo = 'images/Logo-shrink.JPG' ;

	$window.scroll(function() {
		if($(this).scrollTop() > 100){
			if(!$mainHeader.hasClass('shrink')){
				$mainHeader.addClass('shrink');
				switchImages($smallLogo);
			}
		}else{
			if($mainHeader.hasClass('shrink')){
				$mainHeader.removeClass('shrink');
				switchImages($defaultLogo);
			}
		}
	});
	//switchImages 함수
	function switchImages(newPath) {
		var $logo = $('#logo');
		$logo.fadeOut(300, function(){
			$logo.attr('src', newPath);
			$logo.fadeIn(300)
		}); //jqurey fadeout
	}

	