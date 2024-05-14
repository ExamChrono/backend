package com.ExamChrono.services;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class HandleDateService {
    static String getString(Date date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        String formattedDate = formatter.format(date);

        String[] splitDate = formattedDate.split("T");
        String datePart = splitDate[0];
        String timePart = splitDate[1].split("\\.")[0];
        String[] splitTimePart = timePart.split(":");
        long heure = Long.parseLong(splitTimePart[0])-1;
        timePart = heure + ":" + splitTimePart[1];

        return datePart + "/" + timePart;
    }
}