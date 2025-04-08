public class WolfTest {
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.setGender("male");
        wolfOne.setNickname("Auf");
        wolfOne.setWeight(40.2f);
        wolfOne.setAge(14);
        wolfOne.setColour("gray");

        String wolfOneGender = wolfOne.getGender();
        String wolfOneNickname = wolfOne.getNickname();
        float wolfOneWeight = wolfOne.getWeight();
        int wolfOneAge = wolfOne.getAge();
        String wolfOneColour = wolfOne.getColour();

        System.out.println(wolfOneGender + ", " + wolfOneNickname + ", " + wolfOneWeight +
                ", " + wolfOneAge + ", " + wolfOneColour + "\n");

        wolfOne.go();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}
