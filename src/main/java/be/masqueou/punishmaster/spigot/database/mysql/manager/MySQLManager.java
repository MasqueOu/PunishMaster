package be.masqueou.punishmaster.spigot.database.mysql.manager;

import be.masqueou.punishmaster.spigot.PunishMaster;

import java.util.HashMap;

public class MySQLManager {

    private final HashMap<String, MySQL> databases = new HashMap<>();

    public MySQLManager(PunishMaster punishMaster) {
        MySQL mainDatabase = new MySQL("jdbc:mysql://",
                punishMaster.getSettings().database_mysql_hostname,
                punishMaster.getSettings().database_mysql_port,
                punishMaster.getSettings().database_mysql_database_name,
                punishMaster.getSettings().database_mysql_username,
                punishMaster.getSettings().database_mysql_password);
        registerNewDatabase(mainDatabase, "main");
    }

    public void registerNewDatabase(MySQL mySQL, String mysql_Name) {
        if (databases.containsKey(mysql_Name))
            return;
        if (databases.containsValue(mySQL))
            return;

        this.databases.put(mysql_Name, mySQL);
    }

    public MySQL get(String mysql_Name) {
        return this.databases.get(mysql_Name);
    }

    public void connect(MySQL mySQL) {
        if (mySQL.isConnected())
            return;
        mySQL.connection();
    }

    public void connect(String mysql_Name) {
        connect(get(mysql_Name));
    }

    public void disconnect(MySQL mySQL) {
        mySQL.disconnect();
    }

    public void disconnect(String mysql_Name) {
        disconnect(get(mysql_Name));
    }

    public void delete() {
        for(String string : this.databases.keySet()) {
            if(get(string).isConnected())
                get(string).disconnect();
            this.databases.remove(string);
        }
    }
}
