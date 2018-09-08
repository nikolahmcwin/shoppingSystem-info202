"use strict";

var module = angular.module('ShoppingApp', ['ngResource', 'ngStorage']);

module.factory('productDAO', function ($resource) {
    return $resource('/api/products/:id');
});

// Product controller
module.controller('ProductController', function (productDAO) {

});

// Customer controller

// Shopping cart controller