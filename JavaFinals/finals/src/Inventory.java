import java.util.Scanner;

//Inventory class
public class Inventory {

    //product array
    static Product arr[] = new Product[30];
    static Scanner sc = new Scanner(System.in);

    //main method
    public static void main(String[] args) {

        //add 10 products initially
        arr[0] = new Product("p1", "abc", 25, 5, Type.tuna);
        arr[1] = new Product("p2", "def", 30, 0, Type.bread);
        arr[2] = new Product("p3", "abc", 40, 0, Type.eggs);
        arr[3] = new Product("p4", "abc", 25, 5, Type.salt);
        arr[4] = new Product("p5", "def", 30, 2, Type.bread);
        arr[5] = new Product("p6", "ghi", 60, 0, Type.bread);
        arr[6] = new Product("p7", "abc", 25, 5, Type.eggs);
        arr[7] = new Product("p8", "def", 70, 3, Type.bread);
        arr[8] = new Product("p9", "ghi", 40, 0, Type.tuna);
        arr[9] = new Product("p10", "abc", 40, 0, Type.salt);

        //perform actions
        addProduct(arr);
        addProduct(arr);
        deleteProduct(arr);
        editProduct(arr);
        search(arr);
        search(arr);

    }


    //method to add product
    public static void addProduct(Product arr[]) {

        //variables
        String name, brand;
        double price, discountRate;
        Type type;

        //get user inputs
        System.out.print("\nEnter product name, brand, price, type: ");
        name = sc.next();
        brand = sc.next();
        price = sc.nextDouble();
        type = Type.valueOf(sc.next());
        System.out.print("Enter discount rate, press 0 for no discount: ");
        discountRate = sc.nextDouble();

        //check for duplicate
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null)
                break;
            if(arr[i].getName().equals(name)) {
                System.out.println("Duplicate name!");
                return;
            }
        }

        //add product
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                arr[i] = new Product(name, brand, price, discountRate, type);
                System.out.println("Product added successfully");
                break;
            }
        }

    }



    //method to delete product
    public static void deleteProduct(Product arr[]) {

        String name;

        //get name from user
        System.out.print("\nEnter product name to delete: ");
        name = sc.next();

        int last = 0;

        //get last index
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                last = i;
                break;
            }
        }

        //delete product
        for (int i = 0; i < last; i++) {
            if(arr[i].getName().equals(name)) {
                arr[i] = arr[last-1];
                arr[last-1] = null;

                System.out.println("Product deleted successfully!");
                break;

            }
        }


    }


    //method to edit product
    public static void editProduct(Product arr[]) {

        //variables
        String name, brand;
        double price, discountRate;
        Type type;

        //get name from user
        System.out.print("\nEnter product name to edit: ");
        name = sc.next();

        //edit product
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null)
                break;
            //if name matches,get user inputs and update
            if(arr[i].getName().equals(name)) {
                System.out.print("Enter product brand, price, type: ");
                brand = sc.next();
                price = sc.nextDouble();
                type = Type.valueOf(sc.next());
                arr[i].setBrand(brand);
                arr[i].setPrice(price);
                arr[i].setType(type);
                System.out.println("Edit successful");

            }
        }


    }


    //method to search product
    public static void search(Product arr[]) {

        //variables
        String name, brand;
        double minPrice, maxPrice;
        int choice;


        //ask user choice
        System.out.print("\nEnter 1 to search by name, 2 to search by brand, 3 to search by price: ");
        choice = sc.nextInt();


        //search based on name
        if(choice == 1) {
            //ask name from user
            System.out.print("Enter product name to search: ");
            name = sc.next();

            //print products with matching name
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == null)
                    break;
                if(arr[i].getName().equals(name)) {
                    System.out.println(arr[i]);
                }
            }
        }
        //search based on brand
        else if(choice == 2) {
            //ask user for brand
            System.out.print("Enter product brand to search: ");
            brand = sc.next();

            //print products with matching brand
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == null)
                    break;
                if(arr[i].getBrand().equals(brand)) {
                    System.out.println(arr[i]);
                }
            }
        }
        //search based on price
        else if(choice == 3) {
            //ask user for min and max
            System.out.print("Enter product min and max price to search: ");
            minPrice = sc.nextDouble();
            maxPrice = sc.nextDouble();

            //print products with matching price range
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == null)
                    break;
                if(arr[i].getPrice() >= minPrice && arr[i].getPrice() <= maxPrice) {
                    System.out.println(arr[i]);
                }
            }
        }
        //invalid choice
        else {
            System.out.println("Invalid choice!");
        }

    }


}
