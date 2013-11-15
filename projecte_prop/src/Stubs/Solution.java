/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Stubs;

import java.util.Date;
/**
 *
 * @author josep
 */
public class Solution {
    int id;
    String nom;  //El nom de la solució serà el nom de la ciutat-sol_i
    Tour tour;
    Date fecha;
    int cost;

    public Solution (){
        fecha = new Date ();
        id = 0;
        nom = "Sense_Nom";
        tour = new Tour();
        cost = -1;
    }
    public Solution(String nom){
        fecha = new Date ();
        id = 0;
        this.nom = nom;
        tour = new Tour();
        cost = -1;
    }
    public Solution(String nom,int cost){
        fecha = new Date ();
        id = 0;
        this.nom = nom;
        this.cost = cost;
        tour = new Tour();
        
    }
    
    public Tour getTour(){
        return tour;
    }
    
    public void addTour(Tour tour){}
    
    public int getid(){
        return id;
    }
    
    public String getNom(){
        return nom;
    }
    
    public int getCostSolution(){
       return cost;
    }
    
    public String getData(){
       return (fecha.toString());   
    }
}
