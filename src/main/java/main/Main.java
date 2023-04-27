package main;


import main.wordcount.WordCountMain;

public class Main {

  public static void main(String[] args) throws Exception {

    WordCountMain.run(new String[]{
        "/home/cdanmontoya/Documents/unal/mapreduce/src/main/resources/input.txt",
        "/home/cdanmontoya/Documents/unal/mapreduce/src/main/resources/output"
    });


  }

}
