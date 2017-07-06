var app = angular.module('myApp', []);

        app.directive('cgThumbnail', function(){
            return {
                restrict : 'E',
                templateUrl: 'tags/thumbnail.html',
                scope: {
                    title: '@title',
                    summary: '@summary'
                }
            }
        })

        app.controller('ThumbCtrl', function($scope){
            $scope.courses = [
                {title: 'AngularJS', summary:'Its a framework from Google'},
                {title: 'ReactJS', summary:'Its a library from Facebook'},
                {title: 'EmberJS', summary:'Its a framework and open-source'},
                {title: 'CanJS', summary:'Its a framework and really good'},
                {title: 'ExtJS', summary:'Meant for business apps'}
            ]
        })