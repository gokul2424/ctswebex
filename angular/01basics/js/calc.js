var app = angular.module('calcApp', [])
app.controller('CalcCtrl', function ($scope) {
    $scope.sum = function () {
        $scope.result = $scope.oper1 + $scope.oper2;
    }
})