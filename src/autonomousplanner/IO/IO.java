
package autonomousplanner.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Team 254's file related methods.
 *
 * 
 */
public class IO {

    /**
     * Write a string to a file at the given path. If the file does not exist,
     * the file is created.
     *
     * @param path The location of the file to write.
     * @param string The data to write.
     * @return True if successful
     */
    public static boolean writeToFile(String path, String string) {
        try {
            File f = new File(path);

            if (!f.exists()) {
                boolean createNewFile = f.createNewFile();
            }
            FileWriter fr = new FileWriter(f.getAbsoluteFile());
            try (BufferedWriter br = new BufferedWriter(fr)) {
                br.write(string);
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Write a string to a file.
     *
     * @param f
     * @param string
     */
    public static void writeFile(File f, String string) {
        FileWriter fr = null;
        try {
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            fr = new FileWriter(f.getAbsoluteFile());
            try (BufferedWriter br = new BufferedWriter(fr)) {
                br.write(string);
            }
        } catch (IOException ex) {
            Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Create a path for a file in a folder.
     *
     * @param folder
     * @param file
     * @return The path.
     */
    public static String makeFilePath(String folder, String file) {
        File file1 = new File(folder);
        File file2 = new File(file1, file);
        return file2.getPath();
    }

}