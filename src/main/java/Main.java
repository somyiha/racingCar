import controller.RacingController;
import domain.CarFactory;
import domain.RacingRule;
import service.RacingService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var rule = new RacingRule();
        var factory = new CarFactory();
        var service = new RacingService(rule, factory);
        var controller = new RacingController(service);

        System.out.println("5자 이하의 자동차 이름을 입력 (','으로 구분)");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String cars = bufferedReader.readLine();
        System.out.println("횟수 입력");
        int tryCount = Integer.parseInt(bufferedReader.readLine());
        controller.startRacing(cars, tryCount);
    }
}
