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
            Ground ground = null;
            if (isStartPoint(i)) {
                ground = GroundFactory.buildStartGround();
            } else if (isHospitalPoint(i)) {
                ground = GroundFactory.buildHospitalGround();
            } else if (isInAreaOne(i) || isInAreaTwo(i)) {
                ground = GroundFactory.buildEmptyGroundWithPrice(200);
            } else if (isToyPoint(i)) {
                ground = GroundFactory.buildToyGround();
            } else if (isInAreaThree(i)) {
                ground = GroundFactory.buildEmptyGroundWithPrice(500);
            } else if (isGiftPoint(i)) {
                ground = GroundFactory.buildGiftGround();
            } else if (isInAreaFour(i) || isInAreaFive(i)) {
                ground = GroundFactory.buildEmptyGroundWithPrice(300);
            } else if (isPrisonPoint(i)) {
                ground = GroundFactory.buildPrisonGround();
            }else if (isMagicPoint(i)) {
                ground = GroundFactory.buildMagicGround();
            } else if (isInMoneyArea(i)) {
                ground = GroundFactory.buildMoneyGround(points[i - 64]);
            }
            groundList.add(ground);
        }

        return groundList;

    }

    private boolean isInAreaFour(int i) {
        return i > 35 && i < 49;
    }

    private boolean isInAreaFive(int i) {
        return i > 49 && i < 63;
    }

    private boolean isInAreaThree(int i) {
        return i > 28 && i < 35;
    }

    private boolean isInAreaOne(int i) {
        return i > 0 && i < 14;
    }

    private boolean isInAreaTwo(int i) {
        return i > 14 && i < 28;
    }

    private boolean isInMoneyArea(int position) {
        return position > 63;
    }

    private boolean isMagicPoint(int position) {
        return position == 63;
    }

    private boolean isPrisonPoint(int position) {
        return position == 49;
    }

    private boolean isGiftPoint(int position) {
        return position == 35;
    }

    private boolean isToyPoint(int position) {
        return position == 28;
    }

    private boolean isHospitalPoint(int position) {
        return position == 14;
    }

    private boolean isStartPoint(int position) {
        return position == 0;
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
