package pl.mateusz.drozdz.fishing_essentials.dao;

import java.util.ArrayList;
import java.util.List;

public class MyRecordsFishes {

	private List<CaughtFish> caughtFishesList= new ArrayList<CaughtFish>();
	private List<Fishes> fishes = new ArrayList<Fishes>();
	
	public List<CaughtFish> getCaughtFishesList() {
		return caughtFishesList;
	}
	public void setCaughtFishesList(List<CaughtFish> caughtFishesList) {
		this.caughtFishesList = caughtFishesList;
	}
	public List<Fishes> getFishes() {
		return fishes;
	}
	public void setFishes(List<Fishes> fishes) {
		this.fishes = fishes;
	}	
	
}
