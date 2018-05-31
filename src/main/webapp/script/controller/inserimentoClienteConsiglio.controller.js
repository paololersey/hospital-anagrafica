angular.module('app.module').controller('inserimentoClienteConsiglio.controller', ['$scope','$location', function($scope, $location){
console.log("inserimentoClienteConsiglio.controller");
$scope.submit = function () {
    if ($scope.inserimentoClienteConsiglio.$invalid) {
        alert("form is invalid!")
    }
    $location.path("/inserimentoClienteSelezione");
}
}]);