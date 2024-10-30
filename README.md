# tapr-20204-turmab-proreitoriadeensino-java
```
curl --insecure https://localhost:8081/_explorer/emulator.pem > ~/emulatorcert.crt
sudo cp ~/emulatorcert.crt /usr/local/share/ca-certificates/
sudo update-ca-certificates
cd /workspaces/tapr-20204-turmab-proreitoriadeensino-java
keytool -importcert -file ~/emulatorcert.crt -keystore native.jks -alias cosmosdb
```