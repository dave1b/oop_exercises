package ch.hslu.sw10;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

final public class Motor implements Switchable {

	private final List<PropertyChangeListener> changeListeners = new ArrayList<>();
	//The state is stated in rpm.
	private MotorState state = MotorState.OFF;
    private int switches;
    
    static private enum MotorState {
    	
    	ON(), OFF(), STANDBY();	
    }
    
    
    
    @Override
    public void switchOn()
    {
    	if(!isSwitchedOn()) {
    		this.state = MotorState.ON;
    		final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this,"state",MotorState.OFF,MotorState.ON);
    		this.firePropertyChange(pcEvent);
    		increaseSwitches();   		
    	}
   
    }
    @Override
    public void switchOff() 
    {
    	if(isSwitchedOn()) {
    		this.state = MotorState.OFF;
    		final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this,"state",MotorState.ON,MotorState.OFF);
    		this.firePropertyChange(pcEvent);
    		increaseSwitches();   		
    	}
        increaseSwitches();
    }
    @Override
    public boolean isSwitchedOn()
    {             
        if(state == MotorState.ON) {
        	return true;
        } 
        return false;
    }
    @Override
     public void increaseSwitches() {
        switches++;
    }
    
    public int getSwitches(){
        return switches;
    }
    
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
    	if(listener != null) {        	
    	changeListeners.add(listener);
    	}
    }

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		if(listener != null) {        	
		changeListeners.remove(listener);
		}
	}
	
	public void firePropertyChange(final PropertyChangeEvent pcEvent) {
		for(final PropertyChangeListener listener : this.changeListeners) {
			listener.propertyChange(pcEvent);
		}		
	}
	
}
