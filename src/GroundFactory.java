public class GroundFactory {

    public static Ground buildPrisonGround() {
        Ground ground = new Ground();
        ground.initalizeGround("P");
        return ground;
    }

    public static Ground buildEmptyGroundWithPrice(int price) {
        Ground ground = new Ground();
        ground.initalizeGround("0");
        ground.setPrice(price);
        return ground;
    }

    public static Ground buildStartGround() {
        Ground ground = new Ground();
        ground.initalizeGround("S");
        return ground;
    }

    public static Ground buildHospitalGround() {
        Ground ground = new Ground();
        ground.initalizeGround("H");
        return ground;
    }

    public static Ground buildToyGround() {
        Ground ground = new Ground();
        ground.initalizeGround("T");
        return ground;
    }

    public static Ground buildGiftGround() {
        Ground ground = new Ground();
        ground.initalizeGround("G");
        return ground;
    }

    public static Ground buildMagicGround() {
        Ground ground = new Ground();
        ground.initalizeGround("M");
        return ground;
    }

    public static Ground buildMoneyGround(int point) {
        Ground ground = new Ground();
        ground.initalizeGround("$");
        ground.setPoint(point);
        return ground;
    }
}
