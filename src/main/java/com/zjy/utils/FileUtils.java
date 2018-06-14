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
	 * ��ȡָ��Ŀ¼�µ��ļ���(������Ŀ¼)�����д���fileSizeMB���ļ�
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
					System.out.println(fs.getName() + "_�ļ���С" + fs.length() / 1024 / 1024 + "M");
				}
			}

		}
		return fileList;
	}
}
