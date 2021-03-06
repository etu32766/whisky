<%@ include file="include/importTags.jsp" %>

<!--content-->
<!---->
<div class="product">
    <div class="container">
        <div class="col-md-9 product-price1">
            <div class="col-md-5 single-top">
                <div class="flexslider">
                    <ul class="slides">
                        <li data-thumb="<spring:url value='/images/bottle/${whisky.img}' />">
                            <img src="<spring:url value='/images/bottle/${whisky.img}' />" >
                        </li>
                    </ul>
                </div>
                <!-- FlexSlider -->
                <script defer src="<spring:url value='/js/jquery.flexslider.js' />"></script>
                <link type="text/css" href="<spring:url value='/css/flexslider.css'/>" rel="stylesheet" media="screen" />

                <script>
                    // Can also be used with $(document).ready()
                    $(window).load(function() {
                      $('.flexslider').flexslider({
                        animation: "slide",
                        controlNav: "thumbnails"
                      });
                    });
                </script>
            </div>
            <div class="col-md-7 single-top-in simpleCart_shelfItem">
                <div class="single-para ">
                    <h4>${whisky.whiskyName}</h4>

                    <div class="clearfix"> </div>

                    <c:if test="${whisky.promotion == null}">
                        <h5 class="item_price"><fmt:formatNumber value="${whisky.price}" type="currency" currencySymbol="&euro;"/></h5>
                    </c:if>
                    <c:if test="${whisky.promotion != null}">
                        <h5 class="item_price"><del><fmt:formatNumber value="${whisky.price}" type="currency" currencySymbol="&euro;"/></del> <fmt:formatNumber value="${whisky.price-(whisky.promotion/100*whisky.price)}" type="currency" currencySymbol="&euro;"/> </h5>
                    </c:if>
                    <c:if test="${whisky.volume!=null}">
                        <p>${whisky.volume} cl</p>
                    </c:if>
                    <c:if test="${whisky.alcoholContent!=null}">
                        <p><spring:message code="alcohol"/>${whisky.alcoholContent} %</p>
                    </c:if>
                    <c:if test="${whisky.categorie != null}">
                        <p>${whisky.categorie.nom}</p>
                    </c:if>
                    <c:if test="${whisky.country!=null}">
                        <p>${whisky.country}</p>
                    </c:if>
                    
                    <p></p>

                    <c:if test="${mainPanier.whiskyAjoutable(whisky) > 0}" >
                        <form action="/whisky/single/${whisky.id}/add" method="POST" onsubmit="return alert('<spring:message code='whiskyAdd'/>')">
                            <input type="number" min="1" max="${mainPanier.whiskyAjoutable(whisky)}" value="1" name="quantity"
                                   oninvalid="this.setCustomValidity('<spring:message code="badQuantity"/>${mainPanier.whiskyAjoutable(whisky)}')"
                                   oninput="this.setCustomValidity('')"
                                   alt="<spring:message code='badQuantity'/>${mainPanier.whiskyAjoutable(whisky)}"
                                   title="<spring:message code='badQuantity'/>${mainPanier.whiskyAjoutable(whisky)}">
                            <input type="hidden" value="${whisky.id}" name="whisky">
                            <div class="clearfix"> </div>
                            <input type="submit" value="<spring:message code="add"/>" id="login"/>
                        </form>
                    </c:if>
                    <c:if test="${mainPanier.whiskyAjoutable(whisky) == 0}">
                        <p><spring:message code="outOfStock"/></p>
                    </c:if>

                </div>
            </div>
            <div class="clearfix"> </div>
			<!---->
            <div class="cd-tabs">
                <nav>
                    <ul class="cd-tabs-navigation">
                        <li><a data-content="fashion"  href="#0"><spring:message code="description"/></a></li>
                    </ul>
			    </nav>
                <ul class="cd-tabs-content">
                    <li data-content="fashion" >
                        <div class="facts">
                            <p style="color: black">${translation.descriptions}</p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"> </div>

<!--//content-->
			