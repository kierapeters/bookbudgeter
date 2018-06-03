package krpeters.com.bookbudgeter;

public class PagesSingleton {

    private int totalPages;
    private double totalBalance;
    private double AMOUNT_PER_PAGE;
    private static final PagesSingleton ourInstance = new PagesSingleton();

    static PagesSingleton getInstance() {
        return ourInstance;
    }

    PagesSingleton() {
        totalPages = 0;
        totalBalance = 0;
        AMOUNT_PER_PAGE = 0.01;

    }
    public void addPages(int pages) {
        totalPages += pages;
        totalBalance += (pages * AMOUNT_PER_PAGE);
    }

    public void removePages(int pages) {
        totalPages -= pages;
        totalBalance -= (pages * AMOUNT_PER_PAGE);
    }

    public int getTotalPages() {
        return totalPages;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void buyBook(double price) {
        totalBalance -= price;
    }

    public double getAmountPerPage() {
        return AMOUNT_PER_PAGE;
    }

    public void setAmountPerPage(Double amount) {
        AMOUNT_PER_PAGE = amount;
        totalBalance = (totalPages * AMOUNT_PER_PAGE);
    }

}
