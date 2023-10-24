package be.masqueou.punishmaster.spigot.utils.config;

public class Settings {

    /*
     * Main Settings
     */
    public String main_Lang;
    public boolean main_check_update;
    public boolean enable_bstats;
    public String cryptography_Key;

    /*
     * System Settings
     */
    public boolean system_proxy_proxy_mode;
    public boolean system_proxy_redisbungee_mode;

    /*
     * Database Settings
     */
    public boolean database_sqlite_use;
    public String database_sqlite_hostname;
    public String database_sqlite_username;
    public String database_sqlite_password;
    public String database_sqlite_database_name;

    public boolean database_mysql_use;
    public String database_mysql_hostname;
    public String database_mysql_username;
    public String database_mysql_password;
    public String database_mysql_database_name;
    public String database_mysql_port;

    /*
     * Permissions Settings
     */
    public String permissions_commands_help;
    public String permissions_commands_ban;
    public String permissions_commands_unban;
    public String permissions_commands_ban_ip;
    public String permissions_commands_unban_ip;
    public String permissions_commands_mute;
    public String permissions_commands_unmute;
    public String permissions_commands_mute_ip;
    public String permissions_commands_unmute_ip;
    public String permissions_commands_kick;
    public String permissions_commands_kick_ip;
    public String permissions_commands_history;
    public String permissions_commands_staff_history;
    public String permissions_commands_rollback;
    public String permissions_commands_lockdown;
    public String permissions_commands_staff_chat;
    public String permissions_chat_staffchat_view;
    public String permissions_chat_view_punishment;

}
