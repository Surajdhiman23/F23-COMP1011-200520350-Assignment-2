package com.example.advancejavaassignment2;

import org.json.JSONObject;

public class Animal {
    private JSONObject taxonomy;
    private String name;
    private String scientificName;
    private JSONObject characteristics;

    public Animal(JSONObject jsonObject) {
        this.taxonomy = jsonObject.getJSONObject("taxonomy");
        this.name = jsonObject.optString("name","----");
        this.characteristics=jsonObject.getJSONObject("characteristics");
        if (this.taxonomy.has("scientific_name")) {
            this.scientificName = this.taxonomy.getString("scientific_name");
        } else {
            this.scientificName = "---";
        }
    }
    public String getFamily() {

        if (this.taxonomy.has("family")) {
            return this.taxonomy.getString("family");
        } else {
            return "";
        }
    }
    public String getPrey() {
        return this.characteristics.optString("prey", "----"); // Retrieves the prey attribute or returns an empty string if not present
    }

    public String getNameOfYoung() {
        return this.characteristics.optString("name_of_young", "----"); // Retrieves the name_of_young attribute or returns an empty string if not present
    }

    public String getBiggestThreat() {
        return this.characteristics.optString("biggest_threat", "----"); // Retrieves the biggest_threat attribute or returns an empty string if not present
    }

    public String getNoOfSpecies() {
        return this.characteristics.optString("number_of_species", "----"); // Retrieves the number_of_species attribute or returns an empty string if not present
    }

    public String getColor() {
        return this.characteristics.optString("color", "----"); // Retrieves the color attribute or returns an empty string if not present
    }

    public String getTopSpeed() {
        return this.characteristics.optString("top_speed", "----"); // Retrieves the top_speed attribute or returns an empty string if not present
    }
    public String getName() {
        return name;
    }

    public String getScientificName() {
        return scientificName;
    }
}

