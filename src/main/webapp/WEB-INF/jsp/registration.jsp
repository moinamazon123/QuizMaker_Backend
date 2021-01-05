<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="resources/img/logo/logo.png" rel="icon">
  <title>RuangAdmin - Register</title>
  <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="resources/css/ruang-admin.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-login">
  <!-- Register Content -->
  <div class="container-login">
    <div class="row justify-content-center">
      <div class="col-xl-10 col-lg-12 col-md-9">
        <div class="card shadow-sm my-5">
          <div class="card-body p-0">
            <div class="row">
              <div class="col-lg-12">
                <div class="login-form">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Register</h1>
                  </div>
                  <form name="userForm" action="/registration" method="POST">

                   <div class="form-group">
                                        <label>User Name</label>
                                        <input type="text" class="form-control" name="username" id="exampleInputFirstName" placeholder="Enter User Name">
                                      </div>

                    <div class="form-group">
                      <label>Email</label>
                      <input type="email" name="email" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp"
                        placeholder="Enter Email Address">
                    </div>
                     <div class="form-group">
                      <label>Mobile Number</label>
                                          <input type="text" name="mobNo" class="form-control" id="mobNo" aria-describedby="mobNoHelp"
                                            placeholder="Enter Mobile Number">
                                        </div>
                                         <div class="form-group">
                                          <label>Address</label>
                                                              <input type="text" name="address" class="form-control" id="address" aria-describedby="emailHelp"
                                                                placeholder="Enter Your Address">
                                                            </div>
                    <div class="form-group">
                      <label>Password</label>
                      <input type="password" name="password" class="form-control" id="exampleInputPassword" placeholder="Password">
                    </div>
                    <div class="form-group">
                      <label>Repeat Password</label>
                      <input type="password" name="passwordConfirm" class="form-control" id="exampleInputPasswordRepeat"
                        placeholder="Repeat Password">
                    </div>
                    <div class="form-group">
                      <input type="submit" value="Register" class="btn btn-primary btn-block">
                    </div>
                    <hr>

                  <hr>
                  <div class="text-center">
                    <a class="font-weight-bold small" href="login.html">Already have an account?</a>
                  </div>
                  <div class="text-center">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Register Content -->
  <script src="resources/vendor/jquery/jquery.min.js"></script>
  <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="resources/js/ruang-admin.min.js"></script>
</body>

</html>