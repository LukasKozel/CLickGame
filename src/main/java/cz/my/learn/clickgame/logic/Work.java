package cz.my.learn.clickgame.logic;

/**
 *  Class representing work
 * 
 * @author Lukas Kozel
 */
public class Work {
    
    private Long id;
    private String name;
    private int level;
    private Long cost;
    private Long reward;
    private int time; 

    public Work(Long id, String name, Long cost, Long reward, int time) {
        this.id = id;
        this.name = name;
        this.level = 0;
        this.cost = cost;
        this.reward = reward;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    
    public Long getCost() {
        return cost;
    }

    public Long getReward() {
        return reward;
    }

    public int getTime() {
        return time;
    }

    public Object getId() {
        return id;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    public void setCost(Long cost) {
        this.cost = cost;
    }

    public void setReward(Long reward) {
        this.reward = reward;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    
    
}
