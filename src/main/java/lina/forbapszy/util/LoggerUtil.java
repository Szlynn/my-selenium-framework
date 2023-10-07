package lina.forbapszy.util;

import lombok.Getter;
import org.testng.log4testng.Logger;

public class LoggerUtil {

    @Getter
    protected static final Logger logger = Logger.getLogger(LoggerUtil.class);

    public static void log(String message) {
        logger.info(message);
    }

}
