package com.glaurung.batMap.io;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.glaurung.batMap.vo.AreaSaveObject;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FilenameUtils;

public class GsonJsonSerializer {
	private static ObjectMapper mapper = new ObjectMapper();

	public static void save(AreaSaveObject saveObject) {
		try {
			// Convert object to JSON string and save into a file directly
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(saveObject.getFileName()), saveObject);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static AreaSaveObject load(String filePath) {
		try {
			// Convert JSON string from file to Object
			AreaSaveObject saveObject = mapper.readValue(new File(filePath), AreaSaveObject.class);

			return saveObject;

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}