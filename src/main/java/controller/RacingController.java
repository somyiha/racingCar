package controller;

import service.RacingService;

public class RacingController {
    private final RacingService service;

    public RacingController(RacingService service) {
        this.service = service;
    }

    public void startRacing(String carNames, Integer tryCount) {

        service.start(carNames, tryCount);

    }

}
