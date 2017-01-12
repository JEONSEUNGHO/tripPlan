$(function() {
   var thumbnail =  $('.thumbnail');
   var container = $('.viewer-body');
   var close = $('.close');
   var next = $('.next');
   var prev = $('.prev');
  
   thumbnail.click(function(){
    var content = $(this).html();
    thumbnail.removeClass('open');
    $(this).addClass('open');
    $('body').addClass('view-open');
    container.html(content);
  });
    
  next.click(function() {
    var total = $('.media .thumbnail').length;
   if ($('.open').index() === total- 1){
     alert(total);
     alert($('.open').index());
       $('.thumbnail:last-child').addClass('open');
    }
  else{alert($('.open').index());$('.open').removeClass('open').next().toggleClass('open');}
     var content = $('.open').html();
     container.html(content);
  });
  
  prev.click(function() {
    if ($('.open').index() == 0){$('.thumbnail:first-child').addClass('open');}
    else{ $('.open').removeClass('open').prev().toggleClass('open');}
     var content = $('.open').html();
     container.html(content);
  });
  
   close.click(function() {$('body').removeClass('view-open'); });  
  
});

