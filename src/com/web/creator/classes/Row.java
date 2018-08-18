package com.web.creator.classes;

import java.util.ArrayList;
import java.util.List;

public class Row {

	private Integer idRow;
	private Integer nbColumns;
	public List<Column> listColumns;
	
	public Row() {
		//this.listColumns = new ArrayList<>();
	}
	
	public Row(Integer idRow) {
		this.idRow = idRow;
		//this.listColumns = new ArrayList<>();
	}
	
	public Row(Integer idRow, Integer nbColumns) {
		super();
		this.idRow = idRow;
		this.nbColumns = nbColumns;
		//this.listColumns = new ArrayList<>();
	}
	
	public Integer getIdRow() {
		return idRow;
	}
	public void setIdRow(Integer idRow) {
		this.idRow = idRow;
	}
	public Integer getNbColumns() {
		return nbColumns;
	}
	public void setNbColumns(Integer nbColumns) {
		this.nbColumns = nbColumns;
	}
	
	
}
