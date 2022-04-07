/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparacion;

import Archive.readArchives;
import java.util.ArrayList;

/**
 *
 * @author alexis
 */
public class helper extends Thread {

    private ArrayList<String> list;
    private readArchives usar;

    public helper(ArrayList<String> list, readArchives usar) {
        this.list = list;
        this.usar = usar;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public readArchives getUsar() {
        return usar;
    }

    public void setUsar(readArchives usar) {
        this.usar = usar;
    }

    @Override
    public void run() {
        list.add(usar.upLoadTextFile());
    }

}
