var mqtt = require('mqtt')
var client  = mqtt.connect('tcp://46.101.48.109:1883', {
  clientId: 'taey'
})

client.on('connect', function () {
  client.subscribe("CAMT/#")
  setInterval(() => {
    client.publish("CAMT/LATTE-005", 'Hello mqtt' + (Math.floor(Date.now() / 1000)))
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