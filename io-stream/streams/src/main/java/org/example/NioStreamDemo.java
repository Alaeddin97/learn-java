package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class NioStreamDemo {
    public static void main(String[] args) throws IOException {
   /*     Path pathFiles = Files.createDirectory(Paths.get("files"));
        Path greetingFile=Files.createFile(Paths.get("files/greetings.txt"));*/
        String textToWrite = "Hello everyone !" + System.lineSeparator() + "Here's Paris team" + System.lineSeparator();
/*        writeNio(Paths.get("files/greetings.txt"), textToWrite);
        readNio(Paths.get("files/greetings.txt"));*/
        String txtFiles=findFiles(Paths.get("files"),1);
        System.out.println("txtFiles = " + txtFiles);
        //String csvFiles = walkMethod(Paths.get("files"), 3);
        //System.out.println("files = " + csvFiles);
        System.out.println();
        System.out.println();
        Path path = Paths.get("files/greetings.txt");
        readNio(path);
        System.out.println();
        System.out.println();
        String listFilesName=listFiles(Paths.get("files"));
        System.out.println("listFilesName = " + listFilesName);
    }

    private static void writeNio(Path filePath, String textToWrite) throws IOException {
        //1.
        Path writeNio = Files.write(filePath, textToWrite.getBytes(), CREATE, APPEND);
        //2.
        try (
                BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath, CREATE, APPEND);
        ) {
            bufferedWriter.write(textToWrite);
        }
    }

    private static void readNio(Path filePath) throws IOException {
       /* List<String> lines = Files.readAllLines(filePath);
        lines.stream().forEach(System.out::println);*/
        byte[] bytes = Files.readAllBytes(filePath);
        String result = "";
        for (int i = 0; i < bytes.length; i++) {
            result += (char) bytes[i];
        }
        System.out.println("result = " + result);

    }

    private static String findFiles(Path startPath, int depth) throws IOException {

        List<String> names = new ArrayList<>();
        String txtFiles = "";
        Stream<Path> stream = Files
                .find(startPath, depth,
                        (specificPath, attr) -> String.valueOf(specificPath).endsWith(".txt"));
        //names = stream.collect(Collectors.toList());
        txtFiles = stream
                .map(path -> {
                    String[] split = String.valueOf(path).split("\\\\");
                    return split[split.length - 1];
                })
                .collect(Collectors.joining(";"));
        return txtFiles;
    }

    private static String walkMethod(Path startPath, int depth) throws IOException {

        Stream<Path> walk = Files.walk(startPath, depth);
        return walk.filter(path -> String.valueOf(path).endsWith(".csv"))
                .map(path -> {
                    String[] arr = path.toString().split("\\\\");
                    return arr[arr.length - 1];
                }).collect(Collectors.joining("; "));
    }

    private static String listFiles(Path path){
        File file=new File(path.toString());
        if(file.isDirectory()){
            File [] files=file.listFiles((filename)->filename.toString().endsWith(".txt"));
            String os=System.getProperty("os.name");
            if(os.contains("Windows")){
                return Arrays.stream(files)
                        .map(file1 ->file1.toString().split("\\\\")[1])
                        .collect(Collectors.joining(";"));
            }
            if(os.contains("Linux")) return Arrays.stream(files)
                    .map(file1 ->file1.toString().split("/")[1])
                    .collect(Collectors.joining(";"));
        }
        return "";
    }
}
























