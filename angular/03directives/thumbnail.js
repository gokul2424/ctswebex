var app = angular.module('myApp', ['ui.bootstrap']);

app.directive('cgThumbnail', function () {
    return {
        restrict: 'E',
        templateUrl: 'tags/thumbnail.html',
        scope: {
            title: '@title',
            summary: '@summary'
        }
    }
})

app.controller('ThumbCtrl', function ($scope, $http) {

    $http({
        url: "courses.json",
        method: 'GET'
    }).then(function (response) {
        console.log(response.data);
        $scope.courses = response.data
    });


    $scope.rate = 7;
    $scope.max = 10;
    $scope.isReadonly = false;

    $scope.hoveringOver = function (value) {
        $scope.overStar = value;
        $scope.percent = 100 * (value / $scope.max);
    };

    $scope.ratingStates = [
        { stateOn: 'glyphicon-ok-sign', stateOff: 'glyphicon-ok-circle' },
        { stateOn: 'glyphicon-star', stateOff: 'glyphicon-star-empty' },
        { stateOn: 'glyphicon-heart', stateOff: 'glyphicon-ban-circle' },
        { stateOn: 'glyphicon-heart' },
        { stateOff: 'glyphicon-off' }
    ];


    // $scope.courses = 
})