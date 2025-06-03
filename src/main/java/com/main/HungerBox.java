package com.main;

import com.dao.CreateTable;
import com.dao.DeleteTables;

public class HungerBox {
        public static void main(String args[]) {
                new DeleteTables().deleteTables();
                new CreateTable().createTable();
        }
}