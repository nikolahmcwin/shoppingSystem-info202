"use strict";

var module = angular.module('ShoppingApp', ['ngResource', 'ngStorage']);

// factories
module.factory('productDAO', function ($resource) {
    return $resource('/api/products/:id');
});

module.factory('categoryDAO', function ($resource) {
    return $resource('/api/categories/:cat');
});

module.factory('registerDAO', function ($resource) {
    return $resource('/api/register');
});

module.factory('signInDAO', function ($resource) {
    return $resource('/api/customers/:username');
});

// Product controller
module.controller('ProductController', function (productDAO, categoryDAO) {

    // load the products
    this.products = productDAO.query();

    // load the categories
    this.categories = categoryDAO.query();

    // click handler for the category filter buttons
    this.selectCategory = function (selectedCat) {
        this.products = categoryDAO.query({"cat": selectedCat});
    };

    this.displayAll = function () {
        this.products = productDAO.query();
    };

});

// Customer controller
module.controller('CustomerController', function (registerDAO, signInDAO, $sessionStorage, $window) {

    this.signInMessage = "Please sign in to continue.";
    let ctrl = this; 
    
    this.registerCustomer = function (customer) {
        registerDAO.save(null, customer);
        console.log(customer);
        //ctrl.signInMessage = "Account created successfully. Please sign in to continue.";
        $window.location.href = '/signin.html';
    };


       
    this.signIn = function (username, password) {
        
        signInDAO.get({'username': username},
        
            // success
            function (customer) {
                $sessionStorage.customer = customer;
                $window.location.href = '.';
            },
            // fail
            function () {
                ctrl.signInMessage = 'Sign in failed. Please try again.';
            }
        );
    };
});


// Shopping cart controller