package org.kodejava.awt;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class RunningDefaultMailClient {
    public static void main(String[] args) {
        // Get an instance of Desktop. An UnsupportedOperationException will
        // be thrown if the platform doesn't support Desktop API.
        Desktop desktop = Desktop.getDesktop();

        try {
            // Open user-default mail client application.
            desktop.mail();
        } catch (IOException e) {
        }

        try {
            // Open user-default mail client with the email message fields information.
            String message = "mailto:karnaraj05@gmail.com?cc=&subject=Feedback&body=feedbackmessage";
            URI uri = URI.create(message);
            desktop.mail(uri);
        } catch (IOException e) {
        }
    }
}