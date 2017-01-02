$(document).ready(function() {
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".timeline"); //Fields wrapper
    var add_button      = $(".add_root_btn"); //Add button ID
    
    var x = 1; //initlal text box count
    $(wrapper).on("click",".add_root_btn", function(e){ //user click on remove text
    	 e.preventDefault();
         if(x < max_fields){ //max input box allowed
             x++; //text box increment
             $(wrapper).append('<li class="timeline-milestone is-completed timeline-start"><div class="timeline-action"><table border="1" width="600" height="400"><tr height="50"><td width="50" colspan="1">여행지</td><td width="200" colspan="2"><input id="origin-input" class="controls" type="text" name="sb_lat" placeholder="출발지를 입력해 주세요."></td><td width="200" colspan="2"><input id="destination-input" class="controls" type="text" name="sb_lon" placeholder="도착지를 입력해 주세요."></td><td colspan="1" width="150"><input type="radio" name="type" id="changemode-transit" checked="checked">대중교통</td></tr><tr height="250"><td width="50"colspan="1">내용</td><td width="550" colspan="5"><textarea rows="10" cols="100" name="sb_subcontent"></textarea></td></tr><tr height="50"><td width="50" colspan="1">교통비</td><td width="150" colspan="1"><input type="text" name="sb_tcharge"></td><td width="50" colspan="1">식비</td><td width="150" colspan="1"><input type="text" name="sb_fcharge"></td><td width="50" colspan="1">숙박비</td><td width="150" colspan="1"><input type="text" name="sb_rcharge"></td></tr><tr height="50" ><td colspan="6" width="600"><button class="btn btn-primary add_root_btn"><i class="fa fa-plus">경로생성</i></button><button class="btn btn-danger remove-btn">경로 삭제</button></td></tr></table></div></li>'); //add input box
         }
    });
    $(wrapper).on("click",".remove-btn", function(e){ //user click on remove text
        e.preventDefault(); $(this).closest('li.timeline-start').remove(); x--;
    });
});