package formation.gestionFoot.model;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


public enum Pays {
	
	Espagne("Espagne"), 
	Portugal("Portugal"), 
	France("France"), 
	Allemagne("Allemagne"), 
	Grece("Grèce"), 
	PaysBas("Pays_Bas"), 
	Belgique("Belgique"), 
	Finlande("Finlande"), 
	Norvege("Norvège");
	
	
	private String pays;
	
	Pays() {}
	
	Pays(String pays) {
		this.pays = pays;
	}
	
	/*@JsonValue
    public String getPays(){
    	return this.pays;
    }

	@JsonCreator
    public static Pays fromText(String pays){
        for(Pays r : Pays.values()){
            if(r.getPays().equals(pays)){
                return r;
            }
        }
        throw new IllegalArgumentException();
    }*/

}
