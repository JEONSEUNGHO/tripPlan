$(document).ready(function() {
				$('#test').click(function() {
					$('#sgsg').append('<div class="sgDiv">kkkkk</div>');
				});
				
				
			});
			
			$(document).on('click', '.sgDiv', function() {
				alert('승구');
			});