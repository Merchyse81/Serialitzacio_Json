package serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.json.model.repository;

import java.io.IOException;

import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.json.model.domain.Cotxe;

public class CotxeRepository {

		private CotxeRepository() {

		}

		public static CotxeRepository getInstance() {
			if (instance == null) {
				instance = new CotxeRepository();
			}

			return instance;
		}

		private static CotxeRepository instance = null;

		private CotxeJsonRepository cotxeJsonRepository = CotxeJsonRepository.getInstance();
		private PersistenciaFitxerTextRepository persistenciaFitxerTextRepository = PersistenciaFitxerTextRepository
				.getInstance();

		public void serialitzaUnCotxe(String fitxer, Cotxe cotxe) throws IOException {
			String jsonCotxe = cotxeJsonRepository.getJsonString(cotxe);
			persistenciaFitxerTextRepository.save(fitxer, jsonCotxe, false);
		}

		public Cotxe deserialitzaUnCotxe(String fitxer) throws IOException {
			String jsonCotxe = persistenciaFitxerTextRepository.read(fitxer);
			Cotxe cotxe = cotxeJsonRepository.getCotxeFromJson(jsonCotxe);
			return cotxe;
		}

		public void serialitzaLlistaCotxes(String fitxer, Cotxe[] cotxes) throws IOException {
			String jsonCotxe = cotxeJsonRepository.getJsonString(cotxes);
			persistenciaFitxerTextRepository.save(fitxer, jsonCotxe, false);
		}

		public Cotxe[] deserialitzaLlistaCotxes(String fitxer) throws IOException {
			String jsonCotxe = persistenciaFitxerTextRepository.read(fitxer);
			Cotxe[] cotxes = cotxeJsonRepository.getArrayCotxesFromJson(jsonCotxe);
			return cotxes;
		}

	
}
