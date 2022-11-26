package delivery;

import model.Megazine;
import model.Novel;
import service.InventoryService;
import service.InventoryServiceImpl;
import utility.FormatBook;
import utility.PublishPeriode;

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
            System.out.print("SILAHKAN PILIH MENU");
            try {

                Scanner scanner = new Scanner(System.in);
                Integer option = scanner.nextInt();

                if (option == 1) {
                    System.out.println("Pilih menu : ");
                    System.out.println("1. Masukan Novel");
                    System.out.println("2. Masukan Megazine");
                    System.out.print("SILAHKAN PILIH MENU");
                    Integer option2 = scanner.nextInt();

                    if (option2 == 1) {
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("MASUKAN DATA NOVEL");

                        System.out.println("Masukan title : ");
                        String title = scanner2.nextLine();

                            System.out.println("Masukan publication : ");
                            Integer publication = scanner2.nextInt();
                            scanner2.nextLine();

                            System.out.println("Masukan publisher : ");
                            String publisher = scanner2.nextLine();

                            System.out.println("Masukan writer : ");
                            String writer = scanner2.nextLine();

                            inventoryService.addNovel(new Novel(FormatBook.novelFormat(counter, publication), title, publication, publisher, writer));

                    } else if (option2 == 2) {
                        try{
                            System.out.println("MASUKAN DATA MEGAZINE");

                            Scanner scanner2 = new Scanner(System.in);

                            System.out.println("Masukan title : ");
                            String title = scanner2.nextLine();

                            System.out.println("Masukan publication : ");
                            Integer publication = scanner2.nextInt();
                            scanner.nextLine();

                            System.out.println("Publish periode list");
                            PublishPeriode[] publishPeriodes = PublishPeriode.values();

                            Integer i = 0;
                            for (PublishPeriode publish :
                                    publishPeriodes) {
                                i++;
                                System.out.println(i+". "+publish.name());
                            }

                            System.out.println("Masukan publisherPeriode : ");

                            Integer publisherPeriodeEnum = scanner.nextInt();
                            if(publisherPeriodeEnum != 1 || publisherPeriodeEnum != 2){
                                System.out.println("periode yang dimasukan tidak tersedia");
                                continue;
                            }
                            scanner.nextLine();
                            String publisherPeriode = publishPeriodes[publisherPeriodeEnum].name();
                            System.out.println(publishPeriodes[publisherPeriodeEnum-1].name());

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
