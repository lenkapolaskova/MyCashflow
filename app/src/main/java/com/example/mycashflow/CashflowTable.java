package com.example.mycashflow;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Entity defines a table for entries
@Entity(tableName = "cashflow")
public class CashflowTable {
    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    @ColumnInfo(name = "record")
    private int record = 0;
    @ColumnInfo(name = "cashflowplus")
    private int cashflowplus = 0;
    @ColumnInfo(name = "cashflowminus")
    private int cashflowminus = 0;

    public CashflowTable(int record, int cashflowplus, int cashflowminus) {
        this.record = record;
        this.cashflowplus = cashflowplus;
        this.cashflowminus = cashflowminus;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecord() {
        int record;
        record = this.record;
        return record;
    }

    public void setRecord(int id) {
        this.record = record;
    }

    public int getCashflowplus() {
        return this.cashflowplus;
    }

    public void setCashflowplus(int casflowplus) {
        this.cashflowplus = casflowplus;
    }

    public int getCashflowminus() {
        return cashflowminus;
    }

    public void setCashflowminus(int cashflowminus) {
        this.cashflowminus = cashflowminus;
    }
}
