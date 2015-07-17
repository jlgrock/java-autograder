app.directive('breadcrumb', function() {
        return {
            restrict: 'E',
            replace: true,
            transclude: true,
            templateUrl: 'templates/breadcrumb.html'
        }});