public class Produit {
    private String code;
    private String nom;
    private String description;
    private String categorie;
    private float prix;

    public void setCode(String code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getCategorie() {
        return categorie;
    }

    public float getPrix() {
        return prix;
    }

    public Produit(String code, String nom, String description, String categorie, float prix) {
        this.code = code;
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return  "CODE='" + code + '\n' +
                ", NOM='" + nom + '\n' +
                ", DESCRIPTION='" + description + '\n' +
                ", CATEGORIE='" + categorie + '\n' +
                ", PRIX=" + prix;
    }
}
