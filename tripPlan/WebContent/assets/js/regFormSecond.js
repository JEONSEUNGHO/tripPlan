// preview Image Before Upload
function previewImageBeforeUpload() {
	alert("asasdasd");
	var element = $('.preview-img-upload');
	var reader;

	function readURL(input, selector) {
		if (input.files && input.files[0]) {
			reader = new FileReader();
			reader.onload = function(e) {
				selector.parents('.preview-img-upload').addClass('active')
						.find('.preview-img').attr('src', e.target.result);
			};
			reader.readAsDataURL(input.files[0]);
		}
	}

	function removeImage() {
		element.find('.remove-image').click(
				function() {
					$(this).parents('.preview-img-upload')
							.removeClass('active').find('.preview-img').attr(
									'src', '');
					$(this).parents('.preview-img-upload').find('input')
							.val('');
				});
	}
	removeImage();

	$(document.body).on('change', '.preview-img-upload input', function() {
		readURL(this, $(this));
	});

}
previewImageBeforeUpload();