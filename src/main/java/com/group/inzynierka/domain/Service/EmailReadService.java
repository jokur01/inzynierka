package com.group.inzynierka.domain.Service;

import org.springframework.stereotype.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import jakarta.mail.*;

@Service
public class EmailReadService {

    public List<String> receiveMail(String username, String password) {
        List<String> OTPList = null;
        try {
            Properties prop = new Properties();
            prop.setProperty("mail.store.protocol", "imaps");
            Session emailSession = Session.getDefaultInstance(prop);
            Store emailStore = emailSession.getStore("imaps");
            emailStore.connect("imap.gmail.com", username, password);
            Folder emailFolder = emailStore.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            Message[] messages = emailFolder.getMessages();
            OTPList = new ArrayList<>();
            for (Message message : messages) {
                OTPList.add((String) message.getContent());
            }
            emailFolder.close(false);
            emailStore.close();
        } catch (MessagingException me) {
            me.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return OTPList;
    }

}

