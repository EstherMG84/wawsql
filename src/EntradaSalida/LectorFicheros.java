
package EntradaSalida;

import Componentes.Personas.General;
import DataBase.MySQLConnection;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esther Manresa
 */
public class LectorFicheros {
    
    private static final MySQLConnection mysql = MySQLConnection.getInstance();

    public static void leerFichero(String filePath) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while(line != null){
                String[] splitLine = line.split(",");
                
                General general = new General();
                general.setNombre(splitLine[0]);
                general.setAtaque(Integer.parseInt(splitLine[1].trim()));
                general.setDefensa(Integer.parseInt(splitLine[2].trim()));
                general.setSalud(Integer.parseInt(splitLine[3].trim()));
                
                System.out.println(general.toString());
                
                mysql.saveGeneral(general);
                
                line = reader.readLine();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LectorFicheros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
