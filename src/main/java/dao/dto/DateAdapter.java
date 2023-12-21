package dao.dto;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date unmarshal(String s) throws ParseException {
        return dateFormat.parse(s);
    }

    @Override
    public String marshal(Date date) {
        return dateFormat.format(date);
    }
}
