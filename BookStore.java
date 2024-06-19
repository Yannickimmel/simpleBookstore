/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;

/**
 * This class represents a BookStore management system.
 * Users can check inventory, manage members, make purchases, and more.
 */
public class BookStore {

    public static void main(String[] args) {

        double pricemembership = 10.99;

        // Create products that you can buy 
        Products book1 = new Products("Book", "textbook", 29.99, 10);
        Products book2 = new Products("Book", "dictionary", 39.99, 4);
        Products book3 = new Products("Book", "hungergames", 19.99, 1);
        Products book4 = new Products("Book", "alchemist", 15.99, 5);
        Products Dvd1 = new Products("Dvd", "pixels", 10.99, 2);
        Products Dvd2 = new Products("Dvd", "car", 12.99, 3);
        Products Dvd3 = new Products("Dvd", "strays", 11.99, 15);
        Products Dvd4 = new Products("Dvd", "moana", 9.99, 15);
        Products Cd1 = new Products("CD", "thriller", 5.99, 5);
        Products Cd2 = new Products("CD", "Timber", 4.99, 10);
        Products Cd3 = new Products("CD", "8teen", 3.99, 15);
        Products Cd4 = new Products("CD", "dynamite", 6.99, 4);
        // ... (Define other products here)

        // Creates inventory of Bookstore
        BackofStore inventory = new BackofStore();
        inventory.addproduct(book1);
        inventory.addproduct(book2);
        inventory.addproduct(book3);
        inventory.addproduct(book4);
        inventory.addproduct(Dvd1);
        inventory.addproduct(Dvd2);
        inventory.addproduct(Dvd3);
        inventory.addproduct(Dvd4);
        inventory.addproduct(Cd1);
        inventory.addproduct(Cd2);
        inventory.addproduct(Cd3);
        inventory.addproduct(Cd4);
        // ... (Add other products to the inventory)

        Memberlist members = new Memberlist();
        Scanner scanner = new Scanner(System.in);

        // User main menu
        boolean quit = false;
        do {
            System.out.println();
            System.out.println("Main Menu");
            System.out.println("1. Check Inventory");
            System.out.println("2. Check Members");
            System.out.println("3. Pay Monthly Premium Fee");
            System.out.println("4. Join Membership");
            System.out.println("5. Purchase Product");
            System.out.println("6. Remove Product");
            System.out.println("7. Upgrade/Remove Membership");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    // Prints out Inventory of Store
                    System.out.println("Inventory of Store");
                    inventory.printstore();
                    break;

                case 2:
                    // Prints out Members of Store
                    System.out.println("Members of Store");
                    members.printmembers();
                    break;

                case 3:
                    // Allows member to pay for membership
                    if (members.isEmpty()) {
                        System.out.println("No members found. Add members first to shop.");
                        break;
                    } else {
                        Scanner memberpaid = new Scanner(System.in);
                        System.out.println("Enter name");
                        String findmember = memberpaid.nextLine().toLowerCase();
                        Members premiumMember = members.findM(findmember);

                        if (premiumMember == null) {
                            System.out.println("Member not found");
                            break;
                        }

                        System.out.println("Has the membership fee been paid? (yes/no)");
                        String paidMembership = memberpaid.nextLine().toLowerCase();

                        if (paidMembership.equals("yes")) {
                            if (premiumMember.getSpent() >= pricemembership) {
                                premiumMember.removemoney(pricemembership);
                                System.out.println("Membership fee deducted: $" + pricemembership);
                                premiumMember.setmembershipdue(false);
                            } else {
                                System.out.println("Insufficient funds to pay the membership fee.");
                            }
                        }
                        System.out.println(premiumMember.toString());
                        break;
                    }

                case 4:
                    // Creates new membership
                    Members newmember = new Members();
                    Scanner nameScanner = new Scanner(System.in);
                    System.out.println("Enter name");
                    String memberName = nameScanner.nextLine().toLowerCase();
                    System.out.println("Enter an Email or Phone number");
                    String memberDetail = nameScanner.nextLine();
                    System.out.println("Would you like to upgrade to premium; $10.99 a month");
                    String input = nameScanner.nextLine().toLowerCase();

                    if (input.equals("yes")) {
                        newmember.setMembership(true);
                        newmember.addmoney(pricemembership);
                    } else if (input.equals("no")) {
                        newmember.setMembership(false);
                        newmember.setmembershipdue(false);
                    }

                    newmember.setName(memberName);
                    newmember.setmemberD(memberDetail);
                    System.out.println(newmember.toString());
                    members.addMember(newmember);
                    members.printmembers();
                    break;

                case 5:
                    // Members can shop here
                    if (members.isEmpty()) {
                        System.out.println("No members found. Add members first to shop.");
                        break;
                    } else {
                        Scanner name = new Scanner(System.in);
                        System.out.println("Enter name");
                        String findmember = name.nextLine().toLowerCase();
                        Members memberpurchase = members.findM(findmember);

                        if (memberpurchase == null) {
                            System.out.println("Member not found");
                            break;
                        }

                        System.out.println("Enter Title name");
                        String findinventory = name.nextLine().toLowerCase();
                        Products selectedProduct = inventory.findP(findinventory);

                        if (selectedProduct == null) {
                            System.out.println("Item not found");
                            break;
                        }

                        if (selectedProduct.getStock() > 0) {
                            double totalPrice = selectedProduct.getprice();

                            if (memberpurchase.getP()) {
                                double discount = totalPrice * 0.10;
                                totalPrice -= discount;
                                System.out.println("10% discount applied for Premium Member.");
                            }

                            selectedProduct.removestock(1);
                            memberpurchase.addmoney(totalPrice);
                            System.out.println("Purchase complete. Total cost: $" + totalPrice);
                        } else {
                            System.out.println("Product out of stock.");
                        }
               
                    System.out.println(memberpurchase.toString());
                    break;
                    }
                    
                case 6:
                    // Removes items from members' shopping cart
                    if (members.isEmpty()) {
                        System.out.println("No members found. Add members first.");
                        break;
                    } else {
                        Scanner name = new Scanner(System.in);
                        System.out.println("Enter name");
                        String findmember = name.nextLine().toLowerCase();
                        Members membercheck = members.findM(findmember);

                        if (membercheck == null) {
                            System.out.println("Member not found");
                            break;
                        }

                        System.out.println("Enter Title name to remove from cart");
                        String findinventory = name.nextLine().toLowerCase();
                        Products selectedProduct = inventory.findP(findinventory);

                        if (selectedProduct == null) {
                            System.out.println("Item not found");
                            break;
                        }

                        if (selectedProduct.getStock() >= 0) {
                            selectedProduct.addstock(1);
                            double totalPrice = selectedProduct.getprice();
                            membercheck.removemoney(totalPrice);
                            System.out.println("Item removed from cart. Total cost reduced by: $" + totalPrice);
                        }

                        System.out.println(membercheck.toString());
                        break;
                    }

                case 7:
                    // Allows members to upgrade or downgrade
                    if (members.isEmpty()) {
                        System.out.println("No members found. Add members first.");
                        break;
                    } else {
                        Scanner name = new Scanner(System.in);
                        System.out.println("Enter name");
                        String findmember = name.nextLine().toLowerCase();
                        Members upgrademember = members.findM(findmember);

                        if (upgrademember == null) {
                            System.out.println("Member not found");
                            break;
                        }

                        if (upgrademember.getP() == true && upgrademember.getDue() == true) {
                            System.out.println("Sorry you didn't like Premium, we have deducted $10.99");
                            upgrademember.removemoney(pricemembership);
                            upgrademember.setMembership(false);
                            upgrademember.setmembershipdue(false);
                            System.out.println(upgrademember.toString());
                            System.out.println("Membership Canceled, You have been demoted to Regular");
                            System.out.print("Goodbye!");
                            break;
                        }

                        if (upgrademember.getP() == true && upgrademember.getDue() == false) {
                            System.out.println("Sorry you didn't like Premium");
                            upgrademember.setMembership(false);
                            System.out.println(upgrademember.toString());
                            System.out.println("Membership Canceled, You have been demoted to Regular");
                            System.out.print("Goodbye!");
                            break;
                        }

                        if (upgrademember.getP() == false) {
                            System.out.println("Would you like to become a Premium Member? Cost is $10.99");
                            String num = name.nextLine().toLowerCase();
                            if (num.equals("yes")) {
                                upgrademember.setMembership(true);
                                upgrademember.addmoney(pricemembership);
                                upgrademember.setmembershipdue(true);
                                System.out.println(upgrademember.toString());
                                System.out.println("Membership Upgraded, You have been promoted to Premium");
                                System.out.println("Goodbye!");
                                break;
                            }

                            if (num.equals("no")) {
                                System.out.println("Goodbye!");
                                break;
                            }
                        }
                    }

                case 8:
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (!quit);

        scanner.close();
    }
}


