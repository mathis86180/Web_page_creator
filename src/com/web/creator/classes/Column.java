package com.web.creator.classes;

public class Column {
	
	private Integer idColumn;
	private Integer SizeColumn;
	private String textColumn;
	
	public Column() {
		
	}
	
	public Column(Integer idColumn) {
		super();
		this.idColumn = idColumn;
	}
	
	public Column(Integer idColumn, Integer sizeColumn) {
		super();
		this.idColumn = idColumn;
		this.SizeColumn = sizeColumn;
	}
	
	public Column(Integer idColumn, Integer sizeColumn, String textColumn) {
		super();
		this.idColumn = idColumn;
		this.SizeColumn = sizeColumn;
		this.textColumn = textColumn;
	}
	
	public Integer getIdColumn() {
		return idColumn;
	}
	public void setIdColumn(Integer idColumn) {
		this.idColumn = idColumn;
	}
	public Integer getSizeColumn() {
		return SizeColumn;
	}
	public void setSizeColumn(Integer sizeColumn) {
		SizeColumn = sizeColumn;
	}

	public String getTextColumn() {
		return textColumn;
	}

	public void setTextColumn(String textColumn) {
		this.textColumn = textColumn;
	}
	
	

}
