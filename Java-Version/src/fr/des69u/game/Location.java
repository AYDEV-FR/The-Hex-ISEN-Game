package fr.des69u.game;

import java.util.ArrayList;


public class Location { 
	  public final int i; 
	  public final int j; 
	  public Location(int i, int j) { 
	    this.i = i; 
	    this.j = j; 
	  } 
	  public String toString() {
		  return "Location : " + this.i + "," + this.j;
	  }
	  public boolean isEquals(Location loc) {
		  if(this.i == loc.i && this.j == loc.j) {
			  return true;
		  }
		  return false;
	  }

} 