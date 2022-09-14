package formation.gestionFoot.jsonviews;

public class JsonViews {
	
	/************* BASE *************/
	public static class Base {
		
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
	
	/***********  ARBITRE   **********************/
	
	public static class ArbitreWithMatch extends Base {
		
	}
	/*********** Entraineur **********************/
	public static class EntraineurWithEquipe extends Base {
			
		}

}
