<html>
	<head>
		<title>Login</title>
		<style>
			/* Basic page setup */
			body {
				font-family: Arial, sans-serif;
				background: linear-gradient(135deg, #e0f7fa, #b2ebf2);
				color: #333;
				margin: 0;
				display: flex;
				justify-content: center;
				align-items: center;
				height: 100vh;
				text-align: center;
			}

			/* Container for form and heading */
			div {
				background-color: #ffffff;
				padding: 20px;
				border-radius: 8px;
				box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
				width: 300px;
				box-sizing: border-box;
			}

			h2 {
				font-size: 1.8rem;
				color: #00796b;
				margin-bottom: 15px;
			}

			h3 {
				color: red;
				margin: 5px 0;
			}

			/* Style form labels and inputs */
			label {
				display: block;
				text-align: left;
				font-weight: bold;
				margin: 10px 0 5px;
			}

			input[type="text"],
			input[type="password"] {
				width: 100%;
				padding: 8px;
				margin: 5px 0;
				border-radius: 4px;
				border: 1px solid #ccc;
			}

			input[type="submit"] {
				width: 100%;
				padding: 10px;
				background-color: #00796b;
				border: none;
				color: white;
				font-size: 1rem;
				border-radius: 4px;
				cursor: pointer;
				margin-top: 15px;
			}

			input[type="submit"]:hover {
				background-color: #004d40;
			}
		</style>
	</head>

	<body>
		<div>
			<h2>Welcome ${name} to the login page</h2>
			<h3>${error}</h3>
			<form method="post">
				<label for="inp1">Username</label>
				<input id="inp1" type="text" name="username"/>
				
				<label for="inp2">Password</label>
				<input id="inp2" type="password" name="pass"/>
				
				<input type="submit" value="Login"/>
			</form>
		</div>
	</body>
</html>
