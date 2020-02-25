package com.example.blackcoffer;

public class Folder {
    private String FolderName;
    private String FolderDisc;

    public Folder(String folderName, String folderDisc) {
        FolderName = folderName;
        FolderDisc = folderDisc;
    }

    public String getFolderName() {
        return FolderName;
    }

    public String getFolderDisc() {
        return FolderDisc;
    }
}
