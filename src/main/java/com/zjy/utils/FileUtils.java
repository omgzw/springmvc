package com.zjy.utils;

import java.io.File;
import java.util.ArrayList;

/**
 * 
 * @author zjy
 *
 */
public class FileUtils {
	/**
	 * 获取指定目录下的文件夹(包含子目录)中所有大于fileSizeMB的文件
	 * 
	 * @param directory
	 * @param fileSize
	 * @return
	 */
	public static ArrayList<File> getFile(String directory, int fileSize) {
		ArrayList<File> fileList = new ArrayList<File>();
		File[] fileArr = new File(directory).listFiles();
		for (File fs : fileArr) {

			if (fs.isDirectory()) {
				getFile(fs.getPath(), fileSize);
			} else {
				if (fs.length() > fileSize) {
					fileList.add(fs);
					System.out.println(fs.getName() + "_文件大小" + fs.length() / 1024 / 1024 + "M");
				}
			}

		}
		return fileList;
	}
}
