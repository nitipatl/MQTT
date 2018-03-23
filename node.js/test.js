var mqtt = require('mqtt')
var client  = mqtt.connect('tcp://46.101.48.109:1883', {
  clientId: 'taey'
})

client.on('connect', function () {
  client.subscribe("KKU/#")
  setInterval(() => {
    client.publish("KKU/test", '{"info":{"ssid":"metallic-guppys","flash_size":4194304,"flash_id":"1640c8","chip_id":"41ba19","sdk":"2.2.1(cfd48f3)","mac":"60:01:94:41:ba:19","id":"4307481","client_id":"4307481","device_id":"41ba19","prefix":"KKU/","ip":"192.168.0.185","version":"v1.0.4"},"d":{"myName":"LATTE-00'+Math.floor((Math.random() * 10) + 1)+'","millis":52685,"temperature":'+Math.floor((Math.random() * 100) + 1)+',"humidity":'+Math.floor((Math.random() * 100) + 1)+',"pressure":'+Math.floor((Math.random() * 100) + 1)+',"relayState":1,"updateInterval":1000,"A0":818,"heap":39560,"rssi":-37,"counter":45,"subscription":1}}')
  }, 1000)
  
})
client.on('error', function (e) {
  console.log('Error! ' + e)
})
client.on('message', function (topic, message) {
  // message is Buffer
  console.log('Recieved: ' + message.toString())
  // client.end()
})