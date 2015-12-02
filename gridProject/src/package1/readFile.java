package package1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class readFile {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		try {

			// -----------------------SAVE VIDEO FILE NAME IN THIS TEXT
			// FILE------------------------
			File file = new File("/home/mahmud/workspace/gridProject/src/package1/serverVideoName");
			//File fileIMG = new File("/home/mahmud/workspace/gridProject/src/package1/imgName");
			if (file.exists() == false) {

				file.createNewFile();

			}
//			if (fileIMG.exists()) {
//				fileIMG.createNewFile();
//
//			}
			// file.createNewFile();
			// --------------------------OPEN A FILE WRITER--------------------
			FileWriter fileWriter = new FileWriter(file);

			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		//	FileWriter fileWriterIMG = new FileWriter(fileIMG);

//			BufferedWriter bufferedWriterIMG = new BufferedWriter(fileWriterIMG);

			// -------READ VIDEO NAME FROM THIS VIDEO FOLDER----------

			String folderName = "/home/mahmud/Desktop/videofolder/";

			File folder = new File(folderName);// <<<<<<<<<<<CHANGE>>>>>>>>>>>
			File[] listoffile = folder.listFiles();

			int l = listoffile.length;

			/*
			 * File file = new File("C:\\Windows"); String[] names =
			 * file.list();
			 * 
			 * for(String name : names) { if (new File("C:\\Windows\\" +
			 * name).isDirectory()) { System.out.println(name); } }
			 */
			String[] names = folder.list();
			int ll = names.length;

			int i;
			for (i = 0; i < ll; i++) {
				if (new File(folderName + names[i]).isDirectory()) {

					// System.out.println("name = " + listoffile[i].getName());
					// bufferedWriter.write(listoffile[i].getName().toString());
					// bufferedWriter.write("--->fuck\n");

					System.out.println(folderName + names[i] + "/" + "poster" + ".jpg" + "\n");
					System.out.println(names[i] + "\n");
					bufferedWriter.write(names[i] + "\n");
					bufferedWriter.write(folderName + names[i] + "/" + "poster" + ".jpg" + "\n");
	//				bufferedWriterIMG.write(folderName + names[i] + "/" + names[i] + ".jpg" + "\n");
				}

			}
			bufferedWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("File create = " + e);
		}

	}

}
