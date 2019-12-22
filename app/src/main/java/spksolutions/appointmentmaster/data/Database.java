package spksolutions.appointmentmaster.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;

import java.io.File;

import spksolutions.appointmentmaster.MainActivity;

public class Database {

    private static SQLiteDatabase data;
    private String path;




    public Database(){
        path = MainActivity.path;
        try {
            data = SQLiteDatabase.openOrCreateDatabase(path+"/AppData", null);
            Log.d(" - Log Message: "," Successfull");
            String query = "CREATE TABLE `appointment` (\n" +
                    "  `id` int(11) NOT NULL,\n" +
                    "  `clientid_id` int(11) NOT NULL,\n" +
                    "  `serviceid_id` int(11) NOT NULL,\n" +
                    "  `time` time(6) NOT NULL,\n" +
                    "  `date` date NOT NULL,\n" +
                    "  `description` varchar(288) NOT NULL,\n" +
                    "  `status` varchar(10) NOT NULL,\n" +
                    "  `payment_status` varchar(10) NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "\n" +
                    "CREATE TABLE `city` (\n" +
                    "  `id` int(11) NOT NULL,\n" +
                    "  `name` varchar(30) NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "--\n" +
                    "-- Dumping data for table `city`\n" +
                    "--\n" +
                    "\n" +
                    "INSERT INTO `city` (`id`, `name`) VALUES\n" +
                    "(1, 'Rajkot'),\n" +
                    "(2, 'Bhavnagar'),\n" +
                    "(3, 'Surat'),\n" +
                    "(4, 'Dwarka'),\n" +
                    "(5, 'Junagad'),\n" +
                    "(6, 'Vadodra');\n" +
                    "\n" +
                    "-- --------------------------------------------------------\n" +
                    "\n" +
                    "--\n" +
                    "-- Table structure for table `client`\n" +
                    "--\n" +
                    "\n" +
                    "CREATE TABLE `client` (\n" +
                    "  `id` int(11) NOT NULL,\n" +
                    "  `name` varchar(30)  NOT NULL,\n" +
                    "  `gender` varchar(6)  NOT NULL,\n" +
                    "  `password` varchar(30)  NOT NULL,\n" +
                    "  `phone_no` varchar(10)  NOT NULL,\n" +
                    "  `email` varchar(128)  NOT NULL,\n" +
                    "  `city` varchar(20)  NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "--\n" +
                    "-- Dumping data for table `client`\n" +
                    "--\n" +
                    "\n" +
                    "\n" +
                    "-- --------------------------------------------------------\n" +
                    "\n" +
                    "--\n" +
                    "-- Table structure for table `orders`\n" +
                    "--\n" +
                    "\n" +
                    "CREATE TABLE `orders` (\n" +
                    "  `id` int(11) NOT NULL,\n" +
                    "  `date_and_time` datetime(6) NOT NULL,\n" +
                    "  `status` varchar(10) NOT NULL,\n" +
                    "  `amount` double NOT NULL,\n" +
                    "  `appointmentid_id` int(11) NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "--\n" +
                    "-- Dumping data for table `orders`\n" +
                    "--\n" +
                    "\n" +
                    "-- --------------------------------------------------------\n" +
                    "\n" +
                    "--\n" +
                    "-- Table structure for table `service`\n" +
                    "--\n" +
                    "\n" +
                    "CREATE TABLE `service` (\n" +
                    "  `id` int(11) NOT NULL,\n" +
                    "  `title` varchar(30)  NOT NULL,\n" +
                    "  `providerid_id` int(11) NOT NULL,\n" +
                    "  `city` varchar(15)  NOT NULL,\n" +
                    "  `day` varchar(10)  NOT NULL,\n" +
                    "  `location` varchar(30)  NOT NULL,\n" +
                    "  `description` varchar(300)  NOT NULL,\n" +
                    "  `time_start_h` varchar(2)  NOT NULL,\n" +
                    "  `time_start_m` varchar(2)  NOT NULL,\n" +
                    "  `time_end_h` varchar(2)  NOT NULL,\n" +
                    "  `time_end_m` varchar(2)  NOT NULL,\n" +
                    "  `status` varchar(10)  NOT NULL,\n" +
                    "  `stype` varchar(10)  NOT NULL,\n" +
                    "  `cost` double NOT NULL,\n" +
                    "  `phone_no` varchar(10)  NOT NULL,\n" +
                    "  `image` varchar(30)  NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "--\n" +
                    "-- Dumping data for table `service`\n" +
                    "--\n" +
                    "\n" +
                    "\n" +
                    "-- --------------------------------------------------------\n" +
                    "\n" +
                    "--\n" +
                    "-- Table structure for table `servicetype`\n" +
                    "--\n" +
                    "\n" +
                    "CREATE TABLE `servicetype` (\n" +
                    "  `id` int(11) NOT NULL,\n" +
                    "  `name` varchar(30) NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "--\n" +
                    "-- Dumping data for table `servicetype`\n" +
                    "--\n" +
                    "\n" +
                    "INSERT INTO `servicetype` (`id`, `name`) VALUES\n" +
                    "(1, 'Doctor'),\n" +
                    "(2, 'Business'),\n" +
                    "(3, 'Education'),\n" +
                    "(4, 'Transport'),\n" +
                    "(5, 'Celebrity'),\n" +
                    "(6, 'New Type');\n" +
                    "\n" +
                    "-- --------------------------------------------------------\n" +
                    "\n" +
                    "--\n" +
                    "-- Table structure for table `sp`\n" +
                    "--\n" +
                    "\n" +
                    "CREATE TABLE `sp` (\n" +
                    "  `id` int(11) NOT NULL,\n" +
                    "  `name` varchar(20)  NOT NULL,\n" +
                    "  `email` varchar(128)  NOT NULL,\n" +
                    "  `phone_no` varchar(10)  NOT NULL,\n" +
                    "  `password` varchar(30)  NOT NULL,\n" +
                    "  `city` varchar(20)  NOT NULL,\n" +
                    "  `status` varchar(10)  NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "--\n" +
                    "-- Dumping data for table `sp`\n" +
                    "--\n" +
                    "\n" +
                    "\n" +
                    "--\n" +
                    "-- Indexes for dumped tables\n" +
                    "--\n" +
                    "\n" +
                    "--\n" +
                    "-- Indexes for table `appointment`\n" +
                    "--\n" +
                    "ALTER TABLE `appointment`\n" +
                    "  ADD PRIMARY KEY (`id`),\n" +
                    "  ADD KEY `appointment_clientid_id_f9379aad` (`clientid_id`),\n" +
                    "  ADD KEY `appointment_serviceid_id_3dd28ceb` (`serviceid_id`);\n" +
                    "\n" +
                    "--\n" +
                    "-- Indexes for table `city`\n" +
                    "--\n" +
                    "ALTER TABLE `city`\n" +
                    "  ADD PRIMARY KEY (`id`);\n" +
                    "\n" +
                    "--\n" +
                    "-- Indexes for table `client`\n" +
                    "--\n" +
                    "ALTER TABLE `client`\n" +
                    "  ADD PRIMARY KEY (`id`);\n" +
                    "\n" +
                    "--\n" +
                    "-- Indexes for table `orders`\n" +
                    "--\n" +
                    "ALTER TABLE `orders`\n" +
                    "  ADD PRIMARY KEY (`id`),\n" +
                    "  ADD KEY `orders_appointmentid_id_8f29bf2d_fk_appointment_id` (`appointmentid_id`);\n" +
                    "\n" +
                    "--\n" +
                    "-- Indexes for table `service`\n" +
                    "--\n" +
                    "ALTER TABLE `service`\n" +
                    "  ADD PRIMARY KEY (`id`),\n" +
                    "  ADD KEY `Foreign Key` (`providerid_id`),\n" +
                    "  ADD KEY `service_providerid_id_e305dccb` (`providerid_id`);\n" +
                    "\n" +
                    "--\n" +
                    "-- Indexes for table `servicetype`\n" +
                    "--\n" +
                    "ALTER TABLE `servicetype`\n" +
                    "  ADD PRIMARY KEY (`id`);\n" +
                    "\n" +
                    "--\n" +
                    "-- Indexes for table `sp`\n" +
                    "--\n" +
                    "ALTER TABLE `sp`\n" +
                    "  ADD PRIMARY KEY (`id`),\n" +
                    "  ADD UNIQUE KEY `id` (`id`),\n" +
                    "  ADD KEY `id_2` (`id`);\n" +
                    "\n" +
                    "--\n" +
                    "-- Constraints for dumped tables\n" +
                    "--\n" +
                    "\n" +
                    "--\n" +
                    "-- Constraints for table `appointment`\n" +
                    "--\n" +
                    "ALTER TABLE `appointment`\n" +
                    "  ADD CONSTRAINT `appointment_clientid_id_f9379aad_fk_client_id` FOREIGN KEY (`clientid_id`) REFERENCES `client` (`id`),\n" +
                    "  ADD CONSTRAINT `appointment_serviceid_id_3dd28ceb_fk_service_id` FOREIGN KEY (`serviceid_id`) REFERENCES `service` (`id`);\n" +
                    "\n" +
                    "--\n" +
                    "-- Constraints for table `orders`\n" +
                    "--\n" +
                    "ALTER TABLE `orders`\n" +
                    "  ADD CONSTRAINT `orders_appointmentid_id_8f29bf2d_fk_appointment_id` FOREIGN KEY (`appointmentid_id`) REFERENCES `appointment` (`id`);\n" +
                    "\n" +
                    "--\n" +
                    "-- Constraints for table `service`\n" +
                    "--\n" +
                    "ALTER TABLE `service`\n" +
                    "  ADD CONSTRAINT `service_providerid_id_e305dccb_fk_sp_id` FOREIGN KEY (`providerid_id`) REFERENCES `sp` (`id`);\n" +
                    "COMMIT;\n"
                    ;

            data.rawQuery(query,null);
        }
        catch (Exception e){
            Log.d(" - Log Message Error: ",e.toString());
        }
        Log.d(" - LogMessage: ",path);
    }

    public Cursor query(String query,String[] args){
        return data.rawQuery(query,args);
    }
}
