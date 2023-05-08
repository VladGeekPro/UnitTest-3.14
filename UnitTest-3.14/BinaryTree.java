import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BinaryTree {
    public static void main(String[] args) {

        CurrencyBinaryTree tree = new CurrencyBinaryTree();
        try (BufferedReader br = new BufferedReader( new FileReader("CurrencyData.csv"))){
            String line;
            while( (line = br.readLine()) != null ){
                 String[] linecur = line.split(",") ;
                 String cname1 = linecur[0];
                 String cname2 = linecur[1];
                 String data = linecur[2];
                 Double value = Double.parseDouble(linecur[3]);
                 Integer number = Integer.parseInt(linecur[4]);
                 tree.insert(new Currency(cname1, cname2, data, value, number));
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }        

         // бинарное дерево //        
        // обход в правильном порядке
        System.out.println("inOrderTraversal");
        tree.inOrderTraversal(tree.getRoot());
        System.out.print("inOrderTraversal END");
        System.out.println();

        // обход в обратном порядке
        System.out.println("reverseInOrderTraversal");
        tree.reverseInOrderTraversal(tree.getRoot());
        System.out.print("reverseInOrderTraversal END");
        System.out.println();

        // центрированный/симметричный байпас
        System.out.println("symmetricOrderTraversal");
        tree.symmetricOrderTraversal(tree.getRoot());
        System.out.print("symmetricOrderTraversal END");
        System.out.println();

        // элемент поиска
        System.out.println();
        System.out.println("Element with number 981 found:");
        Currency foundcurr = tree.find(981);
        foundcurr.displaycurrency();
        System.out.println();
      
        
        // вставить элемент
        Scanner input = new Scanner(System.in);
        System.out.println();

        System.out.println("Enter name for the fisrt currency: ");
        String cname1tree = input.nextLine();

        System.out.println("Enter name for the second currency: ");
        String cname2tree = input.nextLine();

        System.out.println("Enter  data: ");
        String datatree = input.nextLine();

        System.out.println("Enter value : ");
        Double valuestree = input.nextDouble();

        System.out.println("Enter number: ");
        Integer numbertree = input.nextInt();

        tree.insert(new Currency(cname1tree,cname2tree,datatree,valuestree,numbertree));
        System.out.println();
        input.close();

        // удаление элемента
        tree.delete(985);

        /* бинарное дерево
                END*/ 
    }
}
