package serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.json.model.repository;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.json.model.domain.Cotxe;

public class CotxeJsonRepository {

		private CotxeJsonRepository() {

		}

		public static CotxeJsonRepository getInstance() {
			if (instance == null) {
				instance = new CotxeJsonRepository();
			}

			return instance;
		}

		private static CotxeJsonRepository instance = null;

		
		public String getJsonString(Cotxe cotxe) {
			
			Gson gson = new Gson();
			String contingutJson = gson.toJson(cotxe);
			return contingutJson;
		}

		public Cotxe getCotxeFromJson(String contingutJson) {
			
			Gson gson = new Gson();
			Cotxe cotxe = gson.fromJson(contingutJson, Cotxe.class);
			return cotxe;
		}

		// Array de cotxes
		public String getJsonString(Cotxe[] cotxes) {
			// Array cotxes a Json
			Gson gson = new Gson();
			String contingutJson = gson.toJson(cotxes);
			return contingutJson;
		}

		public Cotxe[] getArrayCotxesFromJson(String contingutJson) {

			Type arrayCotxesType = new TypeToken<Cotxe[]>() {
			}.getType();
			Gson gson = new Gson();
			Cotxe[] Cotxes = gson.fromJson(contingutJson, arrayCotxesType);
			return Cotxes;

		}

	}
	
	

