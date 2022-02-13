package com.friendlygeek.friendlyfromagerie.domain.models;

import javax.persistence.*;

@Entity
@Table(name = "recipes")
public class CheeseRecipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String recipeName;
	
	@Column(length = 1024)
	private String description;
	private String cheeseType;
	private String hardness;
	private String milkType;

	@Column(length = 1024)
	private String ingredients;

	@Column(length = 1024)
	private String warmTheMilk;

	@Column(length = 1024)
	private String cultureAndCoagulate;

	@Column(length = 1024)
	private String ladleTheCurd;

	@Column(length = 1024)
	private String drainTheCurd;

	@Column(length = 1024)
	private String targetFlavorAndTexture;

	@Column(length = 1024)
	private String storage;

	@Column(length = 1024)
	private String notes;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "createdBy", referencedColumnName = "user_id")
	private User createdBy;

	public Integer getId() {
		return id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public String getDescription() {
		return description;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCheeseType() {
		return cheeseType;
	}

	public void setCheeseType(String cheeseType) {
		this.cheeseType = cheeseType;
	}

	public String getHardness() {
		return hardness;
	}

	public void setHardness(String hardness) {
		this.hardness = hardness;
	}

	public String getMilkType() {
		return milkType;
	}

	public void setMilkType(String milkType) {
		this.milkType = milkType;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getWarmTheMilk() {
		return warmTheMilk;
	}

	public void setWarmTheMilk(String warmTheMilk) {
		this.warmTheMilk = warmTheMilk;
	}

	public String getCultureAndCoagulate() {
		return cultureAndCoagulate;
	}

	public void setCultureAndCoagulate(String cultureAndCoagulate) {
		this.cultureAndCoagulate = cultureAndCoagulate;
	}

	public String getLadleTheCurd() {
		return ladleTheCurd;
	}

	public void setLadleTheCurd(String ladleTheCurd) {
		this.ladleTheCurd = ladleTheCurd;
	}

	public String getDrainTheCurd() {
		return drainTheCurd;
	}

	public void setDrainTheCurd(String drainTheCurd) {
		this.drainTheCurd = drainTheCurd;
	}

	public String getTargetFlavorAndTexture() {
		return targetFlavorAndTexture;
	}

	public void setTargetFlavorAndTexture(String targetFlavorAndTexture) {
		this.targetFlavorAndTexture = targetFlavorAndTexture;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
}
