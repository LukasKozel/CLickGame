package cz.my.learn.clickgame.logic.managers;

import cz.my.learn.clickgame.exception.ValidException;
import cz.my.learn.clickgame.logic.Work;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lukas Kozel
 */
public class WorkManager {
    
    private List<Work> works = new ArrayList<>();

    public WorkManager() {
    }
    
    private void createWork(String name, Long cost, Long reward, int time) throws ValidException{  
        if((name == null) || (cost == null) || (cost.compareTo(0L) <= 0) || 
                (reward == null) || (reward.compareTo(0L) <= 0) || (time <= 0)){
            throw new ValidException();
        } else {
            long l = works.size() + 1;
            Long ll = l;
            Work newWork = new Work(ll, name, cost, reward, time);
            
            this.works.add(newWork);    
        }
    }
    
    public void updateWork(Work work){
        //TODO
    }
    
    /* // kvuli jednoduchemu id nemuzu mazat
    private void deleteWork(Work work) throws ValidException{
        if(this.works.contains(work)){
            this.works.remove(work);
        } else {
            throw new ValidException();
        }
    }
    */
    
    public Work findWorkById(Long id){
        for(Work work : this.works){
            if(id.equals(work.getId()))
                return work;
        }
        
        return null;
    }
    
    private List<Work> findAllWorks(){
        return this.works;
    }

    public void createStandartWork() {
        try{
            this.createWork("Hubení krys", 10L, 5L, 50);
            this.createWork("Lov vlků", 100L, 50L, 20);
            this.createWork("Záchrana princezny", 1000L, 500L, 60);
            this.createWork("Souboj s drakem", 10000L, 5000L, 100);    
        }catch(ValidException ex){
            System.out.println("Spatne zadane prace.");
        }
    }
    
    public void levelUp(Long id){
       Work workForUp = this.findWorkById(id);
       if(workForUp != null){
           workForUp.setCost(workForUp.getCost() + 5L);
           workForUp.setLevel(workForUp.getLevel() + 1);
           workForUp.setReward(workForUp.getReward() * 2L);
       } else {
           System.out.println("Neplatne id");
       }
    }
}
