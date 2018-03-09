var mqtt = require('mqtt')
var client  = mqtt.connect('mqtt://test.mosquitto.org')

client.on('connect', function () {
  client.subscribe('presence')
  setInterval(() => {
    client.publish('presence', 'Hello mqtt' + (Math.floor(Date.now() / 1000)))
  }, 1000)
  
})

client.on('message', function (topic, message) {
  // message is Buffer
  console.log('Recieved: ' + message.toString())
  // client.end()
})