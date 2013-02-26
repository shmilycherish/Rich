package Game;

/**
 * Created with IntelliJ IDEA.
 * User: shmilyhoney
 * Date: 13-2-22
 * Time: 下午2:01
 * To change this template use File | Settings | File Templates.
 */
public class GameMessage {

    public void  GameBeginWelcomeMessage(){
    System.out.println("欢迎开始大富翁游戏");
    }
    public void  setFundsPromptMessage(){
        System.out.println("设置玩家初始资金，范围1000～50000（默认10000）");
    }
    public void  choosePlayersPromptMessage(){
        System.out.println("请选择2~4位不重复玩家，输入编号即可。(1.钱夫人; 2.阿土伯; 3.孙小美; 4.金贝贝):");
    }
    public void propHouseWelcomeMessage()   {
        System.out.println("欢迎光临礼品屋，请选择一件您 喜欢的礼品：");
        System.out.println("礼    品  编号:");
        System.out.println("奖    金    1");
        System.out.println("点数卡   2");
        System.out.println("福     神   3");
        System.out.println("输入礼品编号选择礼品，只能选择一件礼品，选择后，自动退出礼品屋（输入错误视为放弃此次机会）");
    }

    public void GiftHouseWelcomeMessage()   {
        System.out.println("欢迎光临礼品屋，请选择一件您 喜欢的礼品：");
        System.out.println("礼    品  编号:");
        System.out.println("奖    金    1");
        System.out.println("点数卡   2");
        System.out.println("福     神   3");
        System.out.println("输入礼品编号选择礼品，只能选择一件礼品，选择后，自动退出礼品屋（输入错误视为放弃此次机会）");
    }
}
