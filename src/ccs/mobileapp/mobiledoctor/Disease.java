package ccs.mobileapp.mobiledoctor;

public class Disease {

	int id;
    String name;
    String desc;
    String symp;
    String solu;
     
    public Disease(){
         
    }
    public Disease(int id, String name, String desc, String symp, String solu){
        this.id = id;
        this.name = name;
        this.desc = desc ;
        this.symp = symp;
        this.solu = solu;
    }
    public Disease(String name, String desc, String symp, String solu){
        this.name = name;
        this.desc = desc;
        this.symp = symp;
        this.solu = solu;
    }
    public int getID(){
        return this.id;
    }
    public void setID(int id){
        this.id = id;
    }
     
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getDesc(){
        return this.desc;
    }
    
    public void setDesc(String desc){
        this.desc = desc;
    }
    
    public String getSymp(){
        return this.symp;
    }
    
    public void setSymp(String symp){
        this.symp = symp;
    }
    
    public String getSolu(){
        return this.solu;
    }
    
    public void setSolu(String solu){
        this.solu = solu;
    }
}
