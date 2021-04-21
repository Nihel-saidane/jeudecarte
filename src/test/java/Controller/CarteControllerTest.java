package Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.ArgumentMatchers.anyList;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import com.atexo.JeuCartes.JeuCartesApplication;
import com.atexo.JeuCartes.Controller.CarteController;
import com.atexo.JeuCartes.Enumeration.ECouleur;
import com.atexo.JeuCartes.Enumeration.EValeur;
import com.atexo.JeuCartes.Service.CarteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.atexo.JeuCartes.Models.Carte;
import com.atexo.JeuCartes.Models.ResponseTriByColor;
import com.atexo.JeuCartes.Models.ResponseTriByValue;

/**
 * @author SAIDANE NIHEL
 * @project JeuCartes
 * @created 02/04/2021
 */
@SpringBootTest(classes = { JeuCartesApplication.class })
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class CarteControllerTest {

	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;

	/** The controller. */
	@InjectMocks
	private CarteController carteController;

	/** The service. */
	@Mock
	private CarteService carteService;

	/**
	 * Setup.
	 */
	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(carteController).build();
	}

	@Test
	public void contextLoads() throws Exception {
		assertThat(carteController).isNotNull();
	}

	/**
	 * Should fail when wrong url.
	 *
	 * @throws Exception the exception
	 */

	@Test
	public void shouldFailWhenWrongUrl() throws Exception {

		// THEN
		this.mockMvc.perform(get("/randomCartess/").accept(MediaType.APPLICATION_JSON)).andExpect(status().is(404));
	}

	/**
	 * Should get random cartes.
	 *
	 * @throws Exception the exception
	 */

	@Test
	public void shouldGetRandomCarte() throws Exception {

		List<Carte> cartesList = new ArrayList<>();
		Carte carte = new Carte();
		carte.setCouleur("PIQUE");
		carte.setValeur("AS");
		cartesList.add(carte);

		// GIVEN
		given(carteService.getRandomCarte()).willReturn(cartesList);

		// THEN
		this.mockMvc.perform(get("/randomCartes").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].couleur", is("PIQUE"))).andExpect(jsonPath("$[0].valeur", is("AS")));
		verify(carteService, times(1)).getRandomCarte();
		verifyNoMoreInteractions(carteService);
	}

	/**
	 * Should fail when wrong url.
	 *
	 * @throws Exception the exception
	 */

	@Test
	public void shouldFailWhenWrongUrlOfTriCouleur() throws Exception {

		// THEN
		this.mockMvc.perform(post("/ordreCouleurss/").accept(MediaType.APPLICATION_JSON)).andExpect(status().is(404));
	}

	/**
	 * Convert an object to JSON.
	 *
	 * @param r the object to convert
	 * @return the JSON generated
	 * @throws Exception on error
	 */
	private byte[] toJson(Object r) throws Exception {

		ObjectMapper map = new ObjectMapper();
		return map.writeValueAsString(r).getBytes();
	}

	/**
	 * Should post ordre couleur cartes.
	 *
	 * @throws Exception the exception
	 */

	@Test
	public void shouldPostTriCouleurCarte() throws Exception {
		// SET ORDRE COULEUR
		List<String> listeCouleurs = ECouleur.getValues();

		// CREATE LIST CARTE NON TRIE
		List<Carte> cartesList = new ArrayList<>();

		ResponseTriByColor triList = new ResponseTriByColor(cartesList, listeCouleurs);

		// GIVEN
		given(carteService.triCarteCouleur(cartesList)).willReturn(triList);

		// THEN
		this.mockMvc.perform(post("/ordreCouleurs").content(toJson(cartesList)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		verify(carteService, times(1)).triCarteCouleur(anyList());
		verifyNoMoreInteractions(carteService);
	}

	/**
	 * Should fail when wrong url.
	 *
	 * @throws Exception the exception
	 */

	@Test
	public void shouldFailWhenWrongUrlOfTriValeur() throws Exception {

		// THEN
		this.mockMvc.perform(post("/ordreValeurss/").accept(MediaType.APPLICATION_JSON)).andExpect(status().is(404));
	}

	/**
	 * Should post ordre valeur cartes.
	 *
	 * @throws Exception the exception
	 */

	@Test
	public void shouldPostTriValeurCarte() throws Exception {
		// SET ORDRE VALEUR
		List<String> listeValeurs = EValeur.getValues();

		// CREATE LIST CARTE NON TRIE
		List<Carte> cartesList = new ArrayList<>();

		ResponseTriByValue triList = new ResponseTriByValue(cartesList, listeValeurs);

		// GIVEN
		given(carteService.triCarteValeur(cartesList)).willReturn(triList);

		// THEN
		this.mockMvc.perform(post("/ordreValeurs").content(toJson(cartesList)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		verify(carteService, times(1)).triCarteValeur(anyList());
		verifyNoMoreInteractions(carteService);
	}
	
	/**
	 * Should create ordre valeur .
	 *
	 * @throws Exception the exception
	 */
	
	  @Test
	    public void  shouldCreateOrderValeur(){
		  
		// CREATE LIST CARTE 
		List<Carte> cartesList = new ArrayList<>();
		Carte carte = new Carte();
		carte.setCouleur("PIQUE");
		carte.setValeur("AS");
		cartesList.add(carte);
		Carte carte1 = new Carte();
		carte1.setCouleur("CARREAUX");
		carte1.setValeur("HUIT");
		cartesList.add(carte1);
		Carte carte2 = new Carte();
		carte2.setCouleur("Coeur");
		carte2.setValeur("DIX");
		cartesList.add(carte2);
		Carte carte3 = new Carte();
		carte3.setCouleur("Pique");
		carte3.setValeur("DAME");
		cartesList.add(carte3);
		
		
		carteController.ordreValeurs(cartesList);

	    verify(carteService).triCarteValeur(cartesList);

	    }
	  
	  /**
		 * Should create ordre couleur .
		 *
		 * @throws Exception the exception
		 */
		
		  @Test
		    public void  shouldCreateOrderCouleur(){
			 
			// CREATE LIST CARTE 
			List<Carte> cartesList = new ArrayList<>();
			Carte carte = new Carte();
			carte.setCouleur("PIQUE");
			carte.setValeur("AS");
			cartesList.add(carte);
			Carte carte1 = new Carte();
			carte1.setCouleur("CARREAUX");
			carte1.setValeur("HUIT");
			cartesList.add(carte1);
			Carte carte2 = new Carte();
			carte2.setCouleur("Coeur");
			carte2.setValeur("DIX");
			cartesList.add(carte2);
			Carte carte3 = new Carte();
			carte3.setCouleur("Pique");
			carte3.setValeur("DAME");
			cartesList.add(carte3);
			
			
			
			
			carteController.ordreCouleurs(cartesList);

		    verify(carteService).triCarteCouleur(cartesList);

		    }
	

		
	  

}
