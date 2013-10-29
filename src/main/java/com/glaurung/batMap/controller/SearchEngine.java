package com.glaurung.batMap.controller;

import java.awt.event.ItemListener;
import java.io.IOException;

import com.glaurung.batMap.gui.search.SearchPanel;
import com.glaurung.batMap.io.AreaDataPersister;
import com.glaurung.batMap.vo.AreaSaveObject;
import com.glaurung.batMap.vo.Exit;
import com.glaurung.batMap.vo.Room;

import edu.uci.ics.jung.graph.SparseMultigraph;

public class SearchEngine extends MapperEngine implements ItemListener{

	private String areaName;
	private String mapperArea;
	private boolean savingAlreadyDisabled = false;
	
	public SearchEngine(SparseMultigraph<Room, Exit> graph){
		this();
		this.graph = graph;
		this.mapperLayout.setGraph(graph);
	}
	
	public SearchEngine(){
		super();
        panel = new SearchPanel(this);
	}
	
	public void moveToRoom(Room room){
		if(area == null || !area.getName().equals( room.getArea().getName())){
			moveToArea(room.getArea().getName());			
		}
		for(Room aRoom : graph.getVertices()){

			if(aRoom.equals(room)){
				currentRoom=aRoom;
				aRoom.setPicked(true);
				aRoom.setCurrent(true);
			}else{
				aRoom.setPicked(false);
				aRoom.setCurrent(false);
			}	
		}

		pickedRoom = room;
		this.panel.setTextForDescs(pickedRoom.getShortDesc(), pickedRoom.getLongDesc(), makeExitsStringFromPickedRoom(), pickedRoom);
		repaint();
		moveMapToStayWithCurrentRoom();
	}


	protected void saveCurrentArea(){
		
	}

	public void setPanel(SearchPanel panel) {
		this.panel = panel;
	}

	protected void moveToArea(String areaName){
		AreaSaveObject areaSaveObject= null;
		try {
			areaSaveObject = AreaDataPersister.loadData(baseDir,areaName);	
		} catch (ClassNotFoundException e) {
			return;
		} catch (IOException e) {
			return;
		}
		this.areaName = areaName;
		this.graph = areaSaveObject.getGraph();
		mapperLayout.displayLoadedData(areaSaveObject);
		if(!this.areaName.equalsIgnoreCase(this.mapperArea)){
			savingAlreadyDisabled=false;
		}
		checkIfCanSaveMap();
	}


	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
		
	}

	public String getBaseDir(){
		return this.baseDir;
	}

	public void checkIfCanSaveMap(){
		if(this.areaName.equalsIgnoreCase(this.mapperArea) || savingAlreadyDisabled){
			SearchPanel tempPanel = (SearchPanel) this.panel;
			tempPanel.toggleSaveAbility(false);
			savingAlreadyDisabled =true;
		}else{
			SearchPanel tempPanel = (SearchPanel) this.panel;
			tempPanel.toggleSaveAbility(true);
		}
		
	}

	public void setMapperArea(String areaName) {
		this.mapperArea=areaName;
		checkIfCanSaveMap();
	}
	
}
