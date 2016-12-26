$(document).ready(function() {
    var max_fields      = 10; //maximum input boxes allowed
    var wrapper         = $(".timeline"); //Fields wrapper
    var add_button      = $(".add_root_btn"); //Add button ID
    
    var x = 1; //initlal text box count
    $(add_button).click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).append('<li class="timeline-milestone is-completed timeline-add"><div class="timeline-action"><input id="origin-input" class="controls" type="text" placeholder="출발지를 입력해 주세요."><input id="destination-input" class="controls" type="text" placeholder="도착지를 입력해 주세요."><div id="mode-selector" class="controls"><input type="radio" name="type" id="changemode-transit" checked="checked"><label for="changemode-transit">대중교통</label></div><div id="pass-div"><textarea class="controls" rows="10" cols="50"></textarea></div><div id="pass-div"><button class="btn btn-primary add_root_btn"><i class="fa fa-plus">경로생성</i></button></div><button class="btn btn-danger remove-btn">경로 삭제</button></div></li>'); //add input box
        }
    });
    $(wrapper).on("click",".remove-btn", function(e){ //user click on remove text
        e.preventDefault(); $(this).closest('li.timeline-add').remove(); x--;
    });
});