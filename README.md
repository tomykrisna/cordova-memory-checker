# description 
this plugin is codrova plugin for checking information RAM memory from your device 

## support
*android

## how to use
run command:
`cordova plugin add https://github.com/tomykrisna/cordova-memory-checker`

declare variable :
`declare var memory: any;`

and how to get the data information : <br/>
`memory.getMemoryInfo('data',(response) => {`<br/>
       `console.log('reponse', response)`<br/>
     `}, (err) => {`<br/>
       `console.log('error', err)`<br/>
     `});`


thankyou :)
