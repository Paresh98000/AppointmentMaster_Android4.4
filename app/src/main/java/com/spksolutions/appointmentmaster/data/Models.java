package com.spksolutions.appointmentmaster.data;

import android.util.Log;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Models {

    public Models() {
    }

    public class Appointment {
        long id;
        long clientId;
        long serviceId;
        Date time;
        Date date;
        String description, status, payment_status;

        public Appointment() {

        }

        public Appointment(long id) {
            this();
            this.id = id;
        }

        public Appointment(long id, long c_id) {
            this(id);
            clientId = c_id;
        }

        public Appointment(long id, long c_id, long serviceId) {
            this(id, c_id);
            this.serviceId = serviceId;
        }

        public Appointment(long id, long c_id, long serviceId, Date time) {
            this(id, c_id, serviceId);
            this.time = time;
        }

        public Appointment(long id, long c_id, long serviceId, Date time, Date date) {
            this(id, c_id, serviceId, time);
            this.date = date;
        }

        public Appointment(long id, long c_id, long serviceId, Date time, Date date, String description) {
            this(id, c_id, serviceId, time);
            this.date = date;
        }

        public Appointment(long id, long c_id, long serviceId, Date time, String description, String status, String payment_status) {
            this(id, c_id, serviceId, time);
            this.description = description;
            this.status = status;
            this.payment_status = payment_status;
        }

        public Appointment(long id, long c_id, long serviceId, Date time, String description, String status) {
            this(id, c_id, serviceId, time);
            this.description = description;
            this.status = status;
            this.payment_status = "Not Done";
        }

        public String getTime_str() {
            String str;
            DateFormat formate = new SimpleDateFormat("hh:mm:ss");
            str = formate.format(time);
            return str;
        }

        public String getDate_str() {
            String str;
            DateFormat formate = new SimpleDateFormat("dd/MM/yyyy");
            str = formate.format(date);
            return str;
        }

        public void setTime(String time) {
            try {
                this.time = new SimpleDateFormat("hh:mm:ss").parse(time);
            } catch (Exception e) {
                Log.d(" Log Message", " Time Error in Appointment Model " + e.toString());
            }

        }

        public void setDate(String date) {
            try {
                this.date = new SimpleDateFormat("hh:mm:ss").parse(date);
            } catch (Exception e) {
                Log.d(" Log Message", " Date Error in Appointment Model " + e.toString());
            }
        }
    }

    public class Client {
        long id;
        String name;
        String gender;
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
    public class SP {
        long id;
        String name, email, phone_no, password, city, status;

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

    public class Message {
        long id;
        long aptid;
        String message, type_of_message;
        Date date;
        Date time;

        public Message(long id, long aptid, String message, String type_of_message, Date date, Date time) {
            this.id = id;
            this.aptid = aptid;
            this.message = message;
            this.type_of_message = type_of_message;
            this.date = date;
            this.time = time;
        }

        public String getDate_str() {
            String date_str;
            DateFormat formate = new SimpleDateFormat("dd/MM/yyyy");
            date_str = formate.format(date);
            return date_str;
        }

        public String getTime_str() {
            String time_str;
            DateFormat formate = new SimpleDateFormat("hh:mm:ss");
            time_str = formate.format(time);
            return time_str;
        }

        public void setTime(String t) {
            try {
                date = new SimpleDateFormat("hh:mm:ss").parse(t);
            } catch (Exception e) {
                Log.d(" Log Error", " Time Error in Message Model: " + e.toString());
            }
        }

        public void setDate(String d) {
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(d);
            } catch (Exception e) {
                Log.d(" Log Error", " Date Error in Message Model: " + e.toString());
            }
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

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }
    }

    public class city {
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

    public class Service {
        long id;
        String title, city, day, status, stype, phone_no, image_path;
        double cost;
        long provider_id;
        Date time_start, time_end;
        Date startDate;

        public Service(long id, String title, String city, String day, String status, String stype, String phone_no, String image_path, double cost, long provider_id, Date time_start, Date time_end, Date startDate) {
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

        public Date getTime_start() {
            return time_start;
        }

        public void setTime_start(Date time_start) {
            this.time_start = time_start;
        }

        public Date getTime_end() {
            return time_end;
        }

        public void setTime_end(Date time_end) {
            this.time_end = time_end;
        }

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public String getTimeStart_str() {
            String str;
            DateFormat formate = new SimpleDateFormat("hh:mm:ss");
            str = formate.format(time_start);
            return str;
        }

        public void setTimeStart(String startTime) {
            try {
                time_start = new SimpleDateFormat("hh:mm:ss").parse(startTime);
            } catch (Exception e) {
                Log.d(" Log Message", " Time Error in Service Model " + e.toString());
            }

        }

        public void setTimeEnd(String endTime) {
            try {
                time_end = new SimpleDateFormat("hh:mm:ss").parse(endTime);
            } catch (Exception e) {
                Log.d(" Log Message", " Time Error in Service Model " + e.toString());
            }

        }

        public String getTimeEnd_str() {
            String str;
            DateFormat formate = new SimpleDateFormat("hh:mm:ss");
            str = formate.format(time_end);
            return str;
        }


    }

    public class ServiceType {
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

    public class Sync {
        long id;
        String tbl_r_id, tbl, col, val, md, qry;
    }
}
