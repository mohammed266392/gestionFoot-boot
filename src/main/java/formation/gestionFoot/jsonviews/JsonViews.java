package formation.gestionFoot.jsonviews;

public class JsonViews {
	
	/************* BASE *************/
	public static class Base {
		
	}
	
	/************* COMPTE *************/
	public static class CompteWithEquipe extends Base{
		
	}
	
	
	/************* EQUIPE *************/
	public static class EquipeWithJoueurs extends Base{
		
	}
	
	public static class EquipeWithMatchDom extends Base{
		
	}
	
	public static class EquipeWithMatchExt extends Base{
		
	}
	
	
	/************* MATCH *************/
	public static class MatchWithArbitre extends Base {
		
	}
	public static class MatchWithEquipe extends Base {
			
	}
	
	/*********** ARBITRE **************/
	
	public static class ArbitreWithMatch extends Base {
		
	}
	/*********** ENTRAINEUR ************/
	public static class EntraineurWithEquipe extends Base {
			
	}
	/*********** Joueur  ************/
	public static class JoueurWithEquipe extends Base {
			
	}

}
