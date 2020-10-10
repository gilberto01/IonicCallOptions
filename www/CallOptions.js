var exec = require('cordova/exec');

exports.CheckNumber = function (arg0, success, error) {
    exec(success, error, 'CallOptions', 'CheckNumber', [arg0]);
};
