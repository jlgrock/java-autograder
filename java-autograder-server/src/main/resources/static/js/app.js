'use strict';

var courseModule = angular.module('com.github.jlgrock.autograder.course', [
    //'ngRoute',
    //'phonecatAnimations',
    //
    //'phonecatControllers',
    //'phonecatFilters',
    //'phonecatServices'
]).courseModule.controller("HelloController", function($scope) {
    $scope.helloTo = {};
    $scope.helloTo.title = "World, AngularJS";
});
