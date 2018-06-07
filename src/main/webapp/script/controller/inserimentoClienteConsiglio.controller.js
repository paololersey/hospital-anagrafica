angular.module('app.module').controller('inserimentoClienteConsiglio.controller', ['$scope','$location','dataStoreService','$http', function($scope, $location, dataStoreService, $http){
console.log("inserimentoClienteConsiglio.controller");

$scope.cliente = dataStoreService.cliente;

$http.post("http://localhost:8083/bank-academy/rest/prodotti/getProdottoSuggestion", $scope.cliente).then(result => {
    console.log(result.data);
    $scope.prodottoConsigliato = result.data;
});

$scope.submit = function () {
    if ($scope.inserimentoClienteConsiglio.$invalid) {
        alert("form is invalid!")
    }
    $scope.cliente.nomeProdotto = $scope.prodottoConsigliato.nomeProdotto;
    dataStoreService.cliente = $scope.cliente;
    $location.path("/inserimentoClienteSelezione");
}
}]);