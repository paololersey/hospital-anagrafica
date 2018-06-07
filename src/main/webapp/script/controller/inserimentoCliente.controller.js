angular.module('app.module').controller('inserimentoCliente.controller', ['$scope','$location','$http','dataStoreService', function($scope, $location, $http, dataStoreService){
console.log("inserimentoCliente.controller");

$scope.cliente = {};
if(dataStoreService.cliente){
    $scope.cliente = dataStoreService.cliente;
}


$http.get("http://localhost:8083/bank-academy/rest/province/getProvinceList").then(result => {
    console.log(result.data);
    $scope.province = result.data;
});



$scope.submit = function () {
    if ($scope.inserimentoCliente.$invalid) {
        alert("form is invalid!")
    }
    dataStoreService.cliente = $scope.cliente;
    $location.path("/inserimentoClienteConsiglio");
}

}]);