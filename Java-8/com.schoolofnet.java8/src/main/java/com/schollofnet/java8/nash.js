var String = Java.type("java.lang.String");

function greetings(name) {
  var result = "Welcome to Nashorn - " + name;

  return result;
}

print(greetings("Marcello"));
