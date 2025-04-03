public class WolfTest {
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.gender = "male";
        wolfOne.nickname = "Auf";
        wolfOne.weight = 40.2f;
        wolfOne.age = 14;
        wolfOne.colour = "gray";

        System.out.println(wolfOne.gender + ", " + wolfOne.nickname + ", " + wolfOne.weight +
                ", " + wolfOne.age + ", " + wolfOne.colour + "\n");

        wolfOne.go();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}
