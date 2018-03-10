package gestionpersonne

class Formation {
    String nomformation
    static belongsTo  = Personne
    static hasMany = [personnes:Personne]
    public String toString(){
        return id
    }
}
