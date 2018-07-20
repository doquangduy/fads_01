	package common;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;

public class UserCustomFile {
	public static void saveFileLocal(File my_file, String file_name) {
		try {
			String configPath = System.getProperty("configPath");
			String final_path = configPath;
			File dir = new File(final_path);
			if (!dir.exists())
				dir.mkdirs();
			int index = file_name.indexOf(".");
			String tmpName = file_name.substring(0, index);
			String tmpExtend = file_name.substring(index);
			file_name = tmpName + "-" + Calendar.getInstance().get(Calendar.MILLISECOND) + tmpExtend;
			File fileToCreate = new File(final_path, file_name);
			FileUtils.copyFile(my_file, fileToCreate);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	