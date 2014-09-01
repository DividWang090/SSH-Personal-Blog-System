<!DOCTYPE html>
<%@ page language="java" import="java.util.*,com.dao.*,com.domain.Blog"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Code Poet－Powered By 徐斌</title>



<link href="<%=request.getContextPath()%>/css/reset.css"
	rel="stylesheet" media="screen">
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" media="screen">

<!-- 浮动标签效果 +++++++++++++++++++++++++++++++++++++++++++++++-->


<!-- 浮动标签效果 +++++++++++++++++++++++++++++++++++++++++++++++-->

<script type="text/javascript" src="js/myfocus-2.0.4.min.js"></script>
<style type="text/css">
#myFocus {
	width: 660px;
	height: 400px;
	align: center
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("#pikame").PikaChoose();
	});
</script>
<script type="text/javascript">
	//设置
	myFocus.set({
		id : 'myFocus',//ID
		pattern : 'mF_fancy'//风格
	});
</script>

<!--[if lt IE 9]>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

</head>

<body>
	<div id="page">
		<aside id="sidebar">
			<nav>
				<a class="logo" href="#top" id="nav-logo"><span>Arith Xu</span>Arith's
					Blog</a>
				<ul>
					<li id="nav-1"><a href="viewBlog.action">博客</a>
					</li>
					<li id="nav-2"><a href="viewMessage.action">留言板</a>
					</li>
					<li id="nav-3"><a href="showSave.action">新建博文</a>
					</li>
					<li id="nav-4"><a href="manager.action">后台管理</a>
					<li class="active" id="nav-5"><a href="getInformation.action">信息统计</a>
					</li>
				</ul>
				<div class="bg_bottom"></div>

			</nav>
		</aside>
		<div id="main-content">
			<div id="loader" class="loader"></div>
			<div id="ps_container" class="ps_container">
				<span class="ribbon"></span>
				<div class="ps_image_wrapper">
					<img src="images/1.jpg" alt="" />
				</div>

				<!-- Dot list with thumbnail preview -->
				<ul class="ps_nav">
					<li class="selected"><a href="images/1.jpg"
						rel="images/thumbs/1.jpg">Image 1</a>
					</li>
					<li><a href="images/2.jpg" rel="images/thumbs/2.jpg">Image
							2</a>
					</li>
					<li><a href="images/3.jpg" rel="images/thumbs/3.jpg">Image
							3</a>
					</li>
					<li><a href="images/4.jpg" rel="images/thumbs/4.jpg">Image
							4</a>
					</li>
					<li><a href="images/5.jpg" rel="images/thumbs/5.jpg">Image
							5</a>
					</li>
					<li class="ps_preview">
						<div class="ps_preview_wrapper">
							<!-- Thumbnail comes here -->
						</div> <!-- Little triangle --> <span></span></li>
				</ul>

			</div>

			<div class="wrapper">
				<article>
					<div align="center">
						<h3 align="center">Basic Information</h3>
						<p>
						<h3>
							当前博文数量：
							<s:property value="blogNumber" />
						</h3>
						</p>
						<p>
						<h3>
							当前留言数量：
							<s:property value="messageNumber" />
						</h3>
						</p>
					</div>
					<div align="center">
						<form name="updateUser" method="post"
							action="updateUser.action">
							<label for="username">username:</label> <br> <input
								type="text" name="username" id="username" value="admin" /> <br>
							<br> <label for="textarea">输入新密码</label> <br> <input
								type="password" name="password" id="password" value="" /> <br>
							<br> <input type="submit" value="修改密码" class="button" />
						</form>
					</div>

					<br> <br> <br>
				</article>
			</div>


		</div>
	</div>
	<script type="text/javascript" src="js/jquery-1.4.3.min.js"></script>
	<script type="text/javascript" src="js/jquery_003.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>

	<!-- The JavaScript -->
	<script type="text/javascript">
		/*
		the images preload plugin
		 */
		(function($) {
			$.fn.preload = function(options) {
				var opts = $.extend({}, $.fn.preload.defaults, options), o = $.meta ? $
						.extend({}, opts, this.data())
						: opts;
				return this
						.each(function() {
							var $e = $(this), t = $e.attr('rel'), i = $e
									.attr('href'), l = 0;
							$('<img/>').load(function(i) {
								++l;
								if (l == 2)
									o.onComplete();
							}).attr('src', i);
							$('<img/>').load(function(i) {
								++l;
								if (l == 2)
									o.onComplete();
							}).attr('src', t);
						});
			};
			$.fn.preload.defaults = {
				onComplete : function() {
					return false;
				}
			};
		})(jQuery);
	</script>
	<script type="text/javascript">
		$(function() {
			//some elements..
			var $ps_container = $('#ps_container'), $ps_image_wrapper = $ps_container
					.find('.ps_image_wrapper'), $ps_next = $ps_container
					.find('.ps_next'), $ps_prev = $ps_container
					.find('.ps_prev'), $ps_nav = $ps_container.find('.ps_nav'), $tooltip = $ps_container
					.find('.ps_preview'), $ps_preview_wrapper = $tooltip
					.find('.ps_preview_wrapper'), $links = $ps_nav.children(
					'li').not($tooltip), total_images = $links.length, currentHovered = -1, current = 0, $loader = $('#loader');

			/*check if you are using a browser*/
			var ie = false;
			if ($.browser.msie) {
				ie = true;//you are not!Anyway let's give it a try
			}
			if (!ie)
				$tooltip.css({
					opacity : 0
				}).show();

			/*first preload images (thumbs and large images)*/
			var loaded = 0;
			$links.each(function(i) {
				var $link = $(this);
				$link.find('a').preload(
						{
							onComplete : function() {
								++loaded;
								if (loaded == total_images) {
									//all images preloaded,
									//show ps_container and initialize events
									$loader.hide();
									$ps_container.show();
									//when mouse enters the pages (the dots),
									//show the tooltip,
									//when mouse leaves hide the tooltip,
									//clicking on one will display the respective image	
									$links.bind('mouseenter', showTooltip)
											.bind('mouseleave', hideTooltip)
											.bind('click', showImage);
									//navigate through the images
									$ps_next.bind('click', nextImage);
									$ps_prev.bind('click', prevImage);
								}
							}
						});
			});

			function showTooltip() {
				var $link = $(this), idx = $link.index(), linkOuterWidth = $link
						.outerWidth(),
				//this holds the left value for the next position
				//of the tooltip
				left = parseFloat(idx * linkOuterWidth) - $tooltip.width() / 2
						+ linkOuterWidth / 2,
				//the thumb image source
				$thumb = $link.find('a').attr('rel'), imageLeft;

				//if we are not hovering the current one
				if (currentHovered != idx) {
					//check if we will animate left->right or right->left
					if (currentHovered != -1) {
						if (currentHovered < idx) {
							imageLeft = 75;
						} else {
							imageLeft = -75;
						}
					}
					currentHovered = idx;

					//the next thumb image to be shown in the tooltip
					var $newImage = $('<img/>').css('left', '0px').attr('src',
							$thumb);

					//if theres more than 1 image 
					//(if we would move the mouse too fast it would probably happen)
					//then remove the oldest one (:last)
					if ($ps_preview_wrapper.children().length > 1)
						$ps_preview_wrapper.children(':last').remove();

					//prepend the new image
					$ps_preview_wrapper.prepend($newImage);

					var $tooltip_imgs = $ps_preview_wrapper.children(), tooltip_imgs_count = $tooltip_imgs.length;

					//if theres 2 images on the tooltip
					//animate the current one out, and the new one in
					if (tooltip_imgs_count > 1) {
						$tooltip_imgs.eq(tooltip_imgs_count - 1).stop()
								.animate({
									left : -imageLeft + 'px'
								}, 150, function() {
									//remove the old one
									$(this).remove();
								});
						$tooltip_imgs.eq(0).css('left', imageLeft + 'px')
								.stop().animate({
									left : '0px'
								}, 150);
					}
				}
				//if we are not using a "browser", we just show the tooltip,
				//otherwise we fade it
				//
				if (ie)
					$tooltip.css('left', left + 'px').show();
				else
					$tooltip.stop().animate({
						left : left + 'px',
						opacity : 1
					}, 150);
			}

			function hideTooltip() {
				//hide / fade out the tooltip
				if (ie)
					$tooltip.hide();
				else
					$tooltip.stop().animate({
						opacity : 0
					}, 150);
			}

			function showImage(e) {
				var $link = $(this), idx = $link.index(), $image = $link.find(
						'a').attr('href'), $currentImage = $ps_image_wrapper
						.find('img'), currentImageWidth = $currentImage.width();

				//if we click the current one return
				if (current == idx)
					return false;

				//add class selected to the current page / dot
				$links.eq(current).removeClass('selected');
				$link.addClass('selected');

				//the new image element
				var $newImage = $('<img/>').css('left',
						currentImageWidth + 'px').attr('src', $image);

				//if the wrapper has more than one image, remove oldest
				if ($ps_image_wrapper.children().length > 1)
					$ps_image_wrapper.children(':last').remove();

				//prepend the new image
				$ps_image_wrapper.prepend($newImage);

				//the new image width. 
				//This will be the new width of the ps_image_wrapper
				var newImageWidth = $newImage.width();

				//check animation direction
				if (current > idx) {
					$newImage.css('left', -newImageWidth + 'px');
					currentImageWidth = -newImageWidth;
				}
				current = idx;
				//animate the new width of the ps_image_wrapper 
				//(same like new image width)
				$ps_image_wrapper.stop().animate({
					width : newImageWidth + 'px'
				}, 350);
				//animate the new image in
				$newImage.stop().animate({
					left : '0px'
				}, 350);
				//animate the old image out
				$currentImage.stop().animate({
					left : -currentImageWidth + 'px'
				}, 350);

				e.preventDefault();
			}

			function nextImage() {
				if (current < total_images) {
					$links.eq(current + 1).trigger('click');
				}
			}
			function prevImage() {
				if (current > 0) {
					$links.eq(current - 1).trigger('click');
				}
			}
		});
	</script>
	<script type="text/javascript"
		src="fancybox/jquery.mousewheel-3.0.4.pack.js"></script>
	<script type="text/javascript"
		src="fancybox/jquery.fancybox-1.3.4.pack.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {

							$('.projects li figure a img').animate({
								'opacity' : 1
							}).hover(function() {
								$(this).animate({
									'opacity' : .5
								});
							}, function() {
								$(this).animate({
									'opacity' : 1
								});
							});
							$('.zoom img').animate({
								'opacity' : 1
							}).hover(function() {
								$(this).animate({
									'opacity' : .5
								});
							}, function() {
								$(this).animate({
									'opacity' : 1
								});
							});

							$("a[rel=work]")
									.fancybox(
											{
												'transitionIn' : 'elastic',
												'transitionOut' : 'elastic',
												'titlePosition' : 'over',
												'titleFormat' : function(title,
														currentArray,
														currentIndex,
														currentOpts) {
													return '<span id="fancybox-title-over">Image '
															+ (currentIndex + 1)
															+ ' / '
															+ currentArray.length
															+ (title.length ? ' &nbsp; '
																	+ title
																	: '')
															+ '</span>';
												}
											});
							$("a[rel=recent_work]")
									.fancybox(
											{
												'transitionIn' : 'elastic',
												'transitionOut' : 'elastic',
												'titlePosition' : 'over',
												'titleFormat' : function(title,
														currentArray,
														currentIndex,
														currentOpts) {
													return '<span id="fancybox-title-over">Image '
															+ (currentIndex + 1)
															+ ' / '
															+ currentArray.length
															+ (title.length ? ' &nbsp; '
																	+ title
																	: '')
															+ '</span>';
												}
											});

						});
	</script>

</body>
</html>
