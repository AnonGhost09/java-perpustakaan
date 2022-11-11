package delivery;

import model.Megazine;
import model.Novel;
import service.InventoryService;
import service.InventoryServiceImpl;
import utility.FormatBook;

import java.util.Scanner;

public class Menu {
    public static void menu(){
        InventoryService inventoryService = new InventoryServiceImpl();
        Integer counter = inventoryService.hitungSize()+1;

        while (true) {
            System.out.println("===========================");
            System.out.println("1. Add Books");
            System.out.println("2. Search Book By Title");
            System.out.println("3. Search Book By ID");
            System.out.println("4. Delete Books");
            System.out.println("5. Get All Books");
            try {

                Scanner scanner = new Scanner(System.in);
                Integer option = scanner.nextInt();

                if (option == 1) {
                    System.out.println("Pilih menu : ");
                    System.out.println("1. Masukan Novel");
                    System.out.println("2. Masukan Megazine");
                    Integer option2 = scanner.nextInt();

                    if (option2 == 1) {
                        System.out.println("MASUKAN DATA NOVEL");

                        System.out.println("Masukan title : ");
                        String title = scanner.next();

                            System.out.println("Masukan publication : ");
                            Integer publication = scanner.nextInt();

                            System.out.println("Masukan publisher : ");
                            String publisher = scanner.next();

                            System.out.println("Masukan writer : ");
                            String writer = scanner.next();

                            inventoryService.addNovel(new Novel(FormatBook.novelFormat(counter, publication), title, publication, publisher, writer));

                    } else if (option2 == 2) {
                        try{
                            System.out.println("MASUKAN DATA MEGAZINE");

                            System.out.println("Masukan title : ");
                            String title = scanner.next();

                            System.out.println("Masukan publication : ");
                            Integer publication = scanner.nextInt();

                            System.out.println("Masukan publisherPeriode : ");
                            String publisherPeriode = scanner.next().toString();

                            inventoryService.addMegazine(new Megazine(FormatBook.megazineFormat(counter, publication), title, publication, publisherPeriode));
                        }catch(Exception e){
                            System.out.println("publication harus integer");
                        }
                    }
                } else if (option == 2) {
                    try {
                        System.out.println("Masukan title book yang ingin di cari : ");
                        String search = scanner.next();

                        inventoryService.searchBookByTitle(search);
                    } catch (Exception e) {
                        System.out.println("Gak ada datanye !!!");
                    }
                } else if (option == 3) {
                    System.out.println("Masukan ID ya : ");
                    String search = scanner.next();

                    inventoryService.searchBookById(search);
                } else if (option == 4) {
                    inventoryService.deleteBook();
                } else if (option == 5) {
                    inventoryService.getAllBook();
                }
            }
            catch(Exception e){
                System.out.println("EIittss inget Inputannya ya...");
            }
        }
    }
}
