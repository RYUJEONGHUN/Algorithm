import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 색상별 값 설정
        HashMap<String, Integer> colorMap = new HashMap<>();
        colorMap.put("black", 0);
        colorMap.put("brown", 1);
        colorMap.put("red", 2);
        colorMap.put("orange", 3);
        colorMap.put("yellow", 4);
        colorMap.put("green", 5);
        colorMap.put("blue", 6);
        colorMap.put("violet", 7);
        colorMap.put("grey", 8);
        colorMap.put("white", 9);

        Scanner sc = new Scanner(System.in);

        // 색상 입력 받기
        String firstColor = sc.nextLine();
        String secondColor = sc.nextLine();
        String thirdColor = sc.nextLine();

        // 계산
        int firstDigit = colorMap.get(firstColor);
        int secondDigit = colorMap.get(secondColor);
        int multiplier = (int) Math.pow(10, colorMap.get(thirdColor));

        long result = (firstDigit * 10L + secondDigit) * multiplier;

        System.out.println(result);
    }
}
