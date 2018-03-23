class DataModel {
    private D d;
    public D getD() {
        return d;
    }
    public void setD(D d) {
        this.d = d;
    }

}

class D {
    private String myName;
    private String temperature;
    private String humidity;
    private String pressure;

    public String getMyName() {
        return myName;

    }
    public void setMyName(String myName) {
        this.myName = myName;

    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }
}

