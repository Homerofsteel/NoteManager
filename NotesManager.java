import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class NotesManager {
    private HashMap<String, Double> notes;

    public NotesManager() {
        notes = new HashMap<>();
    }

    public void addStudent(String name, double note) {
        notes.put(name, note);
    }

    public Double getNote(String name) {
        return notes.get(name);
    }
    
    public HashMap<String, Double> getAllNotes() {
        return new HashMap<>(notes);
    }

    public HashMap<String, Double> getSucessfulStudents() {
        HashMap<String, Double> successful = new HashMap<>();
        for (String name : notes.keySet()) {
            Double note = notes.get(name);
            if (note != null && note >= 10) {
                successful.put(name, note);
            }
        }
        return successful;
    }

    public void serializeNotes() {

    ObjectOutputStream oos = null;
    try {
      final FileOutputStream fichier = new FileOutputStream("notes.ser");
      oos = new ObjectOutputStream(fichier);
    } catch (final java.io.IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (oos != null) {
          oos.flush();
          oos.close();
        }
      } catch (final IOException ex) {
        ex.printStackTrace();
      }
    }
}

public void deserializeNotes() {
  ///not implemented yet///
  }

}
