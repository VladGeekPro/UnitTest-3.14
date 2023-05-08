import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class QueueData {
    public static void main(String[] args) {
        Deque<Currency> queue = new LinkedList<>();

        try (BufferedReader br = new BufferedReader( new FileReader("CurrencyData.csv"))){
            String line;
            while( (line = br.readLine()) != null ){
                 String[] linecur = line.split(",") ;
                 String cname1 = linecur[0];
                 String cname2 = linecur[1];
                 String data = linecur[2];
                 Double value = Double.parseDouble(linecur[3]);
                 Integer number = Integer.parseInt(linecur[4]);
                 queue.add(new Currency(cname1, cname2, data, value, number));
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        // Cтруктур данных очередь //
        //обход и выход
        for(Currency currency: queue){
           currency.displaycurrency();
           System.out.println();
        }

        //удаление
        Currency head = queue.poll(); 
        System.out.println("Removing the element at the top of deque: ");
        head.displaycurrency();        
        System.out.println();

        //запрос
        Currency headpr = queue.peek(); 
        System.out.println("Request the element at the top of deque: ");
        headpr.displaycurrency();
        System.out.println();

        //вставлять
        int size = queue.size();
        if (size >= 49 ){
            Scanner input = new Scanner(System.in);

        System.out.println("Enter name for the fisrt currency: ");
        String cname1 = input.nextLine();

        System.out.println("Enter name for the second currency: ");
        String cname2 = input.nextLine();

        System.out.println("Enter  data: ");
        String data = input.nextLine();

        System.out.println("Enter value : ");
        Double values = input.nextDouble();

        System.out.println("Enter number: ");
        Integer number = input.nextInt();

        queue.offer(new Currency(cname1,cname2,data,values,number));
        
        input.close();
        System.out.println();
        }

        Currency last = queue.peekLast();
        System.out.println("Element at the end of deque: ");
        last.displaycurrency();
        System.out.println();

        /* Cтруктур данных очередь 
                    END */         
}
    
    
}
