import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import  java.text.ParseException;
import java.text.SimpleDateFormat;


public class main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ведите Ваши данные через пробел. \n" +
                "Пример: Васильева Василиса Васильевна 11.11.2011 89001231234 f");
        String input = scanner.nextLine();

        try {
            String[] data = input.split(" ");
            if (data.length != 6) {
                throw new IllegalArgumentException(" Количество данных не соответствует требуемому!!!");

            }
            String lastName = data[0];
            String firstName = data[1];
            String patronymic = data[2];
            String phone = data[4];
            if (phone.length() != 11) {
                throw new IllegalArgumentException("Неверный формат телефона в строке " + phone);
            }

            Date birthdate = parseDate(data[3]);
            char gender = data[5].charAt(0);

            System.out.println("Вы ввели: " + lastName + " " + firstName + " " + patronymic + " " + data[3] + " " + phone + " " + gender);
            File file = new File("C:/Документы/.GeekBrains/VS/JAVA_seminary/exceptions/1/"+lastName+".txt");
            if (file.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");
            }
            FileWriter writer = new FileWriter(file);
            writer.write("<"+lastName+"><"+ firstName +"><"+ patronymic +"><"+ data[3] + "> <"+ phone + "><"+ gender +">");
            writer.close();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error: неверный формат даты");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Недостаточно данных");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        return format.parse(dateStr);
    }

//    private static String formatDate(Date date) {
//
//        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
//        return format.format(date);
//    }
}







