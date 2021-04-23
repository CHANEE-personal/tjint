$(document).ready(function(){
    // NAVIGATION
    var hidelogo = function(){
        var $nav = $('#header, #header_admin');
        var $navTop = $nav.offset().top;
        if ($navTop !== 0) {
            $nav.addClass('fixed');
        } else {
            $nav.removeClass('fixed');
        }
    };
    hidelogo();
    $(window).scroll(function () {
        hidelogo();
    });

   // PLACEHOLDER
   var PLACEHOLDER = (function(){
    if(!('placeholder' in document.createElement('input'))) {
        $(':input[placeholder]').each(function(){
            var $this = $(this),
                $val = $this.val(),
                $ph = $this.attr('placeholder'),
                $parent = $this.parent(),
                $span_text;
            if($this.val() == ''){
                $this.wrap('<span style="position:relative; display:inline-block; vertical-align:top;" />');
                $('<span class="span_placeholder">' + $ph + '</span>').insertAfter($this).bind('click', function(){
                    $this.focus();
                });
                $this.bind('focus blur', function(e){
                    if(e.type == 'focus'){
                        $this.next().css('display', 'none');
                    } else if(e.type == 'blur' && $this.val() == ''){
                        $this.next().css('display', 'block');
                    }
                });
            }
        });
    }
   })();

    // INPUT:FILE
    var fileTarget = $('.filebox .upload_hidden');

    fileTarget.on('change', function(){
        if(window.FileReader){  // modern browser
            var filename = $(this)[0].files[0].name;
        } else {  // old IE
            var filename = $(this).val().split('/').pop().split('\\').pop();
        }

        $(this).siblings('.upload_name').val(filename);
    });

    // GNB
    var $targetMenu = $(".localMenuBox > .localMenu > li:eq(0), .localMenuBox > .localMenu > li:eq(1), .localMenuBox > .localMenu > li:eq(2), .localMenuBox > .localMenu > li:eq(3), .localMenuBox > .localMenu > li:eq(4)");
        $targetMenu.bind('mouseenter focusin', function(){
            $(this).addClass('on').siblings().removeClass('on');
            $('.dimmed').addClass('on');
        });
        $targetMenu.bind('mouseleave focusout', function(){
            $(this).removeClass('on');
            $('.dimmed').removeClass('on');
        });

        $(function(){
            $('.iframe').iframeHeight({
                resizeMaxTry         : 2,
                resizeWaitTime       : 300,
                minimumHeight        : 100,
                defaultHeight        : 100,
                heightOffset         : 90,
                exceptPages          : "",
                debugMode            : false,
                visibilitybeforeload : true,
                blockCrossDomain     : true,
                externalHeightName   : "bodyHeight",
                onMessageFunctionName: "getHeight",
                domainName           : "*",
                watcher              : true,
                watcherTime          : 400
           });
        });
        // jQuery-migrate logging Inactive
        jQuery.migrateMute = true
    });

/**
 * Input Validate Function
 */
// Pattern - URL
var validateInputValueForUrl = function(selector){
    var returnValue = true;
    var url = $(selector).val();
    var pattern = /(http|ftp|https):\/\/[\w-]+(\.[\w-]+)+([\w.,@?^=%&amp;:\/~+#-]*[\w@?^=%&amp;\/~+#-])?/;
    if(!pattern.test(url)) {
        var errors = '입력된 주소가 올바른 형식이 아닙니다.';
        alert(errors);
        $(selector).focus();
        returnValue = false;
    }
    return returnValue;
}

$(function () {
    $('#testType').selectbox();
    $('#searchType').selectbox();
    $('#familyType').selectbox();

    //$('.jcarousel').jcarouselAutoscroll({
    //    interval: 3000,
    //    target: '+=1',
    //    autostart: true
    //});
    
});

