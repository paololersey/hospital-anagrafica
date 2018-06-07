
/*
 * 	Set null if input text is empty
 */
angular.module("app.module").directive('emptyToNull', function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, elem, attrs, ctrl) {
            ctrl.$parsers.push(function(viewValue) {
            	
                if(viewValue === '' || viewValue === undefined) {
                    return null;
                }
                return viewValue;
            });
        }
    };
});
