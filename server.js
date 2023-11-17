var http = require("http")

var server = http.createServer(function(peticion, respuesta){
    respuesta.end("Hola Esfot")
});

server.listen(3000, function(){
    console.log("Tu servidor está en: " + this.address().port)
    console.log(`http://localhost:${this.address().port}`)
})