package com.glaurung.batMap.io;
import com.glaurung.batMap.vo.AreaSaveObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JavaSerializer {

	public static void save(AreaSaveObject saveObject) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream( new File( saveObject.getFileName() ) );
		ObjectOutputStream objectOutputStream = new ObjectOutputStream( fileOutputStream );
		objectOutputStream.writeObject( saveObject );
		fileOutputStream.close();
	}

	public static AreaSaveObject load(String filePath) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(filePath);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		AreaSaveObject saveObject = (AreaSaveObject) objectInputStream.readObject();

		return saveObject;
	}

	public static void save2(AreaSaveObject saveObject) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream( new File( saveObject.getFileName() ) );
		ObjectOutputStream objectOutputStream = new ObjectOutputStream( fileOutputStream );
		objectOutputStream.writeObject( saveObject );
		fileOutputStream.close();
	}

	public static AreaSaveObject load2(String filePath) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(filePath);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		AreaSaveObject saveObject = (AreaSaveObject) objectInputStream.readObject();

		return saveObject;
	}
}