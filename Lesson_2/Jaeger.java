public class Jaeger {
    private String modelName;
    private String mark;
    private String origin;
    private String status;
    private float height;
    private float weight;
    private int strength;
    private int speed;

    public void run() {
        System.out.println("running");
    }

    public void swim() {
        System.out.println("swimming");
    }

    public void fight() {
        System.out.println("fighting");
    }

    public Jaeger() {}

    public Jaeger(String modelName, String mark, String origin, String status, float height,
            float weight, int strength, int speed) {
        this.modelName = modelName;
        this.mark = mark;
        this.origin = origin;
        this.status = status;
        this.height = height;
        this.weight = weight;
        this.strength = strength;
        this.speed = speed;
    }

    public void setJaeger(String modelName, String mark, String origin, String status,
            float height, float weight, int strength, int speed) {
        this.modelName = modelName;
        this.mark = mark;
        this.origin = origin;
        this.status = status;
        this.height = height;
        this.weight = weight;
        this.strength = strength;
        this.speed = speed;
    }

    public String getModelName() {
        return modelName;
    }

    public String getMark() {
        return mark;
    }

    public String getOrigin() {
        return origin;
    }

    public String getStatus() {
        return status;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight; 
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void printFeatures() {
        System.out.println("Jaeger " + modelName + " has features:\n" +
                "Mark: " + mark + "\n" + "Origin: " + origin + "\n" +
                "Status: " + status + "\n" + "Height: " + height + " ft" + "\n" +
                "Weight: " + weight + " Tons" + "\n" + "Strength: " + strength + "\n" +
                "Speed: " + speed + "\n");
    }  
}