package cz.my.learn.clickgame.logic;

import cz.my.learn.clickgame.logic.managers.WorkManager;

/**
 * Class representing player as Hero
 * 
 * @author Lukas Kozel
 */
public class Hero {
    
    private String name;
    private WorkManager workManager;
    private Long cash;

    public Hero(String name) {
        this.name = name;
        this.cash = 10L;
        this.workManager = new WorkManager();
        this.workManager.createStandartWork();
    }

    public void setCash(Long cash) {
        this.cash = cash;
    }
    
    public String getName() {
        return name;
    }

    public WorkManager getWorkManager() {
        return workManager;
    }

    public Long getCash() {
        return cash;
    }   
}
