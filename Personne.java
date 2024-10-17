import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nom;
    private String prénom;
    private Date date_naissance;

    public Personne(String nom, String prénom, Date date_naissance) {
        this.nom = nom;
        this.prénom = prénom;
        this.date_naissance = date_naissance;
    }

    public int calcul_age(Date currentDate) {
        Calendar birth = Calendar.getInstance();
        birth.setTime(this.date_naissance);
        Calendar today = Calendar.getInstance();
        today.setTime(currentDate);

        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    // Getters and setters for the attributes if needed
}
