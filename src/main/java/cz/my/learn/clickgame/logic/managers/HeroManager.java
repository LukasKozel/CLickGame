package cz.my.learn.clickgame.logic.managers;

import cz.my.learn.clickgame.exception.ValidException;
import cz.my.learn.clickgame.logic.Hero;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Now only one hero
 * 
 * @author Lukas Kozel
 */
public class HeroManager {
    
    private Hero heroes;

    public HeroManager() {
    }

    public Hero getHeroes() {
        return heroes;
    }
    
    private boolean isNameValid(String name){
        if(name == null){
            return false;
        }
        Pattern paternValiName = Pattern.compile("\\w+");
        Matcher m = paternValiName.matcher(name);
        return m.matches();
    }
    
    public void createHero(String name) throws ValidException{
        if(isNameValid(name)){
            Hero hero = new Hero(name);
            this.heroes = hero;
            
        } else {
            throw new ValidException();
        }
    }
    
    public void updateHero(Hero hero){
        //TODO
    }
    
    private void deleteHero(Hero hero){
        //TODO
    }
    
    
    public Hero findHeroByName(String name){
        return this.heroes;
        //TODO 
    }
    /*
    public List<Hero> findAllHeroes(){
        return this.heroes;
    }
*/
}
