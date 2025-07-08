package Service;

import Model.EBook;

public class MailService {
    public static void send(EBook book, String email) {
        System.out.println("Sending '" + book.getTitle() + "' to " + email + " (" + book.getFileType() + ")");
    }
}
