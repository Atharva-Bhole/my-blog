<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <!-- Link to the CSS file -->
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>

    <div class="container">
        <h2>Register</h2>

        <form action="register" method="POST">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>

            <input type="submit" value="Register">

            <!-- Error message if registration fails -->
            <c:if test="${not empty message}">
                <p class="error">${message}</p>
            </c:if>
        </form>

        <p>Already have an account? <a href="login.jsp">Login here</a></p>
    </div>

</body>
</html>
