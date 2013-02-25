package Game;

import java.util.ArrayList;
import java.util.List;


public class GameMap {
    private List<Ground> groundList = new ArrayList<Ground>();
    private int[] points = {20, 80, 100, 40, 80, 60};
    private String groundOwner = "0";

    public GameMap() {
        initalizeMap();
    }

    public List<Ground> initalizeMap() {

        groundList.clear();

        initStartGround();
        initAreaOne();
        initHospitalGround();
        initAreaTwo();
        initToyGround();
        intiAreaThree();
        initGiftGround();
        intiAreaFour();
        initPrisonGround();
        intiAreaFive();
        initMagicGround();
        initMoneyGround();

        return groundList;

    }

    public List<Ground> getGroundList(){
        return groundList ;
    }

    private void initToyGround() {
        groundList.add(GroundFactory.buildToyGround());
    }

    private void initMoneyGround() {
        for(int i=0; i<points.length; i++){
            groundList.add(GroundFactory.buildMoneyGround(points[i]));
        }
    }

    private void initMagicGround() {
        groundList.add(GroundFactory.buildMagicGround());
    }

    private void intiAreaFive() {
        for (int i = 0; i < 13; i++) {
            groundList.add(GroundFactory.buildEmptyGroundWithPrice(300));
        }
    }

    private void initPrisonGround() {
        groundList.add(GroundFactory.buildPrisonGround());
    }

    private void intiAreaFour() {
        for (int i = 0; i < 13; i++) {
            groundList.add(GroundFactory.buildEmptyGroundWithPrice(300));
        }
    }

    private void initGiftGround() {
        groundList.add(GroundFactory.buildGiftGround());
    }

    private void intiAreaThree() {
        for (int i = 0; i < 6; i++) {
            groundList.add(GroundFactory.buildEmptyGroundWithPrice(500));
        }
    }

    private void initAreaTwo() {
        for (int i = 0; i < 13; i++) {
            groundList.add(GroundFactory.buildEmptyGroundWithPrice(200));
        }
    }

    private void initHospitalGround() {
        groundList.add(GroundFactory.buildHospitalGround());
    }

    private void initStartGround() {
        groundList.add(GroundFactory.buildStartGround());
    }

    private void initAreaOne() {
        for (int i = 0; i < 13; i++) {
            groundList.add(GroundFactory.buildEmptyGroundWithPrice(200));
        }
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
