package controle;

public class Heater {
    private int temperature;
    private int min;
    private int max;
    private int increment;


    public Heater(int minimum, int maximo) {
        this.temperature = 15;
        this.min = minimum;
        this.max = maximo;
        this.increment = 5;
    }

    public void warmer() {
        if ((this.temperature + this.increment) <= this.max) {
            this.temperature += this.increment;
        }
    }

    public void cooler() {
        if ((this.temperature - this.increment) >= this.min) {
            this.temperature -= this.increment;
        }
    }

    public int getTemperature() {
        return this.temperature;
    }

    public void setIncrement(int value) {
        if(value >= 0) this.increment = value;
    }
}
