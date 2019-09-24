# description 
this plugin is for checking information RAM memory from your device 

## support
*android

## how to use
run command:
`cordova plugin add https://github.com/tomykrisna/cordova-memory-checker`

declare variable :
`declare var memory: any;`

and how to get the data information :

`memory.getMemoryInfo('data',(response) => {
       console.log('reponse', response)
     }, (err) => {
       console.log('error', err)
     });`


thankyou :)
