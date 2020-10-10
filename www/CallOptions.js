var exec = require('cordova/exec');

var CallOptions = {
    CheckNumber: function(arg0, successCallback, errorCallback) {
        errorCallback = errorCallback || this.errorCallback;
        cordova.exec(success, error, 'CallOptions', 'CheckNumber', [arg0]);
    },

    errorCallback: function() {
        console.log("WARNING: CallOptions errorCallback not implemented");
    }
};

module.exports = CallOptions;