import service.CachingProxyService;
import service.DataService;
import service.RegularDataService;

/**
 * Created by Anton Mikhaylov on 09.01.2018.
 */
public class Main {
    public static void main(String[] args) {

        DataService cachingService = new CachingProxyService(new RegularDataService());

        System.out.println("\n---------- First call - no caching yet -------------\n");
        System.out.println("All data: " + cachingService.getAll());

        System.out.println("\n---------- After caching -------------\n");
        System.out.println("Data by id[0]: " + cachingService.getById(0));
    }
}
