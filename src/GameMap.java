import java.util.ArrayList;
import java.util.List;


public class GameMap {
    public List<Ground> groundList = new ArrayList<Ground>();
    private int[] points = {20, 80, 100, 40, 80, 60};
    private String groundOwner = "0";

    public GameMap() {
        initalizeMap();
    }

    public List<Ground> initalizeMap() {

        groundList.clear();

        for (int i = 0; i <= 69; i++) {
            Ground ground = new Ground();
            if (i == 0) {
                ground = GroundFactory.buildStartGround();
            } else if (i > 0 && i < 28) {
                if (i != 14) {
                    ground = GroundFactory.buildEmptyGroundWithPrice(200);
                } else {
                    ground = GroundFactory.buildHospitalGround();
                }
            } else if (i == 28) {
                ground = GroundFactory.buildToyGround();
            } else if (i > 28 && i < 35) {
                ground = GroundFactory.buildEmptyGroundWithPrice(500);
            } else if (i == 35) {
                ground = GroundFactory.buildGiftGround();
            } else if (i > 35 && i < 63) {
                if (i != 49) {
                    ground = GroundFactory.buildEmptyGroundWithPrice(300);
                } else {
                    ground = GroundFactory.buildPrisonGround();
                }
            } else if (i == 63) {
                ground = GroundFactory.buildMagicGround();
            } else if (i > 63) {
                ground = GroundFactory.buildMoneyGround(points[i - 64]);
            }
            groundList.add(ground);
        }

        return groundList;

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
