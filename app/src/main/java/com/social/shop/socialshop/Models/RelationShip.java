package com.social.shop.socialshop.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Creado por Deimer, fecha: 17/04/2016.
 */
@DatabaseTable(tableName = "relations")
public class RelationShip {

    @Expose
    @DatabaseField(generatedId = true)
    private int id;

    @SerializedName("id")
    @DatabaseField(canBeNull = true)
    private int relation_id;
    @DatabaseField(canBeNull = true)
    private int number_of_friends;

    public RelationShip(){}

    public RelationShip(int relation_id, int number_of_friends) {
        this.relation_id = relation_id;
        this.number_of_friends = number_of_friends;
    }

//region Getters del modelo
    public int getId() {
        return id;
    }
    public int getRelation_id() {
        return relation_id;
    }
    public int getNumber_of_friends() {
        return number_of_friends;
    }
//endregion

//region Setters del modelo
    public void setRelation_id(int relation_id) {
        this.relation_id = relation_id;
    }
    public void setNumber_of_friends(int number_of_friends) {
        this.number_of_friends = number_of_friends;
    }
//endregion

//region Metodo de impresion en consola
    @Override
    public String toString() {
        return "RelationShip{" +
            "id=" + id +
            ", relation_id=" + relation_id +
            ", number_of_friends=" + number_of_friends +
        '}';
    }
//endregion

}
