package com.mycompany.luyentap11;

interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Gửi Email với nội dung: " + message);
    }
}

class SMSService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Gửi SMS với nội dung: " + message);
    }
}

class Notification {
    private MessageService service;

    public void setService(MessageService service) {
        this.service = service;
    }

    public void send(String msg) {
        if (service != null) {
            service.sendMessage(msg);
        }
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Notification notification = new Notification();

        notification.setService(new EmailService());
        notification.send("Chào mừng bạn đến với hệ thống!");

        notification.setService(new SMSService());
        notification.send("Mã OTP của bạn là 199533");
    }
}
