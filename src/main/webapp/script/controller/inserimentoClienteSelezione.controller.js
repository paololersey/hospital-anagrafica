angular.module('app.module').controller('inserimentoClienteSelezione.controller', ['$scope','$location','dataStoreService','$http', function($scope, $location, dataStoreService, $http){
console.log("inserimentoClienteSelezione.controller");

$scope.cliente = dataStoreService.cliente;

$http.get("http://localhost:8083/bank-academy/rest/prodotti/getProdottiList").then(result => {
    console.log(result.data);
    $scope.prodotti = result.data;
});

$scope.submit = function () {
    if ($scope.inserimentoClienteSelezione.$invalid) {
        alert("form is invalid!")
    }
    dataStoreService.cliente = $scope.cliente;
    $location.path("/inserimentoClienteConferma");
}
}]);