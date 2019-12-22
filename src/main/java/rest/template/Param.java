package rest.template;

public class Param {
    private String Key;
    private String Value;

    public Param(String key, String value){
        this.Key = key;
        this.Value = value;
    }

    public String getKey() {return Key;}
    public void setKey(String key){
        this.Key = key;
    }

    public  String getValue(){return  Value;}
    public  void setValue(String value){
        this.Value = value;
    }

    @Override
    public  Param clone(){
        return  new Param(this.getKey(), this.getValue());
    }
}
