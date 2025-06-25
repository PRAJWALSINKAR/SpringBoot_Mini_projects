<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Report Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>

   <div class="container mt-5">
     <h3 class="pb-3 pt-3">Report Application</h3>
     
     <form:form action="search" modelAttribute="search" method="post">
       <table class="table table-borderless">
         <tr>
           <td>Plan Name:</td>
           <td>
             <form:select path="planName" cssClass="form-select">
               <form:option value="">-Select-</form:option>
               <form:options items="${name}" />
             </form:select>
           </td>
           
           <td>Plan Status:</td>
           <td>
             <form:select path="planStatus" cssClass="form-select">
               <form:option value="">-Select-</form:option>
               <form:options items="${status}" />
             </form:select>
           </td>
         </tr>

         <tr>
           <td>Gender:</td>
           <td>
             <form:select path="gender" cssClass="form-select">
               <form:option value="">-Select-</form:option>
               <form:option value="Male">Male</form:option>
               <form:option value="Fe-Male">Fe-Male</form:option>
             </form:select>
           </td>
         </tr>

         <tr>
           <td>Start Date:</td>
           <td><form:input path="startDate" type="date" cssClass="form-control"/></td>
           
           <td>End Date:</td>
           <td><form:input type="date" path="endDate" cssClass="form-control"/></td>        
         </tr>

       <tr>
  <td colspan="4" class="text-center">
    <a href="/" class="btn btn-secondary me-2">Reset</a>
    <button type="submit" class="btn btn-primary">Search</button>
  </td>
</tr>

       </table>
     </form:form>
     <hr/>
     
     <table class ="table table-striped table-hover">
        <thead>
        <tr>
        <th>Sr.No></th>
         <th>Holder Name</th>
          <th>Gender</th>
         <th>Plan name</th>
         <th>Plan Status</th>
         <th>Start Date></th>
         <th>End Date</th>
        
        </tr>     
    </thead>
    <tbody>
       <c:forEach items="${plans}" var="plan" varStatus="index">
       <tr>
       <td>${index.count}</td>
       <td>${plan.citizenName}</td>
        <td>${plan.gender}</td>
       <td>${plan.planName}</td>
       <td>${plan.planStatus}</td>
       <td>${plan.planStartDate}</td>
       <td>${plan.planEndDate}</td>
       </tr>
          <tr>
       </c:forEach>
       <c:if test="${empty plans}">
      <td colspan="7" style="text-align: center">  NO RECORD FOUND </td>
       </c:if>
       </tr> 
       </tbody>
     </table> 
     <hr/>
     Export : <a href="">Excel</a> <a href="">PDF</a>
   </div>

   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>
