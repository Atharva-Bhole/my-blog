<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <!-- Link to the CSS file -->
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>

    <div class="container">
        <h2>Login</h2>

        <form action="login" method="POST">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <input type="submit" value="Login">

            <!-- Error message if invalid login -->
            <c:if test="${not empty message}">
                <p class="error">${message}</p>
            </c:if>
        </form>

        <p>Don't have an account? <a href="register.jsp">Register here</a></p>
    </div>

</body>
</html>
