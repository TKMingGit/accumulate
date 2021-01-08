package com.tkming.file.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/12/25 13:33
 * @desc 遍历指定目录，读取每个txt文件，逐行解析单词，存储单词次数，单词次数按大小降序输出
 */
public  class Test {
    public static void main(String[] args) {
        String directoryStr = "d:/tempSs/test/";
        File directory = new File(directoryStr);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        List<File> files = getFiles(directory, new ArrayList<>());
        HashMap<String, Word> summary = new HashMap<>(16);
        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                String str = null;
                while ((str = br.readLine()) != null) {
                    String[] word = str.split(" ");
                    for (String s : word) {
                        if (s != null &&  !"".equals(s.trim())) {
                            if (summary.containsKey(s)) {
                                Word w = summary.get(s);
                                w.setCount(w.getCount() + 1);
                            } else {
                                summary.put(s,new Word(s, 1));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ArrayList<Word> words =new ArrayList<Word>(summary.values());
        Collections.sort(words);
        for (Word word : words) {
            System.out.println(word.getWord()+","+word.getCount());
        }
    }

    public static List<File> getFiles(File directory, List<File> files) {
        File[] currents = directory.listFiles();
        for (File file : currents) {
            if (file.isDirectory()) {
                getFiles(file, files);
            } else {
                if (file.getName().endsWith("txt")) {
                    files.add(file);
                }
            }
        }
        return files;
    }
}

class Word implements Comparable<Word> {
    String word;
    Integer count;

    public Word(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int compareTo(Word o) {
        return (-1) * (this.count - o.count);
    }
}