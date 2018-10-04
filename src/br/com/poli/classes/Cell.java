package br.com.poli.classes;

public class Cell {
	
	
	private int value;
    private boolean valid;
    private boolean fixed;
    
    public Cell() {
		super();
	}
    
	public Cell(int value) {
  	  this.value=value;
    }
	
    public void setValue(int value) {
  	   this.value=value;
    }
    
    public int getValue() {
  	  return this.value;
    }
    
    public boolean setFixed() {
  	  if(value!=0)
  		  return this.fixed = true;
  	  else 
  		  return this.fixed = false;
    }
    
    public boolean isFixed() {
  	  return this.fixed;
    }
    
    public boolean setValid(int value) {
  	  if(value<=9 && value>=1)
  		  return this.valid = true;
  	  else
  		  return this.valid = false;
    }
    
    public boolean isValid(){
  	  return this.valid;
    }

}
