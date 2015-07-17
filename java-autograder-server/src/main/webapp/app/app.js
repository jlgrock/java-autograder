var app = angular.module('javaCourses', [])
    .config(['$routeProvider',
        function($routeProvider) {
            $routeProvider.
                when('/home', {
                    templateUrl: 'templates/home.html'//,
                    //controller: 'AddOrderController'
                }).
                when('/courses', {
                    templateUrl: 'templates/courses.html'//,
                    //controller: 'AddOrderController'
                }).
                when('/account', {
                    templateUrl: 'templates/account.html'//,
                    //controller: 'ShowOrdersController'
                }).
                otherwise({
                    redirectTo: '/home'
                });
        }
    ]);