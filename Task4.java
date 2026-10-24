import java.util.HashMap;
class Phone {
    String code;
    String model;
    double price;
    Phone(String code, String model, double price) {
        this.code = code;
        this.model = model;
        this.price = price;
    }
    @Override
    public String toString() {
        return code + " - " + model + " - Rs " + price;
    }
}
public class Task4 {
    static HashMap<String, Phone> phones = new HashMap<>();
    public static void addPhone(Phone phone) {
        phones.put(phone.code, phone);
    }
    public static Phone findPhone(String code) {
        return phones.get(code);
    }
    public static boolean updatePrice(String code, double newPrice) {
        Phone phone = phones.get(code);
        if (phone == null) {
            return false;
        }
        phone.price = newPrice;
        return true;
    }
    public static boolean deletePhone(String code) {
        if (phones.containsKey(code)) {
            phones.remove(code);
            return true;
        }
        return false;
    }
    public static void displayBelow50000() {
        System.out.println("\nPhones below Rs 50,000:");
        for (Phone phone : phones.values()) {
            if (phone.price < 50000) {
                System.out.println(phone);
            }
        }
    }
    public static void main(String[] args) {
        addPhone(new Phone("P101", "Infinix Hot 40", 38000));
        addPhone(new Phone("P102", "Samsung A15", 45000));
        addPhone(new Phone("P103", "iPhone 13", 120000));
        addPhone(new Phone("P104", "Redmi Note 13", 48000));
        System.out.println("Finding P101:");
        Phone phone = findPhone("P101");
        if (phone != null) {
            System.out.println(phone);
        } else {
            System.out.println("Phone not found.");
        }
        System.out.println("\nFinding P999:");
        phone = findPhone("P999");
        if (phone != null) {
            System.out.println(phone);
        } else {
            System.out.println("Phone not found.");
        }
        System.out.println("\nUpdating P102 price:");
        if (updatePrice("P102", 42000)) {
            System.out.println("Price updated successfully.");
            System.out.println(findPhone("P102"));
        } else {
            System.out.println("Phone not found.");
        }
        System.out.println("\nDeleting P104:");

        if (deletePhone("P104")) {
            System.out.println("Phone deleted successfully.");
        } else {
            System.out.println("Phone not found.");
        }
        displayBelow50000();
    }
}