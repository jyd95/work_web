<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시간표</title>
</head>
<body>
    <h1>대학 수업 시간표</h1>
    <table style="border: 1px solid #f0f0f0">

            <tr>
                <th>시간</th>
                <th>월요일</th>
                <th>화요일</th>
                <th>수요일</th>
                <th>목요일</th>
                <th>금요일</th>
            </tr>

      <%String[] timeSelection  ={"10:00 - 11:00","10:00 - 11:00","11:00 - 12:00","12:00 - 13:00",
    		  "13:00 - 14:00","14:00 - 15:00","15:00 - 16:00","16:00 - 17:00","17:00 - 18:00"};%>  
      
        <%for(int i =0; i <9;i++){%>
        	<tr style="border: 1px solid #f0f0f0">
        		  <td><%=timeSelection[i] %></td>
    	    <%for(int j =0; j <6;j++){%>
        			<td>수업 <%=j+" , "+i %></td>
				<!-- dto 안에 row : 1, colum :1/row : 3, colum :1 
					list<dto>  -> for문 list.get(k).getRow;
					if j=getRow && i = getColum == true
					
					
				-->   
          <%} %>
	        </tr>
        <%} %>
       
    </table>
</body>
</html>
  