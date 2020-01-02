package Apps.FileSearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class App {
    private String path;
    private String regex;
    private String zipFileName;
    Pattern pattern;
    List<File> zipFiles = new ArrayList<File>();

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
    }

    public String getZipFileName() {
        return zipFileName;
    }

    public void setZipFileName(String zipFileName) {
        this.zipFileName = zipFileName;
    }

    public static void main(String[] args) throws IOException {
        App app = new App();

        switch (Math.min(args.length,3)){
            case 0: System.out.println("Pass the parameters");
            case 3: app.setZipFileName(args[2]);
            case 2: app.setRegex(args[1]);
            case 1: app.setPath(args[0]);
        }

        app.walkDirectory(app.getPath());
    }

    private void walkDirectory(String path) throws IOException{
        System.out.println("Walk Directory:" + path);
            Files.walk(Paths.get(path))
                    .forEach(f -> {
                        try {
                            processFile(f.toFile());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            zipTheFiles(zipFiles);
    }

    private void zipTheFiles(List<File> zipFiles) {
        try(ZipOutputStream out = new ZipOutputStream(new FileOutputStream(getZipFileName()))){
            File baseDir = new File(getPath());

            for (File file: zipFiles) {
                String fileName = getRelativePath(file, baseDir);

                ZipEntry zipEntry = new ZipEntry(fileName);
                zipEntry.setTime(file.lastModified());
                out.putNextEntry(zipEntry);

                Files.copy(file.toPath(), out);

                out.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getRelativePath(File file, File baseDir) {
        String fileName = file.getAbsolutePath().substring(baseDir.getAbsolutePath().length());

        fileName = fileName.replace('\\', '/');

        while (fileName.startsWith("/")){
            fileName = fileName.substring(1);
        }
        return fileName;
    }

    private void processFile(File file) throws IOException {
        System.out.println("Process file:" + file);
        try {
            if(searchFile(file)){
                addFileToZip(file);
            }
        }catch (AccessDeniedException e){
            System.out.println(e);
        }
    }

    private boolean searchFile(File file) throws IOException {
        return Files.lines(file.toPath()).anyMatch(t -> searchText(t));
    }

    private boolean searchText(String text) {
        if(this.getRegex() == null) return true;
        return this.pattern.matcher(text).matches();
    }

    private void addFileToZip(File file) {
        if(this.getZipFileName() != null){
            zipFiles.add(file);
        }
    }
}
