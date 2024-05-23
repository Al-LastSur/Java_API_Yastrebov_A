package lecture02;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.System.Logger.Level;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
// import java.util.logging.ConsoleHandler;
import java.util.logging.*;
// import java.util.logging.SimpleFormatter;
// import java.util.logging.XMLFormatter;


public class program {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(program.class.getName());
        // ConsoleHandler ch = new ConsoleHandler();
        // logger.addHandler(ch);
        FileHandler fh = new FileHandler("log.xml");
        logger.addHandler(fh);

        
        XMLFormatter xml = new XMLFormatter();
        // ch.setFormatter(xml);
        fh.setFormatter(xml);
        // SimpleFormatter sFormat = new SimpleFormatter();
        // ch.setFormatter(sFormat);
        
        logger.info("This is INFO");
        logger.warning("Test logging 1");
        logger.info("Test logging 2");


    }
}
