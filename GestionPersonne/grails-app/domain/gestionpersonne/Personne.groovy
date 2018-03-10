package gestionpersonne

class Personne {
     String nom
     String adresse
     String ville
     String pays
     String telephone
    static hasMany = [formations:Formation]
    public String toString(){
        return id ;
    }
}
