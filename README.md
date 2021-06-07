# GroupHardcore

GroupHardcore is a SpigotMC/PaperMC plugin for helping to reset a Minecraft server instance upon a player death

## Features

This plugin upon player deaths creates a flag file, kicks all players, writes death message to `deathlog.txt`, then restarts the server.
It assumes you have a modified startup script to remove the world folders, and remove the flag file, like shown below.

## Usage

Compile the plugin, drop it in the plugins folder, and run your server with a start file resembling this script:
```bash
#!/bin/bash

if test -f "flag"; then
        rm -rf world* flag
fi

screen -dmS mc java -Xmx2G -Xms1024M -jar paper.jar nogui

```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
