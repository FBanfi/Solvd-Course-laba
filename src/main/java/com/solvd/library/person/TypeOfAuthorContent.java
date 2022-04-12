package com.solvd.library.person;

public enum TypeOfAuthorContent {
    ADULT {
        public int getMinimunAge(){
            return 18;
        }
    },
    CHILD {
        public int getMinimunAge(){
            return 14;
        }
    }
}
