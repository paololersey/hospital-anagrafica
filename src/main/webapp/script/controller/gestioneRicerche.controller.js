angular.module('app.module').controller('gestioneRicerche.controller', ['$scope', '$location', '$http','dataStoreService', function ($scope, $location, $http, dataStoreService) {
    console.log("gestioneRicerche.controller");

    $scope.search = {};
    if(dataStoreService.search){
        $scope.search = dataStoreService.search;
    }
   

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
            dataStoreService.search = $scope.search;
            $location.path("/gestioneRicercheRisultato");
        });
        
    }

}]);