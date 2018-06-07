angular.module('app.module').controller('inserimentoClienteConferma.controller', ['$scope','$location','dataStoreService', '$http', function($scope, $location, dataStoreService, $http){
console.log("inserimentoClienteConferma.controller");

$scope.cliente = dataStoreService.cliente;

$scope.submit = function () {
    if ($scope.inserimentoClienteConferma.$invalid) {
        alert("form is invalid!")
    }
    dataStoreService.cliente = $scope.cliente;
    $http.put("http://localhost:8083/bank-academy/rest/clienti/insertEditCliente", $scope.cliente).then(result => {
        console.log(result.data);
        $scope.prodotti = result.data;
        $location.path("/gestioneRicerche");
    });
}
}]);