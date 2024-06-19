

/**
 *
 * @author Ykimmel
 */
public class Products {
private String title;
private double price;
private int stock;
private String genre;
    
    
    
 public Products(String genre, String title, double price, int stock) {
        this.genre = genre;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    // Getter method for price
    public double getprice() {
        return price;
    }

    // Getter method for stock
    public int getStock() {
        return stock;
    }

    // Getter method for genre
    public String getGenre() {
        return genre;
    }

    // Getter method for title
    public String getTitle() {
        return title;
    }

    // Method to remove stock
    public void removestock(int num) {
        if (stock >= num) {
            stock -= num;
        } else {
            System.out.println("No more stock available for " + title);
        }
    }

    // Method to add stock
    public void addstock(int num) {
        stock += num;
    }
    
}

