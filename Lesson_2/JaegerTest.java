public class JaegerTest {
    public static void main(String[] args) {
        Jaeger chernoAlpha = new Jaeger();

        // задаем значения chernoAlpha
        chernoAlpha.setModelName("CHERNO ALPHA");
        chernoAlpha.setMark("Mark-1");
        chernoAlpha.setOrigin("Russia");
        chernoAlpha.setStatus("Destroyed");
        chernoAlpha.setHeight(280f);
        chernoAlpha.setWeight(2.412f);
        chernoAlpha.setStrength(10);
        chernoAlpha.setSpeed(5);

        // выводим значения chernoAlpha
        String chernoAlphaContent = """
                Jaeger {
                    Name: %s
                    Mark: %s
                    Origin: %s
                    Status: %s
                    Height: %f
                    Weight: %f
                    Strength: %d
                    Speed: %d
                }
                """.formatted(chernoAlpha.getModelName(), chernoAlpha.getMark(), chernoAlpha.getOrigin(), 
                chernoAlpha.getStatus(), chernoAlpha.getHeight(), chernoAlpha.getWeight(), 
                chernoAlpha.getStrength(), chernoAlpha.getSpeed());

        System.out.println(chernoAlphaContent);

        Jaeger coyoteTango = new Jaeger("COYOTE TANGO", "Mark-1", "Japan",
                "Destroyed", 280f, 2.312f, 7, 5);

        // выводим значения coyoteTango
        System.out.println(coyoteTango);

        // выводим методы объектов
        System.out.println("\nJaegers\' methods:");
        chernoAlpha.run();
        chernoAlpha.swim();
        chernoAlpha.fight();

        coyoteTango.run();
        coyoteTango.swim();
        coyoteTango.fight();
    }
}