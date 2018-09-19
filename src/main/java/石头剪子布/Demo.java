package 石头剪子布;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Demo {

    private static final Map<Integer, String> styles = new HashMap<Integer, String>() {
        {
            put(0, "石头");
            put(2, "剪刀");
            put(5, "布");
        }
    };

    private static final int[] keys = new int[]{0, 2, 5};

    private static int control = 0;

    public static void main(String[] args) {
        while (true) {
            String exit = start();

            if (exit.equals("exit")) {
                break;
            }
        }
    }

    private static String start() {
        if (Demo.control == 0) {
            System.out.println("请输入你的手势：");
        }

        Scanner scanner = new Scanner(System.in);
        String youValue = scanner.nextLine();

        if ("exit".equals(youValue)) {
            return youValue;
        }

        if (!"石头".equals(youValue) && !"剪刀".equals(youValue) && !"布".equals(youValue)) {
            System.out.println("输入不合法，请重新你的手势：");
            Demo.control = 1;
            return youValue;
        }

        System.out.println("你：" + youValue);
        int youStyleType = getKey(youValue);
        int computerStyleType = getStyleType();
        boolean win = rule(youStyleType, computerStyleType);
        if (youStyleType == computerStyleType) {
            System.out.println("平手...");
        } else if (win) {
            System.out.println("你赢了...");
        } else {
            System.out.println("你输了...");
        }

        Demo.control = 0;

        System.out.println();
        System.out.println("请按任意键继续...");

        return scanner.nextLine();
    }

    private static int getStyleType() {
        int index = getIndex(styles.size());
        int key = keys[index];
        String value = getValue(key);
        System.out.println("电脑：" + value);
        return key;
    }

    private static int getIndex(int size) {
        return getRandomNumberInRange(0, size - 1);
    }

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();
    }

    private static String getValue(int key) {
        String value = "";

        for (Map.Entry<Integer, String> entry : styles.entrySet()) {
            if (key == entry.getKey()) {
                value = entry.getValue();
            }
        }
        return value;
    }

    private static int getKey(String value) {
        int key = 3;

        for (Map.Entry<Integer, String> entry : styles.entrySet()) {
            if (value.equals(entry.getValue())) {
                key = entry.getKey();
            }
        }
        return key;
    }

    private static boolean rule(int style1, int style2) {
        if (style1 == 0 && style2 == 5) {
            return false;
        }
        if (style1 == 2 && style2 == 0) {
            return false;
        }
        if (style1 == 5 && style2 == 2) {
            return false;
        }
        return true;
    }
}
