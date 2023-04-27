<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    .small_img {
        width: 40px;
    }
</style>
<%-- Main Center Start --%>
<div class="col-sm-8 text-left">
    <div class="container">
        <div class="row content">
            <div class="col-sm-6 text-left">
                <h3>Item AllDB Page</h3>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>IMG</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Rdate</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="i" items="${allitem}">
                        <tr>
                            <td><img class="small_img" src="/uimg/${i.imgname}"></td>
                            <td>${i.id}</td>
                            <td>${i.name}</td>
                            <td><fmt:formatNumber value="${i.price}" type="currency" currencyCode="KRW" pattern="#,##0 원"/></td>
                            <td><fmt:formatDate value="${i.rdate}" pattern="yyyy-MM-dd" /></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>     <%-- Table End --%>
    </div>
</div>
<%-- Main Center End --%>