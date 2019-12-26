package com.spksolutions.appointmentmaster.data;

import java.sql.Date;
import java.sql.Time;

public class Models {

    public Models(){}

    public class Appointment{
        long id;
        long clientId;
        long serviceId;
        Time time;
        Date date;
        String description,status,payment_status,time_h,time_m,date_day,date_month,date_year;

        public Appointment(){

        }

        public Appointment(long id){
            this();
            this.id = id;
        }

        public Appointment(long id,long c_id){
            this(id);
            clientId = c_id;
        }

        public Appointment(long id,long c_id,long serviceId){
            this(id,c_id);
            this.serviceId = serviceId;
        }

        public Appointment(long id,long c_id,long serviceId,Time time){
            this(id,c_id,serviceId);
            this.time = time;
        }

        public Appointment(long id,long c_id,long serviceId,Time time,Date date){
            this(id,c_id,serviceId,time);
            this.date = date;
        }

        public Appointment(long id,long c_id,long serviceId,Time time,Date date,String description){
            this(id,c_id,serviceId,time);
            this.date = date;
        }

        public Appointment(long id,long c_id,long serviceId,Time time,String description,String status,String payment_status){
            this(id,c_id,serviceId,time);
            this.description = description;
            this.status = status;
            this.payment_status = payment_status;
        }

        public Appointment(long id,long c_id,long serviceId,Time time,String description,String status){
            this(id,c_id,serviceId,time);
            this.description = description;
            this.status = status;
            this.payment_status = "Not Done";
        }
    }

    public class Client{
        long id;
        String name;String gender;
        String password;
        String phone_no;
        String email;
        String city;

        public Client(long id, String name, String gender, String password, String phone_no, String email, String city) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.password = password;
            this.phone_no = phone_no;
            this.email = email;
            this.city = city;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone_no() {
            return phone_no;
        }

        public void setPhone_no(String phone_no) {
            this.phone_no = phone_no;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    //Service Provider
    public class SP{
        long id;
        String name,email,phone_no,password,city,status;

        public SP(long id, String name, String email, String phone_no, String password, String city, String status) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.phone_no = phone_no;
            this.password = password;
            this.city = city;
            this.status = status;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone_no() {
            return phone_no;
        }

        public void setPhone_no(String phone_no) {
            this.phone_no = phone_no;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public class Message{
        long id;
        long aptid;
        String message,type_of_message,date_str,time_str;
        Date date;
        Time time;

        public Message(long id, long aptid, String message, String type_of_message, String date_str, String time_str, Date date, Time time) {
            this.id = id;
            this.aptid = aptid;
            this.message = message;
            this.type_of_message = type_of_message;
            this.date_str = date_str;
            this.time_str = time_str;
            this.date = date;
            this.time = time;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getAptid() {
            return aptid;
        }

        public void setAptid(long aptid) {
            this.aptid = aptid;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getType_of_message() {
            return type_of_message;
        }

        public void setType_of_message(String type_of_message) {
            this.type_of_message = type_of_message;
        }

        public String getDate_str() {
            return date_str;
        }

        public void setDate_str(String date_str) {
            this.date_str = date_str;
        }

        public String getTime_str() {
            return time_str;
        }

        public void setTime_str(String time_str) {
            this.time_str = time_str;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Time getTime() {
            return time;
        }

        public void setTime(Time time) {
            this.time = time;
        }
    }

    public class city{
        int id;
        String name;

        public city(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Service{
        long id;
        String title,city,day,status,stype,phone_no,image_path;
        double cost;
        long provider_id;
        Time time_start,time_end;
        Date startDate;

        public Service(long id, String title, String city, String day, String status, String stype, String phone_no, String image_path, double cost, long provider_id, Time time_start, Time time_end, Date startDate) {
            this.id = id;
            this.title = title;
            this.city = city;
            this.day = day;
            this.status = status;
            this.stype = stype;
            this.phone_no = phone_no;
            this.image_path = image_path;
            this.cost = cost;
            this.provider_id = provider_id;
            this.time_start = time_start;
            this.time_end = time_end;
            this.startDate = startDate;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStype() {
            return stype;
        }

        public void setStype(String stype) {
            this.stype = stype;
        }

        public String getPhone_no() {
            return phone_no;
        }

        public void setPhone_no(String phone_no) {
            this.phone_no = phone_no;
        }

        public String getImage_path() {
            return image_path;
        }

        public void setImage_path(String image_path) {
            this.image_path = image_path;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public long getProvider_id() {
            return provider_id;
        }

        public void setProvider_id(long provider_id) {
            this.provider_id = provider_id;
        }

        public Time getTime_start() {
            return time_start;
        }

        public void setTime_start(Time time_start) {
            this.time_start = time_start;
        }

        public Time getTime_end() {
            return time_end;
        }

        public void setTime_end(Time time_end) {
            this.time_end = time_end;
        }

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }
    }

    public class ServiceType{
        int id;
        String name;

        public ServiceType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
