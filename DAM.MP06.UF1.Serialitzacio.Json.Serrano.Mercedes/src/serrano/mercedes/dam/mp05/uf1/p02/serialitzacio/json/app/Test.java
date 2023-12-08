package serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.json.app;

import serrano.mercedes.dam.mp05.uf1.p02.serialitzacio.json.controllers.CotxeSerialitzacioJsonController;

public class Test {

public static void main(String[] args) {
		
		CotxeSerialitzacioJsonController cotxeSerialitzacioJsonController = CotxeSerialitzacioJsonController.getInstance();
		cotxeSerialitzacioJsonController.serialitzaUnCotxe();
		cotxeSerialitzacioJsonController.deserialitzaUnCotxe();
		cotxeSerialitzacioJsonController.serialitzaLlistaCotxes();
		cotxeSerialitzacioJsonController.deserialitzaLlistaCotxes();

	}

}
