angular.module('app.module').controller('inserimentoClienteSelezione.controller', ['$scope','$location', function($scope, $location){
console.log("inserimentoClienteSelezione.controller");

$scope.submit = function () {
    if ($scope.inserimentoClienteSelezione.$invalid) {
        alert("form is invalid!")
    }
    $location.path("/gestioneRicercheRisultato");
}
}]);