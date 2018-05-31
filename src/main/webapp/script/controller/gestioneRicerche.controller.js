angular.module('app.module').controller('gestioneRicerche.controller', ['$scope', '$location', function ($scope, $location) {
    console.log("gestioneRicerche.controller");

    $scope.submitRicerca = function () {
        if ($scope.ricercaCliente.$invalid) {
            alert("form is invalid!")
        }
        $location.path("/gestioneRicercheRisultato");
    }

}]);