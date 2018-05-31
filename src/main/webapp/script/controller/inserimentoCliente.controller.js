angular.module('app.module').controller('inserimentoCliente.controller', ['$scope','$location', function($scope, $location){
console.log("inserimentoCliente.controller");

$scope.submit = function () {
    if ($scope.inserimentoCliente.$invalid) {
        alert("form is invalid!")
    }
    $location.path("/inserimentoClienteConsiglio");
}

}]);