package com.example.mycashflow;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CashflowDao {
    @Query("select * from cashflow")
    List<CashflowTable> getAllEntries(); // getAllTaskskList

    @Query("Delete from cashflow")
    void clearDatabase(); // truncatethelist

    @Insert
    void insertIntoTable(CashflowTable add);

    @Query("DELETE FROM cashflow WHERE record = :record")
    int deleteRecord(int record);

    @Query("SELECT * FROM cashflow ORDER BY ID DESC LIMIT 1")
    CashflowTable getLastEntry();

}
