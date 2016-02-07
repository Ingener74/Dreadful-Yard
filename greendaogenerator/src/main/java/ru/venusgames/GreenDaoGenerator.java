package ru.venusgames;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenDaoGenerator {
    public static void main(String [] args){
        Schema schema = new Schema(1, "ru.venusgames.pavel.dreadfulyard.database");

        Entity contact = schema.addEntity("Contact");
        contact.addIdProperty();
        contact.addStringProperty("contactUserId");
        contact.addStringProperty("contactPhoneNumber");
        contact.addStringProperty("contactName");
        contact.addIntProperty("contactStatus");

        Entity phoneNumber = schema.addEntity("PhoneNumber");
        phoneNumber.addIdProperty();
        phoneNumber.addStringProperty("phoneNumber");

        Entity message = schema.addEntity("Message");
        message.addIdProperty();
        message.addStringProperty("messageChatId");
        message.addStringProperty("messageUserId");
        message.addStringProperty("messageMessageId");
        message.addStringProperty("messageType");
        message.addIntProperty("messageStatus");
        message.addStringProperty("messageData");
        message.addDateProperty("messageTimeStamp");

        try {
            new DaoGenerator().generateAll(schema, ".\\app\\src\\main\\java\\ru\\venusgames\\pavel\\dreadfulyard\\database");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("current dir " + System.getProperty("user.dir"));
    }
}
