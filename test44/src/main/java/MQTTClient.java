import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import java.io.IOException;

public class MQTTClient implements MqttCallback {
    MqttClient client;

    public static void main(String[] args) {
        MQTTClient d = new MQTTClient();
        d.Start();
    }


    public void Start() {
        String mqttServer = "tcp://46.101.48.109:1883";
        String clientName = "test";

        try {
            client = new MqttClient(mqttServer, clientName);
            client.connect();
            System.out.println("Connected");
            client.setCallback(this);
            client.subscribe("KKU/#");
            try {
                System.in.read();
            } catch (IOException e) {
                //end process.
            }
            client.disconnect();
            System.out.println("Disconnected");
            System.exit(0);

        } catch (MqttException e) {
            System.out.println(e);
        }
    }

    public void connectionLost(Throwable cause) {
        // TODO Auto-generated method stub

    }

    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // System.out.println(message);
        try {
            DataModel data = new Gson().fromJson(message.toString(), DataModel.class);
            System.out.print("Name: " + data.getD().getMyName());
            System.out.print(" Humidity: " + data.getD().getHumidity());
            System.out.print(" Pressure: " + data.getD().getPressure());
            System.out.print(" Temperature: " + data.getD().getTemperature());
            System.out.println();

        } catch (Exception e) {
            // error
        }

    }

    public void deliveryComplete(IMqttDeliveryToken token) {
        // TODO Auto-generated method stub

    }

}

