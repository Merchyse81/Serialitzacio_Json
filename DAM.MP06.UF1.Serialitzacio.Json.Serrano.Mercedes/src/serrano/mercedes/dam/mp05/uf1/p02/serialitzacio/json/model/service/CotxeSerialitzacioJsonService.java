package serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.json.model.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.json.model.configuration.Settings;
import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.json.model.domain.Cotxe;
import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.json.model.repository.CotxeRepository;

public class CotxeSerialitzacioJsonService {
	
	private CotxeSerialitzacioJsonService() {
		
	}
	
	public static CotxeSerialitzacioJsonService getInstance() {
		if (instance == null) {
			instance = new CotxeSerialitzacioJsonService();
		}
		return instance;
	}
	
	private static CotxeSerialitzacioJsonService instance = null;
	

	private CotxeRepository cotxeRepository = CotxeRepository.getInstance();

	public void serialitzaUnCotxe(Cotxe cotxe) throws IOException {
		cotxeRepository.serialitzaUnCotxe(Settings.FICHERO_COTXE_INDIVIDUAL, cotxe);
	}

	public Cotxe deserialitzaUnCotxe() throws IOException {
		return cotxeRepository.deserialitzaUnCotxe(Settings.FICHERO_COTXE_INDIVIDUAL);
	}

	public void serialitzaLlistaCotxes(List<Cotxe> llistaCotxes) throws IOException {

		Cotxe[] arrayCotxes = null;

		if (llistaCotxes != null) {
			arrayCotxes = new Cotxe[llistaCotxes.size()];
			int comptador = 0;
			for (Cotxe a : llistaCotxes) {
				arrayCotxes[comptador] = a;
				comptador++;
			}
		}

		cotxeRepository.serialitzaLlistaCotxes(Settings.FICHERO_LLISTA_COTXES, arrayCotxes);
	}

	public List<Cotxe> deserialitzaLlistaCotxes() throws IOException {
		Cotxe[] arrayCotxes = cotxeRepository.deserialitzaLlistaCotxes(Settings.FICHERO_LLISTA_COTXES);
		ArrayList<Cotxe> llista = null;
		if (arrayCotxes != null && arrayCotxes.length > 0) {
			llista = new ArrayList<Cotxe>();
			for (Cotxe c : arrayCotxes) {
				llista.add(c);
			}
		}

		return llista;
	}

}
