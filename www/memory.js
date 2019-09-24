var exec = require('cordova/exec');

module.exports.getMemoryInfo = function (arg0, success, error) {
    console.log('coolMethod call')
    exec(success, error, 'memory', 'getMemoryInfo', [arg0]);
};
