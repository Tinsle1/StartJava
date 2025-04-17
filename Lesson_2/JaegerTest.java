public class JaegerTest {
    public static void main(String[] args) {
        Jaeger chernoAlpha = new Jaeger();

        chernoAlpha.setJaeger("CHERNO ALPHA", "Mark-1", "Russia", "Destroyed",
                280f, 2.412f, 10, 10);

        String chernoAlphaModelName = chernoAlpha.getModelName();
        String chernoAlphaMark = chernoAlpha.getMark();
        String chernoAlphaOrigin = chernoAlpha.getOrigin();
        String chernoAlphaIsDestroyed = chernoAlpha.getStatus();
        float chernoAlphaHeight = chernoAlpha.getHeight();
        float chernoAlphaWeight = chernoAlpha.getWeight();
        int chernoAlphaStrength = chernoAlpha.getStrength();
        int chernoAlphaSpeed = chernoAlpha.getSpeed();

        Jaeger coyoteTango = new Jaeger("COYOTE TANGO", "Mark-1", "Japan",
                "Destroyed", 280f, 2.312f, 7, 5);  

        chernoAlpha.printFeatures();
        coyoteTango.printFeatures();

        chernoAlpha.run();
        chernoAlpha.swim();
        chernoAlpha.fight();

        coyoteTango.run();
        coyoteTango.swim();
        coyoteTango.fight();
    }
}