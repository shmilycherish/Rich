import java.util.ArrayList;
import java.util.List;


public class GameMap {
    public List<Ground> groundList = new ArrayList<Ground>();
    private int[] point = {20, 80, 100, 40, 80, 60};
    private String groundOwner = "0";

    public GameMap() {
        initalizeMap();
    }

    public List<Ground> initalizeMap() {

        groundList.clear();

        for (int i = 0; i <= 69; i++) {
            Ground ground = new Ground();
            if (i == 0) {
                ground = buildStartPoint();
            } else if (i > 0 && i < 28) {
                if (i != 14) {
                    ground = buildEmptyPointWithPrice(200);
                } else {
                    ground = buildHospitalPoint();
                }
            } else if (i == 28) {
                ground = buildToyPoint();
            } else if (i > 28 && i < 35) {
                ground = buildEmptyPointWithPrice(500);
            } else if (i == 35) {
                ground = buildGiftPoint();
            } else if (i > 35 && i < 63) {
                if (i != 49) {
                    ground = buildEmptyPointWithPrice(300);
                } else {
                    ground = buildPrisonPoint();
                }
            } else if (i == 63) {
                ground.initalizeGround("M");
            } else if (i > 63) {
                ground = buildMoneyPoint(i);
            }
            groundList.add(ground);
        }

        return groundList;

    }

    private Ground buildMoneyPoint(int i) {
        Ground ground = new Ground();
        ground.initalizeGround("$");
        ground.setPoint(point[i - 64]);
        return ground;
    }

    private Ground buildPrisonPoint() {
        Ground ground = new Ground();
        ground.initalizeGround("P");
        return ground;
    }

    private Ground buildGiftPoint() {
        Ground ground = new Ground();
        ground.initalizeGround("G");
        return ground;
    }

    private Ground buildToyPoint() {
        Ground ground = new Ground();
        ground.initalizeGround("T");
        return ground;
    }

    private Ground buildHospitalPoint() {
        Ground ground = new Ground();
        ground.initalizeGround("H");
        return ground;
    }

    private Ground buildEmptyPointWithPrice(int price) {
        Ground ground = new Ground();
        ground.initalizeGround("0");
        ground.setPrice(price);
        return ground;
    }

    private Ground buildStartPoint() {
        Ground ground = new Ground();
        ground.initalizeGround("S");
        return ground;
    }

    public void printMap() {
        for (int i = 0; i <= 28; i++) {
            System.out.print(groundList.get(i).getDisplay());
        }
        System.out.println();
        int cha = 40;

        for (int i = 29; i <= 34; i++) {
            printLine(i + cha, i);
            cha = cha - 2;
        }
        for (int i = 63; i >= 35; i--) {
            System.out.print(groundList.get(i).getDisplay());
        }
    }

    public void printLine(int firstGround, int lastGround) {
        System.out.print(groundList.get(firstGround).getDisplay());
        for (int i = 1; i <= 27; i++)
            System.out.print(" ");
        System.out.println(groundList.get(lastGround).getDisplay());
    }

}
