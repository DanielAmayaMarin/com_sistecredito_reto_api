package com.sistecredito.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberModel {
    private String nombre;
    private String genero;
    private int id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "{"+
                "\"name\": " + '\"'+ nombre + '\"' +
                ",\"gender\": " + '\"'+ genero + '\"' +
                "}";

    }

    public static List<MemberModel> setData(DataTable dataTable) {
        List<MemberModel> dates = new ArrayList<>();
        List<java.util.Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, MemberModel.class));
        }
        return dates;
    }
}
