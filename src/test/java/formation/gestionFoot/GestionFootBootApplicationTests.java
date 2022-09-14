package formation.gestionFoot;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import formation.gestionFoot.model.Adresse;
import formation.gestionFoot.model.Arbitre;
import formation.gestionFoot.model.Attaquant;
import formation.gestionFoot.model.Defenseur;
import formation.gestionFoot.model.Entraineur;
import formation.gestionFoot.model.Gardien;
import formation.gestionFoot.model.Milieu;
import formation.gestionFoot.model.Pays;
import formation.gestionFoot.model.Stade;
import formation.gestionFoot.service.ArbitreService;
import formation.gestionFoot.service.AttaquantService;
import formation.gestionFoot.service.DefenseurService;
import formation.gestionFoot.service.EntraineurService;
import formation.gestionFoot.service.GardienService;
import formation.gestionFoot.service.MilieuService;

@SpringBootTest
class GestionFootBootApplicationTests {

	@Autowired ArbitreService arbitreService;
	@Autowired GardienService gardienService;
	@Autowired DefenseurService defenseurService;
	@Autowired MilieuService milieuService;
	@Autowired AttaquantService attaquantService;
	@Autowired EntraineurService entraineurService;
	
	@Test
	void contextLoads() {
		Arbitre orsato = new Arbitre("Orsato","Daniele",LocalDate.parse("1975-11-23"),63.0);
		Arbitre turpin = new Arbitre("Clément","Turpin",LocalDate.parse("1969-05-25"),0.1);
		
		arbitreService.create(orsato);
		arbitreService.create(turpin);
		
		Gardien courtois = new Gardien("Courtois","Thibaut",LocalDate.parse("1992-05-11"),40,50.5,67,80,0,0);
		Gardien vanDerSar = new Gardien("Van Der","Sar",LocalDate.parse("1980-05-11"),60,80.5,67,80,0,0);
		Gardien loris = new Gardien("Loris","Hugo",LocalDate.parse("1992-05-11"),40,50.5,70,80,0,0);
		gardienService.create(courtois);
		gardienService.create(vanDerSar);
		gardienService.create(loris);
		
		Defenseur mendy = new Defenseur("Mendy","Ferland",LocalDate.parse("1995-06-08"),79.1,65.4,90.3,44.9,0,59.7);	
		Defenseur kimpembe = new Defenseur("Presnel","Kimpembe",LocalDate.parse("1995-04-25"),0.5,0.4,0.7,0.8,0,25.0);	
		Defenseur Maguire = new Defenseur("Harry","Maguire",LocalDate.parse("1995-04-25"),0.5,0.4,0.7,0.8,0,25.9);
		
		defenseurService.create(mendy);
		defenseurService.create(kimpembe);
		defenseurService.create(Maguire);
		
		Milieu pogba = new Milieu ("Paul","Pogba",LocalDate.parse("1993-05-15"),0.76,0.79,0.5,0.8,20,10);
		Milieu dybala = new Milieu ("Paulo","Dybala",LocalDate.parse("1993-11-15"),0.5,0.4,0.7,0.8,0.5,25);
		Milieu pirlo = new Milieu ("Andrea","Pirlo",LocalDate.parse("1979-05-19"),0.5,0.4,0.7,0.8,0.5,25);

		milieuService.create(pogba);
		milieuService.create(dybala);
		milieuService.create(pirlo);
		

		Attaquant neymar = new Attaquant ("neymar","da Silva Santos Júnior",LocalDate.parse("1992-02-05"),0.7,0.94,0.65,0.45,15,25);
		Attaquant Cr7 = new Attaquant ("Cristiano","Ronaldo",LocalDate.parse("1985-02-05"),0.5,0.7,0.95,0.68,5,30);
		Attaquant Benzema = new Attaquant ("Karim","Benzema",LocalDate.parse("1987-12-19"),0.8,0.8,0.8,0.7,25,10);
		
		attaquantService.create(neymar);
		attaquantService.create(Cr7);
		attaquantService.create(Benzema);
		
		Entraineur mourinho = new Entraineur("José","Mourinho",LocalDate.parse("1965-04-25"),0.6,0.89,0.1,0.90,0.99);
		Entraineur ancelotti = new Entraineur("Ancelotti","Carlo",LocalDate.parse("1965-04-25"),0.6,0.89,0.1,0.90,0.99);
		
		entraineurService.create(mourinho);
		entraineurService.create(ancelotti);
		
		/**
		Adresse a1 = new Adresse("25", "Sir Matt Busby Way", "75000", "Manchester");
		Adresse a2 = new Adresse("45", "10 Av. Simone Veil", "69150", "Decines-Charpieu");
		Adresse a3 = new Adresse("67", "1 All. Gabriel Bienes", "45000", "Toulouse");
		Adresse a4 = new Adresse("11", "Mapou", "16000", "Maurice AnjalayIleMaurice");
		
		
		
		Stade Anfield = new Stade(" ",500,a1,95.0,Pays.Allemagne);
		Stade StadeDeLumiere= new Stade(" ",500,a2,80.0,Pays.Belgique);
		Stade StadiumToulouse= new Stade(" ",500,a3,70.0,Pays.Espagne);
		Stade AnjalayIleMaurice= new Stade(" ",500,a4, 60.0,Pays.Finlande);
		**/
		
		
		
		
	}

}
