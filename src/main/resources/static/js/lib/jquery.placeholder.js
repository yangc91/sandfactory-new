/*
 * html5 placeholder pollfill
 * - 使用绝对定位内嵌层
 * - 也适用于密码域
 * 目标浏览器: IE 6~9, FF 3.5
 ```
 // 默认
 $('input[placeholder]').placeholder()

 // autofocus 与 placeholder 搭配时，非 webkit 清空了提示文本，推荐
 $('input[placeholder]').placeholder({
   // 将删除原有 placehodler 属性，强制用 JS 实现替代
   useNative: false,
   // focus 时不清除提示文本， keypress 有效字符时才清空
   hideOnFocus: false,
   // 附加样式
   style: {
     textShadow: 'none'
   }
 })
 */

$.fn.placeholder = function(options) {
	if (typeof options === 'string') {
		options = {
			text : options
		};
	}

	// 默认配置信息
	var opt = $.extend({
		text : '', // 显示提示文本信息
		style : {}, // 样式
		namespace : 'placeholder',
		useNative : false,  //强制使用JS
		hideOnFocus : false// focus 时不清除提示文本， keypress 有效字符时才清空
	// 当focus时隐藏提示
	}, options || {});

	var attr = opt.namespace, nativeSupported = $.fn.placeholder.support;
	var box_style = [ 'marginTop', 'marginLeft', 'paddingTop', 'paddingLeft', 'paddingRight','paddingBottom' ];
	var text = '';

	return this.each(function(i,n) {
		var $input = $(this);

		text = opt.text;
		if (!text) {
			text = $input.attr(attr);
		}
		if (opt.useNative) { //强制使用JS
			$input.removeAttr(attr);
		} else if (nativeSupported) {
			// 仅改变文本
			$input.attr(attr, text);
			return;
		}


		var hide = function() {
			$layer.hide();
		};
		
		var is_empty = function() {
			return !$input.val();
		};
		
		var check = function() {
			is_empty() ? $layer.show() : hide();
		};

		var width = $input.width(), height = $input.height();
		var position = function() {
			var pos = $input.position();
			if (!opt.hideOnFocus) {
				pos.left += 2;
			}
			
			//取得文本的高度
			var span = $('<span>').html('&bnsp;').css({display:'none',fontSize : $input.css('fontSize')}).appendTo('body');
			var textHeight = span.height();
			span.remove();
			
			pos.top = pos.top + (height-textHeight)/2 /*@cc_on @*/ + 1;
			$layer.css(pos);
			

			$.each(box_style, function(i, name) {
				$layer.css(name, $input.css(name));
				onresize = position;
			});
		};

		var layer_style = {
			color : '#999',
			cursor : 'text',
			textAlign : 'left',
			position : 'absolute',
			fontSize : $input.css('fontSize'),
			fontFamily : $input.css('fontFamily'),
			display : is_empty() ? 'block' : 'none'
		};

		// create
		var layer_props = {
			text : text,
			width : $input.css('width'),
			height : 'auto'
		};

		// 确保只绑定一次
		var ns = '.' + opt.namespace, $layer = $input['layer' + ns];
		if (!$layer) {
			$input['layer' + ns] = $layer = $('<div>', layer_props).addClass("mdc-layer").appendTo($input.offsetParent());
		}
		
		// activate
		$layer.css($.extend(layer_style, opt.style))
		.unbind('click' + ns)
		.bind('click' + ns, function() {
			opt.hideOnFocus && hide();
			$input.focus();
		});

		$input.unbind(ns).bind('blur' + ns, check);

		if (opt.hideOnFocus) {
			$input.bind('focus' + ns, hide);
		} else {
			$input.bind('keypress keydown' + ns, function(e) {
				var key = e.keyCode;
				if (e.charCode || (key >= 65 && key <= 90)) {
					hide();
				}
			}).bind('keyup' + ns, check);
		}

		// 由于 ie 记住密码的特性，需要监听值改变
		// ie9 不支持 jq bind 此事件
		$input.get(0).onpropertychange = check;

		position();
		check();

		//监听窗口改变事件
		$(window).resize({
			input : $input,
			layer : $layer
		}, function(event) {
			var $input_resize = event.data.input;
			var $layer_resize = event.data.layer;
			var pos_resize = $input_resize.position();

			if (!opt.hideOnFocus) {
				pos_resize.left += 2;
			}
			
			//取得文本的高度
			var span = $('<span>').html('&bnsp;').css({display:'none',fontSize : $input.css('fontSize')}).appendTo('body');
			var textHeight = span.height();
			span.remove();
			
			pos_resize.top = pos_resize.top + (height-textHeight)/2 /*@cc_on@*/ + 1;

			$layer_resize.css(pos_resize);
			$.each(box_style, function(i, name) {
				$layer.css(name, $input_resize.css(name));
			});
		});
	});
};

// 检测是否支持placeholder
$.fn.placeholder.support = (function(input) {
	return 'placeholder' in input;
})(document.createElement('input'));

// ////////////////以下为调用代码/////////////////////////////////////////
//$(function() {
//
//	var support = (function(input) {
//		return function(attr) {
//			return attr in input;
//		};
//	})(document.createElement('input'));
//	
//	$('input[placeholder]').placeholder({
//		useNative : false,
//		hideOnFocus : false,
//		style : {
//			textShadow : 'none'
//		}
//	});
//
//	if (!support('autofocus')) {
//		$('input[autofocus]').focus();
//	}
//});