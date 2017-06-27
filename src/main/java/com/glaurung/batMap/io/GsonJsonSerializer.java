package com.glaurung.batMap.io;

import com.glaurung.batMap.gui.RoomColors;
import com.glaurung.batMap.vo.AreaSaveObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public class GsonJsonSerializer {
private static final Gson gson;

static {
	gson = new GsonBuilder()
		.setPrettyPrinting()
		.enableComplexMapKeySerialization()
		.registerTypeAdapter(Color.class, new ColorGsonSerializer())
		.registerTypeAdapter(Color.class, new ColorGsonDeserializer())
		.registerTypeAdapter(Point2D.class, new Point2DInstanceCreator())
		.create();
}


public static void save(AreaSaveObject saveObject) {
	try {
		FileWriter writer = new FileWriter(saveObject.getFileName());
		gson.toJson(saveObject, AreaSaveObject.class, gson.newJsonWriter(writer));

		writer.flush();
		writer.close();

	} catch (IOException e) {
		e.printStackTrace();
	}
}

	public static AreaSaveObject load(String filePath) {
	try {
		FileReader reader = new FileReader(filePath);

		AreaSaveObject saveObject = gson.fromJson(gson.newJsonReader(reader), AreaSaveObject.class);

		return saveObject;

	}
	catch (IOException e) {
	e.printStackTrace();
	}

	return null;
	}
}


class ColorGsonSerializer implements JsonSerializer<Color> {
	public JsonElement serialize(Color src, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(RoomColors.getColorNames()[RoomColors.getIndex(src)]);
	}
}

class ColorGsonDeserializer implements JsonDeserializer<Color> {
	public Color deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		return RoomColors.getColors()[RoomColors.getIndex(json.getAsJsonPrimitive().getAsString())];
	}
}

class Point2DInstanceCreator implements InstanceCreator<Point2D>{
	@Override
	public Point2D createInstance(Type type) {
		return new Point2D.Double();
	}
}
