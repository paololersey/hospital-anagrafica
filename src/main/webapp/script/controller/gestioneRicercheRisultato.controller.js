angular.module('app.module').controller('gestioneRicercheRisultato.controller', ['$scope', '$http', 'dataStoreService', '$location', function ($scope, $http, dataStoreService, $location) {
    console.log("gestioneRicercheRisultato.controller");
    $scope.clienti = dataStoreService.clienti;

    $scope.search = {};
    if (dataStoreService.search) {
        $scope.search = dataStoreService.search;
    }

    $scope.tableRowClickedEdit = function (cliente) {
        dataStoreService.cliente = cliente;
        $location.path("/inserimentoCliente");
    };

    $scope.tableRowClickedDelete = function (cliente) {
        dataStoreService.cliente = cliente;
        $location.path("/gestioneRicercheCancella");
    };

    $http.get("http://localhost:8083/bank-academy/rest/province/getProvinceList").then(result => {
        console.log(result.data);
        $scope.province = result.data;
    });

    $http.get("http://localhost:8083/bank-academy/rest/prodotti/getProdottiList").then(result => {
        console.log(result.data);
        $scope.prodotti = result.data;
    });

    $scope.submit = function () {
        if (!$scope.search) {
            alert("form is invalid!")
        }
        $http.post("http://localhost:8083/bank-academy/rest/clienti/getClientiWithProdotto", $scope.search).then(result => {
            console.log(result.data);
            result.data.forEach(element => {
                element.dataNascita = new Date(element.dataNascita);
            });
            dataStoreService.clienti = result.data;
            $scope.clienti = result.data;
            dataStoreService.search = $scope.search;
        });

    }


}]);