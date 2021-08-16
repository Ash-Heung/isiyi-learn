package com.isiyi.base;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: TestClass
 * @author: 向鹏飞
 * @since: 2021/7/28
 */
public class TestClass {

    @Test
    public void testStr2Json(){
        Class<Str2Json> str2JsonClass = Str2Json.class;
        String canonicalName = str2JsonClass.getCanonicalName();
        System.out.println("canonicalName >> " + canonicalName);
        String name = str2JsonClass.getName();
        System.out.println("name >> " + name);
        String typeName = str2JsonClass.getTypeName();
        System.out.println("typeName >> " + typeName);
        String simpleName = str2JsonClass.getSimpleName();
        System.out.println("simpleName >> " + simpleName);
        ClassLoader classLoader = str2JsonClass.getClassLoader();
        System.out.println("classLoader >> " + classLoader.toString());
        String date = "varchar(32)";
        String substring = date.substring(0, date.indexOf("("));
        System.out.println(substring);
    }

    @Test
    public void testDate(){
        // 初始化时间
        LocalDateTime localDateTime = LocalDate.now().atStartOfDay();
        Date today = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date endDay = Date.from(localDateTime.plus(1, ChronoUnit.DAYS).atZone(ZoneId.systemDefault()).toInstant());
        List<DateSplit> dateSplits = splitByMinute(today, endDay, 30);
        dateSplits.forEach(System.out::println);
    }

    public List<DateSplit> splitByMinute(Date startTime, Date endTime, int intervalMinutes) {
        long start = startTime.getTime();
        long end = endTime.getTime();

        if (end <= start) {
            return Collections.emptyList();
        }
        List<DateSplit> dateSplits =new ArrayList<>(48);
        while (start < end){
            Date s = new Date(start);
            Calendar c = Calendar.getInstance();
            c.setTime(s);
            c.add(Calendar.MINUTE, 30);
            Date e = c.getTime();
            DateSplit dateSplit = DateSplit.init(s, e);
            dateSplits.add(dateSplit);
            start += 30 * 60 * 1000;
        }
        return dateSplits;
    }

    @Test
    public void testIf(){
        int status = 3;
        if(2 != status && 6 != status){
            System.out.println("hello");
        }else {
            System.out.println("world");
        }


    }

    public  <T> T convertByType(String value, Class<T>  fieldType) throws Exception{
        Object obj = null;
        if (fieldType == String.class) {
            obj =  Objects.isNull(value) ? "" : value;
        } else if (fieldType == Boolean.class || fieldType == boolean.class) {
            obj = Objects.isNull(value) ? Boolean.FALSE : Boolean.valueOf(value);
        } else if (fieldType == Byte.class || fieldType == byte.class) {
            obj = Objects.isNull(value) ? 0 : Byte.valueOf(value);
        } else if (fieldType == Double.class || fieldType == double.class) {
            obj = Objects.isNull(value) ? 0 : Double.valueOf(value);
        } else if (fieldType == Float.class || fieldType == float.class) {
            obj = Objects.isNull(value) ? 0 : Float.valueOf(value);
        } else if (fieldType == Integer.class || fieldType == int.class) {
            obj = Objects.isNull(value) ? 0 : Integer.valueOf(value);
        } else if (fieldType == Long.class || fieldType == long.class) {
            obj = Objects.isNull(value) ? 0 : Long.valueOf(value);
        } else if (fieldType == Short.class || fieldType == short.class) {
            obj = Objects.isNull(value) ? 0 : Short.valueOf(value);
        } else if (fieldType == Character.class || fieldType == char.class) {
            obj = value.charAt(0);
        } else if (fieldType == BigDecimal.class) {
            obj = Objects.isNull(value) ? BigDecimal.ZERO : new BigDecimal(value);
        } else if (fieldType == BigInteger.class) {
            obj = Objects.isNull(value) ? 0 : new BigInteger(value);
        } else if (fieldType == Date.class) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            obj = sdf.parse(value);
        } else if (fieldType == List.class) {
            obj = Objects.isNull(value) ? Collections.emptyList() : Arrays.asList(value.split(","));
        } else if (fieldType == Set.class) {
            obj = Objects.isNull(value) ? Collections.emptySet() : new HashSet<>(Arrays.asList(value.split(",")));
        } else if (fieldType.isEnum()) {
            Class<?> cl = Class.forName(fieldType.getName());
            Field field = cl.getDeclaredField(value);
            obj = field.get(cl);
        } else if (fieldType == Pattern.class) {
            obj = Pattern.compile(value);
        } else {
            obj = value;
        }
        return (T) obj;
    }

}
