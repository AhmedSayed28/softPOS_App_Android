package base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class AppiumServer {
    static AppiumDriverLocalService server;

    private static void setInstance(){
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withAppiumJS(new File("/Users/user/AppData/Roaming/npm/appium"))
                .usingDriverExecutable(new File("/Program Files/nodejs/node"))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File("AppiumLog.txt"))
                .withIPAddress("127.0.0.1");

        server = io.appium.java_client.service.local.AppiumDriverLocalService.buildService(builder);

    }

    private static AppiumDriverLocalService getInstance(){
        if(server == null){
            setInstance();
        }
        return server;
    }

    public static void start(){
        getInstance().start();
        System.out.println(server.getUrl());
        System.out.println(server.isRunning());
    }

    public static void stop(){
        if(server != null){
            getInstance().stop();
            System.out.println("Appium server stopped");
        }
    }

}
