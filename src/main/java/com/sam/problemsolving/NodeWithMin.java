package com.sam.problemsolving;

public class NodeWithMin {
   private int value;
   private 	int min;
   public NodeWithMin(int value,int min) {
	   this.value=value;
	   this.min=min;
   }
@Override
public String toString() {
	return String.valueOf(value);
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public int getMin() {
	return min;
}
public void setMin(int min) {
	this.min = min;
}
}
