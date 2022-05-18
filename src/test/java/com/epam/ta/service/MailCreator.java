package com.epam.ta.service;

import com.epam.ta.model.Mail;

public class MailCreator {

    private static final String TESTDATA_MAIL_SUBJECT = "testdata.mail.subject";
    private static final String TESTDATA_MAIL_TEXT = "testdata.mail.text";
    private static final String TESTDATA_MAIL_TO = "testdata.mail.to";

    public static Mail withCredentialsFromProperty(){
        return new Mail(TestDataReader.getTestData(TESTDATA_MAIL_TO), TestDataReader.getTestData(TESTDATA_MAIL_SUBJECT),
                TestDataReader.getTestData(TESTDATA_MAIL_TEXT));
    }

}
