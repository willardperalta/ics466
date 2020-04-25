package com.example.onecheck;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "check_table")

public class Check {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    private String price;
    public Check(String name, String price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
