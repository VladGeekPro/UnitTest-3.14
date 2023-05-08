package tests;

public class Currency implements Cloneable {

    String cname1;
    String cname2;
    String data;
    Double value;
    Integer number;
    
    public Currency() {
        this.cname1 = null;
        this.cname2 = null;
        this.data = null;
        this.value = null;
        this.number = null; 
    }
    
    public Currency(String c1, String c2, String d, Double v, Integer n ) 
    {
        this.cname1 = c1;
        this.cname2 = c2;
        this.data = d;
        this.value = v;
        this.number = n;
    }
    
    public Currency(Currency currency )
    {
        this.cname1 = currency.cname1;
        this.cname2 = currency.cname2;
        this.data = currency.data;
        this.value = currency.value;
        this.number = currency.number;  
    }
    
    public void displayCurrency() {
        System.out.println("cname1 : " + this.cname1);
        System.out.println("cname2 : " + this.cname2);
        System.out.println("data : " + this.data);
        System.out.println("value : " + this.value);
        System.out.println("number : " + this.number);
    }
    
    
    
    @Override
    public Currency clone() throws CloneNotSupportedException 
    {
        return (Currency) super.clone();
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof Currency)) return false;
        Currency otherCurrency = (Currency) obj;
        return this.cname1.equals(otherCurrency.cname1) &&
               this.cname2.equals(otherCurrency.cname2) &&
               this.data.equals(otherCurrency.data) &&
               this.value.equals(otherCurrency.value) &&
               this.number.equals(otherCurrency.number);
    } 
    
    public Integer getNumber(){ return number;}
    public String getCname1(){ return cname1;}
    public String getCname2(){ return cname2;}
    public String getData(){ return data;}
    public Double getValue(){ return value;}
}