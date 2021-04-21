package Service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.mockito.BDDMockito.given;

import com.atexo.JeuCartes.JeuCartesApplication;
import com.atexo.JeuCartes.Enumeration.ECouleur;
import com.atexo.JeuCartes.Enumeration.EValeur;
import com.atexo.JeuCartes.Models.Carte;
import com.atexo.JeuCartes.Models.ResponseTriByColor;
import com.atexo.JeuCartes.Models.ResponseTriByValue;
import com.atexo.JeuCartes.Service.CarteService;
import com.atexo.JeuCartes.Service.Impl.CarteServiceImpl;


/**
 * @author SAIDANE NIHEL
 * @project JeuCartes
 * @created 02/04/2021
 */

@SpringBootTest(classes = { JeuCartesApplication.class })
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class CarteServiceTest {

	/** The service. */
	@Mock
	private CarteService carteService;

	/** The carte service impl. */
	@InjectMocks
	private CarteServiceImpl carteServiceImpl;

	/**
	 * Should get random carte.
	 *
	 * @throws Exception the exception
	 */

	@Test
	void shouldGetRandomCarte() throws Exception {
		// GIVEN
		List<Carte> cartesListMock = new ArrayList<>();
		Carte carteMock = new Carte();
		carteMock.setCouleur("PIQUE");
		carteMock.setValeur("AS");
		cartesListMock.add(carteMock);
	
		given(carteService.getRandomCarte()).willReturn(cartesListMock);

		// WHEN
		List<Carte> result = carteServiceImpl.getRandomCarte();
		// THEN
		assertThat(result).isNotNull();
		
	}
	

	/**
	 * Should post trie carte par ordre couleur.
	 *
	 * @throws Exception the exception
	 */

	@Test
	void shouldTriCarteCouleur() throws Exception {
		// GIVEN
		// SET ORDRE COULEUR
		List<String> listeCouleursMock = ECouleur.getValues();
		List<Carte> cartesListMock = new ArrayList<>();
		Carte carte = new Carte();
		carte.setCouleur("PIQUE");
		carte.setValeur("AS");
		cartesListMock.add(carte);

		ResponseTriByColor tricouleurlistMock = new ResponseTriByColor(cartesListMock, listeCouleursMock);

		
		given(carteService.triCarteCouleur(cartesListMock)).willReturn(tricouleurlistMock);

		// WHEN
		ResponseTriByColor result = carteServiceImpl.triCarteCouleur(cartesListMock);
		// THEN
		assertThat(result).isNotNull();
		
	}

	/**
	 * Should post trie carte par ordre valeur.
	 *
	 * @throws Exception the exception
	 */

	@Test
	void shouldTriCarteValeur() throws Exception {

		// SET ORDRE COULEUR
		List<String> listeValeurs = EValeur.getValues();
		List<Carte> cartesList = new ArrayList<>();
		Carte carte = new Carte();
		carte.setCouleur("PIQUE");
		carte.setValeur("AS");
		cartesList.add(carte);

		ResponseTriByValue trivaleurlist = new ResponseTriByValue(cartesList, listeValeurs);

		// GIVEN
		given(carteService.triCarteValeur(cartesList)).willReturn(trivaleurlist);

		// WHEN
		ResponseTriByValue result = carteServiceImpl.triCarteValeur(cartesList);
		// THEN
		assertThat(result).isNotNull();
	}

}
