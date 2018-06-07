angular.module('app.module').controller('gestioneRicercheCancella.controller', ['$scope', '$location', '$http', 'dataStoreService', function ($scope, $location, $http, dataStoreService) {
    console.log("gestioneRicercheCancella.controller");


    $scope.cliente = dataStoreService.cliente;
    
    $scope.submit = function () {
        if ($scope.gestioneRicercheCancella.$invalid) {
            alert("form is invalid!")
        }
        dataStoreService.cliente = $scope.cliente;
        $http.delete("http://localhost:8083/bank-academy/rest/clienti/deleteCliente/" + $scope.cliente.id).then(result => {
            console.log(result);
        });
        $location.path("/gestioneRicercheRisultato");
    }
}]);