/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;

/**
 *
 * @author Ykimmel
 */
public class BackofStore {
    private ArrayList<Products> products;
    
   
    
    public BackofStore(){
     products=new ArrayList<>();
    }
    
    public void addproduct(Products item){// adds a product to list
        products.add(item);
    }
    
    public Products findP(String name){//finds the product
        for(Products product : products){
            if(product.getTitle().equals(name)){
                return product;
        }
        }
        return null;
      
    }
    
    public void  printstore(){
        for(Products product : products){
         System.out.println( "Genre:" + product.getGenre() + "    Title:" + product.getTitle() + "   Price:$" +  product.getprice() + "   Stock:" + product.getStock() );
    }
    }
    
    
    
    
}
