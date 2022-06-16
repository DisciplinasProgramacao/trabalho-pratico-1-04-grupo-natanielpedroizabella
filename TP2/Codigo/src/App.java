import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import model.Rolo;
import services.BackTracking;
import services.ReadFile;


public class App {


    public static void main(String[] args) throws Exception {
        List<Rolo> rolos = ReadFile.listarRolos("TP2/Codigo/src/files/LaminacaoTeste1.txt");
        int espInicial= rolos.stream().mapToInt(x->x.getEspessuraEntrada()).max().getAsInt();

        BackTracking bt = new BackTracking();
        
        bt.backTracking(rolos, espInicial, new Stack<Rolo>(), 0);
        System.out.println("Custo: "+bt.getMenorCusto());
        System.out.println("Rolos: \n"+bt.getRolosSolucao());
        

    }

}
