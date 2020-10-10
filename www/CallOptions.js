var exec = require('cordova/exec');

var PLUGIN_NAME = 'CallOptions';

var CallOptions = {
    CheckNumber: function (numbers, successCallback, errorCallback){
        exec(successCallback, errorCallback, PLUGIN_NAME, "CheckNumber", [numbers]);
  }
};

module.exports = CallOptions;