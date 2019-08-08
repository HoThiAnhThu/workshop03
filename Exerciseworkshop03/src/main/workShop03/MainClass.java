package workShop03;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class MainClass {

    private static final String BLANK = ",";
    private static final String LINE = ";";
    private static final String FILE_PATH = "D://data.txt";

    public static void main(String[] argv) throws IOException {

        Student student = new Student(1, "Thu", 9.0f, 9.0f, 9.0f, "good");
        student.getInfo();
        student.Collage = "testacb";
        System.out.println(student.Collage);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        File newFile = new File(FILE_PATH);
        if (newFile.exists()) {
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(FILE_PATH))) {
                String line;
                line = bufferedReader.lines().collect(Collectors.joining());
                System.out.println(line);
                String splitString = stringBuilder.append(line).append(";").toString();
                String[] resultSplitDownLine = splitString.split(LINE);
                for (String resultLine : resultSplitDownLine) {

                    String[] resultSplitComma = resultLine.split(BLANK);
                    Student newStudent = new Student();
                    newStudent.setId(Integer.valueOf(resultSplitComma[0]));
                    newStudent.setName(resultSplitComma[1]);
                    newStudent.setMathPoint(Float.valueOf(resultSplitComma[2]));
                    newStudent.setChemistryPoint(Float.valueOf(resultSplitComma[3]));
                    newStudent.setPhysicPoint(Float.valueOf(resultSplitComma[4]));
                    newStudent.setStatus(resultSplitComma[5]);
                    studentArrayList.add(newStudent);
                }
                for (Student student1 : studentArrayList) {
                    student1.getInfo();
                }
            }
            catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }
        } else {
            BufferedWriter writerFile = new BufferedWriter(new FileWriter(newFile));
            boolean check = true;
            do {
                Scanner input = new Scanner(System.in);
                System.out.println("Input number");
                int chon = input.nextInt();
                switch (chon) {
                    case 1:
                        System.out.println("Input id");
                        int id = input.nextInt();
                        for (Student studentNew : studentArrayList) {
                            if (studentNew.getId() == id) {
                                System.out.println("Input id");
                                id = input.nextInt();
                            }
                        }
                        writerFile.write(String.valueOf(id));
                        writerFile.write(BLANK);

                        System.out.println("Input name");
                        input.nextLine();
                        String name = input.nextLine();
                        writerFile.write(name);
                        writerFile.write(BLANK);

                        System.out.println("Input score 1");
                        float mathPoint = input.nextFloat();
                        if (mathPoint < 1 || mathPoint > 10) {
                            System.out.println("Nhap lai");
                            mathPoint = input.nextFloat();
                        }
                        writerFile.write(String.valueOf(mathPoint));
                        writerFile.write(BLANK);

                        System.out.println("Input score 2");
                        float chemistryPoint = input.nextFloat();
                        if (chemistryPoint < 1 || chemistryPoint > 10) {
                            System.out.println("Nhap lai");
                            chemistryPoint = input.nextFloat();
                        }
                        writerFile.write(String.valueOf(chemistryPoint));
                        writerFile.write(BLANK);

                        System.out.println("Input score 3");
                        float physicPoint = input.nextFloat();
                        if (physicPoint < 1 || physicPoint > 10) {
                            System.out.println("Input");
                            physicPoint = input.nextFloat();
                        }
                        writerFile.write(String.valueOf(physicPoint));
                        writerFile.write(BLANK);
                        input.nextLine();

                        System.out.println("Input status");
                        String status = input.nextLine();
                        writerFile.write(status);
                        writerFile.write(LINE);

                        Student studentNew = new Student(id, name, mathPoint, chemistryPoint, physicPoint, status);
                        System.out.println("Average score of Student");
                        System.out.println(studentNew.averagePoint());
                        System.out.println("Update Status of Student");
                        studentNew.updateStatus();
                        studentNew.getInfo();
                        studentArrayList.add(studentNew);
                        break;
                    case 2:
                        System.out.println("Sort following point");
                        Collections.sort(studentArrayList, new Comparator<Student>() {
                            @Override
                            public int compare(Student studentOne, Student studentTwo) {
                                if (studentOne.averagePoint() < studentTwo.averagePoint()) {
                                    return 1;
                                } else {
                                    if (studentOne.averagePoint() == studentTwo.averagePoint()) {
                                        return 0;
                                    } else {
                                        return -1;
                                    }
                                }
                            }
                        });
                        for (Student students : studentArrayList) {
                            students.getInfo();
                        }
                        break;
                    case 3:
                        StringBuilder sb = new StringBuilder();
                        try (BufferedReader br = Files.newBufferedReader(Paths.get(FILE_PATH))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                System.out.println(sb.append(line).append("\n"));
                            }
                        }
                        catch (IOException e) {
                            System.err.format("IOException: %s%n", e);
                        }

                        System.out.println(sb);
                        break;
                    case 4:
                        float point = 0;
                        int i = 0;
                        if (studentArrayList.isEmpty()) {
                            System.out.println("No data in file");
                        }
                        for (Student students : studentArrayList) {
                            if (students.averagePoint() > point) {
                                point = students.averagePoint();
                            }
                        }
                        for (Student students : studentArrayList) {
                            if (students.averagePoint() == point) {
                                students.getInfo();
                            }
                        }
                        break;
                    case 5:
                        check = false;
                        break;
                }
            } while (check);
            writerFile.close();
        }
    }
}
