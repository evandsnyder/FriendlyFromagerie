package com.friendlygeek.friendly_client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {
    private String id;
    private Boolean publish;
    private String recipeName;
    private String description;
    private String cheeseType;
    private String hardness;
    private String milkType;
    private String ingredients;
    private String warmTheMilk;
    private String cultureAndCoagulate;
    private String ladleTheCurd;
    private String drainTheCurd;
    private String targetFlavorAndTexture;
    private String storage;
    private String notes;
    private User createdBy;
    private String href;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getHref() {
        return href;
    }
    @JsonProperty("_links")
    public void setHref(Map<String, Map<String,String>> hrefs) {
        href = hrefs.get("self").get("href");
    }
}
