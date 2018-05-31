angular.module('app.module').controller('gestioneRicercheCancella.controller', ['$scope','$location', function($scope,$location){
console.log("gestioneRicercheCancella.controller");

$scope.submit = function () {
    if ($scope.gestioneRicercheCancella.$invalid) {
        alert("form is invalid!")
    }
    $location.path("/gestioneRicercheRisultato");
}
}]);