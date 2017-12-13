$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MyApp.feature");
formatter.feature({
  "line": 1,
  "name": "Test ENGPROD Sanity Testing",
  "description": "",
  "id": "test-engprod-sanity-testing",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Test login with valid crendetials",
  "description": "",
  "id": "test-engprod-sanity-testing;test-login-with-valid-crendetials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "Open browser and start application",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "I enter valid username and valid password",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "user should be able to naviagte to spectrum portal",
  "keyword": "Then "
});
formatter.match({
  "location": "Login.Open_browser_and_start_application()"
});
formatter.result({
  "duration": 317791414972,
  "error_message": "org.openqa.selenium.TimeoutException: timeout\n  (Session info: chrome\u003d61.0.3163.100)\n  (Driver info: chromedriver\u003d2.29.461591 (62ebf098771772160f391d75e589dc567915b233),platform\u003dWindows NT 10.0.15063 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 300.28 seconds\nBuild info: version: \u00273.4.0\u0027, revision: \u0027unknown\u0027, time: \u0027unknown\u0027\nSystem info: host: \u0027BDC8-D-6P5HH92\u0027, ip: \u0027192.168.176.240\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.29.461591 (62ebf098771772160f391d75e589dc567915b233), userDataDir\u003dC:\\Users\\SOBHIT~1.SHA\\AppData\\Local\\Temp\\scoped_dir15496_7828}, takesHeapSnapshot\u003dtrue, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d61.0.3163.100, platform\u003dXP, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue, unexpectedAlertBehaviour\u003d}]\nSession ID: 887bb8cb6f829e3dbfcb8d5fdc786729\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:215)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:167)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:671)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.get(RemoteWebDriver.java:364)\r\n\tat sanity.Login.Open_browser_and_start_application(Login.java:38)\r\n\tat ✽.Given Open browser and start application(MyApp.feature:3)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Login.I_enter_valid_username_and_valid_password()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Login.user_should_be_able_to_naviagte_to_spectrum_portal()"
});
formatter.result({
  "status": "skipped"
});
});