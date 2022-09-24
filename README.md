# SourceMapBackup
Backup your maps into handy zips with one click. Configure and add additional content into the bundle simply.

View your backups with the in-app backup list.

# Configuration
- Run it for first time configuration
- Open the smb.properties file located in the root dir of the program
- It will look something like this
    ```properties
    #SourceMapBackup properties
    #Sun Sep 25 00:42:37 CEST 2022
    file.additional=<coma-separated-full-paths>
    file.map=<full-path-to-map>
    file.archive=<full-path-to-archive>
    ```
- Now you change it to your needs. 
    - `file.map` - full path to your vmf file
    - `file.archive` - full path to the folder where you would want the archives to be stored.
    - `file.additional` - coma seperated full paths to additional files you want added to the archive zip bundle.
      >WARNING
      >For now only files are supported
    ```properties
    #SourceMapBackup properties
    #Sun Sep 25 00:42:37 CEST 2022
    file.map=C:/Program Files (x86)/Steam/steamapps/common/Counter-Strike Global Offensive/sdk_content/maps/de_somber.vmf
    file.archive=C:/Users/user/Desktop/archive/
    file.additional=C:/Program Files (x86)/Steam/steamapps/common/Counter-Strike Global Offensive/csgo/resource/overviews/de_somber_radar.png
    ```
- There you go, you have configured it.
