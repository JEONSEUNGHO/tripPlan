
(function($) {
    
    var defaults = {
        rootClass: '.file-upload',
        listClass: '.file-upload-list',
        itemClass: '.file-upload-item'
    };
    
    var fileList = {};
    
    var templates = {
        list: '<div class="file-upload-list"></div>',
        item: function (item, index) {
            return '<div class="file-upload-item" tabindex="0" data-index="' + index + '">' + item + '</div>';
        },
        img: function (img, file, index) {
            var item = (
                '<strong>' + file.name + '</strong>' +
                '<img src="' + img + '" alt="">'
            );
            return this.item(item, index);
        },
        file: function (file, index) {
            var item = (
                '<strong>' +
                    '<i class="fa fa-file-o" aria-hidden="true"></i> ' +
                    file.name +
                '</strong>'
            );
            return this.item(item, index);
        }
    };
        
    function clickTriggerButton() {
        $(this).prev('input').trigger('click');
    }
    
    function addItem() {
        var files = this.files,
            $upload = $(this).parents(defaults.rootClass),
            $uploadList = $upload.find(defaults.listClass);
        if (files.length > 0) {
            $uploadList.remove();
            $upload.append(templates.list);
            $uploadList = $upload.find('.file-upload-list');
        }
        for (var i in files) {
            if (typeof files[i] !== 'object') {
                continue;
            }
            if (files[i].type.match(/image/)) {
                var reader = new FileReader();
                reader.onload = (function(files, i) {
                    return function(e) {
                        $uploadList.append(templates.img(e.target.result, files[i], i));
                    };
                })(files, i);
                reader.readAsDataURL(files[i]);
            } else {
                $uploadList.append(templates.file(files[i], i));
            }
        }
    }
    
    function changeInput() {
        addItem.call(this);
    }
    
    $.fn.extend({
        fileUpload: function(opts) {
            var $upload = $(this);
            $upload
                .on('click', 'button', clickTriggerButton)
                .on('change', 'input', changeInput);
        }
    });

})(jQuery);

$('[data-provide="fileupload"]').fileUpload();