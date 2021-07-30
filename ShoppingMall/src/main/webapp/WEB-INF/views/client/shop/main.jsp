<%@page import="com.koreait.shoppingmall.domain.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.koreait.shoppingmall.domain.TopCategory"%>
<%@page import="com.koreait.shoppingmall.domain.SubCategory"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<TopCategory> topList=(List)request.getAttribute("topList");
	List<Product> productList=(List)request.getAttribute("productList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Karl - Fashion Ecommerce Template | Home</title>

    <!-- Favicon  -->
    <link rel="icon" href="/resources/client/img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="/resources/client/css/core-style.css">
    <link rel="stylesheet" href="/resources/client/style.css">

    <!-- Responsive CSS -->
    <link href="/resources/client/css/responsive.css" rel="stylesheet">

</head>

<body>
	<%@ include file="../inc/side_category.jsp" %>
    <div id="wrapper">

        <!-- ****** Header Area Start ****** -->
        <%@ include file="../inc/header.jsp" %>
        <!-- ****** Header Area End ****** -->

        <!-- ****** Top Discount Area Start ****** -->
        <%@ include file="../inc/discount_banner.jsp" %>
        <!-- ****** Top Discount Area End ****** -->

        <!-- ****** Welcome Slides Area Start ****** -->
        <div class="modal fade" id="quickview" tabindex="-1" role="dialog" aria-labelledby="quickview" aria-hidden="true">
            <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
                <div class="modal-content">
                    <button type="button" class="close btn" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
					
					<!-- 상품 상세 모달창 start -->
                    <div class="modal-body">
                        <div class="quickview_body">
                            <div class="container">
                                <div class="row">
                                    <div class="col-12 col-lg-5">
                                        <div class="quickview_pro_img">
                                            <img src="/resources/client/img/product-img/product-1.jpg" alt="">
                                        </div>
                                    </div>
                                    <div class="col-12 col-lg-7">
                                        <div class="quickview_pro_des">
                                            <h4 class="title">Boutique Silk Dress</h4>
                                            <div class="top_seller_product_rating mb-15">
                                                <i class="fa fa-star" aria-hidden="true"></i>
                                                <i class="fa fa-star" aria-hidden="true"></i>
                                                <i class="fa fa-star" aria-hidden="true"></i>
                                                <i class="fa fa-star" aria-hidden="true"></i>
                                                <i class="fa fa-star" aria-hidden="true"></i>
                                            </div>
                                            <h5 class="price">$120.99 <span>$130</span></h5>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Mollitia expedita quibusdam aspernatur, sapiente consectetur accusantium perspiciatis praesentium eligendi, in fugiat?</p>
                                            <a href="#">View Full Product Details</a>
                                        </div>
                                        <!-- Add to Cart Form -->
                                        <form id="cart-form" class="cart" method="post">
                                        	<input type="hidden" name="product_id">
                                        	<input type="hidden" name="member_id" value="<%=1%>">
                                            <div class="quantity">
                                                <span class="qty-minus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i class="fa fa-minus" aria-hidden="true"></i></span>

                                                <input type="number" class="qty-text" id="qty" step="1" min="1" max="12" name="ea" value="1">

                                                <span class="qty-plus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i class="fa fa-plus" aria-hidden="true"></i></span>
                                            </div>
                                            <button type="button" name="addtocart" value="5" class="cart-submit" onClick="addCart()">Add to cart</button>
                                            <!-- Wishlist -->
                                            <div class="modal_pro_wishlist">
                                                <a href="wishlist.html" target="_blank"><i class="ti-heart"></i></a>
                                            </div>
                                            <!-- Compare -->
                                            <div class="modal_pro_compare">
                                                <a href="compare.html" target="_blank"><i class="ti-stats-up"></i></a>
                                            </div>
                                        </form>

                                        <div class="share_wf mt-30">
                                            <p>Share With Friend</p>
                                            <div class="_icon">
                                                <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                                                <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                                <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                                                <a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- 상품 상세 모달창 end-->
                </div>
            </div>
        </div>
        <!-- ****** Quick View Modal Area End ****** -->

        <section class="shop_grid_area section_padding_100">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-4 col-lg-3">
                        <div class="shop_sidebar_area">
                           
                            <div class="widget catagory mb-50">
                                <!--  Side Nav  -->
                                <div class="nav-side-menu">
                                    <h6 class="mb-0">Catagories</h6>
                                    <div class="menu-list">
                                        <ul id="menu-content2" class="menu-content collapse out">
                                        
											<%for(TopCategory topCategory :topList){ %>				                                        	
                                            <!-- Single Item -->
                                            <li  data-target="#women2" class="collapsed">
                                                <a href="#"><%=topCategory.getTop_name() %></a>
                                                <ul class="sub-menu collapse show" id="<%=topCategory.getTopcategory_id()%>">
                                                	<%for(SubCategory subCategory  : topCategory.getSubList()){ %>
                                                    <li><a href="/client/shop/list?subcategory_id=<%=subCategory.getSubcategory_id()%>"><%=subCategory.getSub_name()%></a></li>
                                                    <%} %>
                                                </ul>
                                            </li>
                                            <%} %>
                                        </ul>
                                    </div>
                                </div>
                            </div>

                            <div class="widget price mb-50">
                                <h6 class="widget-title mb-30">Filter by Price</h6>
                                <div class="widget-desc">
                                    <div class="slider-range">
                                        <div data-min="0" data-max="3000" data-unit="$" class="slider-range-price ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all" data-value-min="0" data-value-max="1350" data-label-result="Price:">
                                            <div class="ui-slider-range ui-widget-header ui-corner-all"></div>
                                            <span class="ui-slider-handle ui-state-default ui-corner-all" tabindex="0"></span>
                                            <span class="ui-slider-handle ui-state-default ui-corner-all" tabindex="0"></span>
                                        </div>
                                        <div class="range-price">Price: 0 - 1350</div>
                                    </div>
                                </div>
                            </div>

                            <div class="widget color mb-70">
                                <h6 class="widget-title mb-30">Filter by Color</h6>
                                <div class="widget-desc">
                                    <ul class="d-flex justify-content-between">
                                        <li class="gray"><a href="#"><span>(3)</span></a></li>
                                        <li class="red"><a href="#"><span>(25)</span></a></li>
                                        <li class="yellow"><a href="#"><span>(112)</span></a></li>
                                        <li class="green"><a href="#"><span>(72)</span></a></li>
                                        <li class="teal"><a href="#"><span>(9)</span></a></li>
                                        <li class="cyan"><a href="#"><span>(29)</span></a></li>
                                    </ul>
                                </div>
                            </div>

                            <div class="widget size mb-50">
                                <h6 class="widget-title mb-30">Filter by Size</h6>
                                <div class="widget-desc">
                                    <ul class="d-flex justify-content-between">
                                        <li><a href="#">XS</a></li>
                                        <li><a href="#">S</a></li>
                                        <li><a href="#">M</a></li>
                                        <li><a href="#">L</a></li>
                                        <li><a href="#">XL</a></li>
                                        <li><a href="#">XXL</a></li>
                                    </ul>
                                </div>
                            </div>

                            <div class="widget recommended">
                                <h6 class="widget-title mb-30">Recommended</h6>

                                <div class="widget-desc">
                                    <!-- Single Recommended Product -->
                                    <div class="single-recommended-product d-flex mb-30">
                                        <div class="single-recommended-thumb mr-3">
                                            <img src="/resources/client/img/product-img/product-10.jpg" alt="">
                                        </div>
                                        <div class="single-recommended-desc">
                                            <h6>Menâs T-shirt</h6>
                                            <p>$ 39.99</p>
                                        </div>
                                    </div>
                                    <!-- Single Recommended Product -->
                                    <div class="single-recommended-product d-flex mb-30">
                                        <div class="single-recommended-thumb mr-3">
                                            <img src="/resources/client/img/product-img/product-11.jpg" alt="">
                                        </div>
                                        <div class="single-recommended-desc">
                                            <h6>Blue mini top</h6>
                                            <p>$ 19.99</p>
                                        </div>
                                    </div>
                                    <!-- Single Recommended Product -->
                                    <div class="single-recommended-product d-flex">
                                        <div class="single-recommended-thumb mr-3">
                                            <img src="/resources/client/img/product-img/product-12.jpg" alt="">
                                        </div>
                                        <div class="single-recommended-desc">
                                            <h6>Womenâs T-shirt</h6>
                                            <p>$ 39.99</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-12 col-md-8 col-lg-9">
                        <div class="shop_grid_product_area">
                            <div class="row">
								
								<%for(Product product : productList){%>
                                <!-- Single gallery Item -->
                                <div class="col-12 col-sm-6 col-lg-4 single_gallery_item wow fadeInUpBig" data-wow-delay="0.2s">
                                    <!-- Product Image -->
                                    <div class="product-img">
                                        <img src="/resources/data/<%=product.getProduct_img() %>" alt="">
                                        <div class="product-quicview">
                                            <a href="" data-toggle="modal" data-target="#quickview" onClick="getDetail('<%=product.getProduct_name() %>','<%=product.getProduct_img() %>',<%=product.getPrice() %>,'<%=product.getInfo() %>', <%=product.getProduct_id()%>)"><i class="ti-plus"></i></a>
                                        </div>
                                    </div>
                                    <!-- Product Description -->
                                    <div class="product-description">
                                        <h4 class="product-price">$<%=product.getPrice() %></h4>
                                        <p><%=product.getProduct_name() %></p>
                                        <!-- Add to Cart -->
                                        <a href="#" class="add-to-cart-btn">ADD TO CART</a>
                                    </div>
                                </div>
								<%}%>
                            </div>
                        </div>

                        <div class="shop_pagination_area wow fadeInUp" data-wow-delay="1.1s">
                            <nav aria-label="Page navigation">
                                <ul class="pagination pagination-sm">
                                    <li class="page-item active"><a class="page-link" href="#">01</a></li>
                                    <li class="page-item"><a class="page-link" href="#">02</a></li>
                                    <li class="page-item"><a class="page-link" href="#">03</a></li>
                                </ul>
                            </nav>
                        </div>

                    </div>
                </div>
            </div>
        </section>

        <!-- ****** Footer Area Start ****** -->
		<%@ include file="../inc/footer.jsp" %>	
        <!-- ****** Footer Area End ****** -->
    </div>
    <!-- /.wrapper end -->

    <!-- jQuery (Necessary for All JavaScript Plugins) -->
    <script src="/resources/client/js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="/resources/client/js/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="/resources/client/js/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="/resources/client/js/plugins.js"></script>
    <!-- Active js -->
    <script src="/resources/client/js/active.js"></script>
	<script>
	//상품 상세정보 모달창에 출력하기!!!
	function getDetail(product_name, product_img, price, info , product_id){
		$(".quickview_pro_des .title").html(product_name); //상품명 
		$(".quickview_pro_img img").attr("src", "/resources/data/"+product_img);//상품이미지 
		$(".quickview_pro_des .price").html(price); //상품가격
		$(".quickview_pro_des p").html(info); //상품설명 
		
		//form 안에 hidden의 product_id값을 대입해놓자!!
		$("input[name='product_id']").val(product_id);
	}
	
	//장바구니에 담기(비동기)
	function addCart(){
		//기존 폼을 전송하겠다..
		var json={
			product_id:$("#cart-form input[name='product_id']").val(),
			member_id:$("#cart-form input[name='member_id']").val(), 
			ea:$("#cart-form input[name='ea']").val()
		};
		//var formData = $("#cart-form").serialize(); //product_id=5&member_id=1&ea=5  querystring 화됨
		//console.log("전송할 데이터는 ",json);
		
		$.ajax({
			url:"/rest/cart",
			type:"POST",
			contentType:"application/json;charset=utf-8",
			data:JSON.stringify(json),
			success:function(result, status, xhr){
				console.log("서버로 부터 전송된 데이터 ", result);
				if(result.resultCode==1){
					if(confirm("장바구니에 상품이 담겼습니다.\n장바구니로 이동하실래요?")){
						location.href="/client/cart/list";
					}
				}else if(result.resultCode==0){
					alert("장바구니에 상품이 담기지 않았습니다.\n문제가 지속될 경우 관리자에 문의하세요");
				}
			},
			//서버의 에러가 발생했을때 (500, 401,404..즉 요청을 성공할수 없는 심각한 200 초과의 에러들.. )
			error:function(xhr, status, error){
				console.log("서버에서 심각한 에러가 발생하여, 요청 자체를 처리할 수 없었다!", status);
			}			
		});		
	}
	</script>
</body>

</html>









