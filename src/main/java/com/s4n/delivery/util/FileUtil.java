package com.s4n.delivery.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileUtil {
	
	private static FileUtil fileUtil = null;
	
	private FileUtil() {
		
	}
	
	public static FileUtil getInstance() {
		if(fileUtil == null) {
			fileUtil = new FileUtil();
		}
		return fileUtil;
	}

	public List<String> readFile(String path) {
		List<String> list = new ArrayList<String>();
		try {
			list = FileUtils.readLines(new File(path), StandardCharsets.UTF_8.name());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void writeFile(String path, List<String> lines) {
		try {
			path = path + ".txt";
			FileUtils.writeLines(new File(path),
					StandardCharsets.UTF_8.name(), lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
