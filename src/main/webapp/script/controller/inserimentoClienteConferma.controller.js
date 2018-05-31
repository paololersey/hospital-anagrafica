angular.module('app.module').controller('inserimentoClienteConferma.controller', ['$scope','$location', function($scope, $location){
console.log("inserimentoClienteConferma.controller");

$scope.submit = function () {
    if ($scope.inserimentoClienteConferma.$invalid) {
        alert("form is invalid!")
    }
    $location.path("/gestioneRicerche");
}
}]);