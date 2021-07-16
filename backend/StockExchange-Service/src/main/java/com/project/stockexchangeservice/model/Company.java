package com.project.stockexchangeservice.model;

import org.springframework.data.annotation.Id;

public class Company{
	@Id
	int id;
	String name;
	int turnover;
	String ceo;
	String[] boardOfDirectors;
	int sector;
	String about;
	public Company() {
	}
	public Company(int id, String name, int turnover, String ceo, String[] boardOfDirectors, int sector, String about) {
		this.id = id;
		this.name = name;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.sector = sector;
		this.about = about;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTurnover() {
		return turnover;
	}
	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String[] getBoardOfDirectors() {
		return boardOfDirectors;
	}
	public void setBoardOfDirectors(String[] boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}
	public int getSector() {
		return sector;
	}
	public void setSector(int sector) {
		this.sector = sector;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public int getId() {
		return id;
	}
}