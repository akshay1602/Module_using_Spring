
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        #demo2
        {
            margin-left: 10px;
            margin-top : 10px;
            margin-right: auto;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
<form action="register.html" method="post">
    <table>
        <tr>
            <td>
                Name:
            </td>
            <td>
                <input type="text" name="Name">
            </td>
        </tr>
        <tr>
            <td>
                Username :
            </td>
            <td>
                <input type="text" name="Username">
            </td>
        </tr>
        <tr>
            <td>
                Password :
            </td>
            <td>
                <input type="password" name="Password">
            </td>
        </tr>
        <tr>
            <td>
                Confirm Password :
            </td>
            <td>
                <input type="password" name="Confirm_Password">
            </td>
        </tr>
    </table>
    <input type="submit" value="Register"><br>
</form>

</body>
</html>
