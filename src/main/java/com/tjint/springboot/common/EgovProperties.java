package com.tjint.springboot.common;

import com.tjint.springboot.egovframework.com.common.EgovWebUtil;
import com.tjint.springboot.egovframework.com.common.util.EgovResourceCloseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;


public class EgovProperties {
    private static final Logger LOGGER;
    static final String FILE_SEPARATOR;
    public static final String RELATIVE_PATH_PREFIX;
    public static final String GLOBALS_PROPERTIES_FILE;

    public static String getPathProperty(final String keyName) {
        String value = "";
        EgovProperties.LOGGER.debug("getPathProperty : {} = {}", (Object)EgovProperties.GLOBALS_PROPERTIES_FILE, (Object)keyName);
        FileInputStream fis = null;
        try {
            final Properties props = new Properties();
            fis = new FileInputStream(EgovWebUtil.filePathBlackList(EgovProperties.GLOBALS_PROPERTIES_FILE));
            props.load(new BufferedInputStream(fis));
            value = props.getProperty(keyName).trim();
            value = EgovProperties.RELATIVE_PATH_PREFIX + "egovProps" + System.getProperty("file.separator") + value;
        }
        catch (FileNotFoundException fne) {
            EgovProperties.LOGGER.debug("Property file not found.", (Throwable)fne);
            throw new RuntimeException("Property file not found", fne);
        }
        catch (IOException ioe) {
            EgovProperties.LOGGER.debug("Property file IO exception", (Throwable)ioe);
            throw new RuntimeException("Property file IO exception", ioe);
        }
        finally {
            EgovResourceCloseHelper.close(new Closeable[] { fis });
        }
        return value;
    }

    public static String getProperty(final String keyName) {
        String value = "";
        EgovProperties.LOGGER.debug("getProperty : {} = {}", (Object)EgovProperties.GLOBALS_PROPERTIES_FILE, (Object)keyName);
        FileInputStream fis = null;
        try {
            final Properties props = new Properties();
            fis = new FileInputStream(EgovWebUtil.filePathBlackList(EgovProperties.GLOBALS_PROPERTIES_FILE));
            props.load(new BufferedInputStream(fis));
            if (props.getProperty(keyName) == null) {
                return "";
            }
            value = props.getProperty(keyName).trim();
            return value;
        }
        catch (FileNotFoundException fne) {
            EgovProperties.LOGGER.debug("Property file not found.", (Throwable)fne);
            throw new RuntimeException("Property file not found", fne);
        }
        catch (IOException ioe) {
            EgovProperties.LOGGER.debug("Property file IO exception", (Throwable)ioe);
            throw new RuntimeException("Property file IO exception", ioe);
        }
        finally {
            EgovResourceCloseHelper.close(new Closeable[] { fis });
        }
    }

    public static String getPathProperty(final String fileName, final String key) {
        FileInputStream fis = null;
        try {
            final Properties props = new Properties();
            fis = new FileInputStream(EgovWebUtil.filePathBlackList(fileName));
            props.load(new BufferedInputStream(fis));
            fis.close();
            String value = props.getProperty(key);
            value = EgovProperties.RELATIVE_PATH_PREFIX + "egovProps" + System.getProperty("file.separator") + value;
            return value;
        }
        catch (FileNotFoundException fne) {
            EgovProperties.LOGGER.debug("Property file not found.", (Throwable)fne);
            throw new RuntimeException("Property file not found", fne);
        }
        catch (IOException ioe) {
            EgovProperties.LOGGER.debug("Property file IO exception", (Throwable)ioe);
            throw new RuntimeException("Property file IO exception", ioe);
        }
        finally {
            EgovResourceCloseHelper.close(new Closeable[] { fis });
        }
    }

    public static String getProperty(final String fileName, final String key) {
        FileInputStream fis = null;
        try {
            final Properties props = new Properties();
            fis = new FileInputStream(EgovWebUtil.filePathBlackList(fileName));
            props.load(new BufferedInputStream(fis));
            fis.close();
            final String value = props.getProperty(key);
            return value;
        }
        catch (FileNotFoundException fne) {
            EgovProperties.LOGGER.debug("Property file not found.", (Throwable)fne);
            throw new RuntimeException("Property file not found", fne);
        }
        catch (IOException ioe) {
            EgovProperties.LOGGER.debug("Property file IO exception", (Throwable)ioe);
            throw new RuntimeException("Property file IO exception", ioe);
        }
        finally {
            EgovResourceCloseHelper.close(new Closeable[] { fis });
        }
    }

    public static ArrayList<Map<String, String>> loadPropertyFile(final String property) {
        final ArrayList<Map<String, String>> keyList = new ArrayList<Map<String, String>>();
        final String src = property.replace('\\', File.separatorChar).replace('/', File.separatorChar);
        FileInputStream fis = null;
        try {
            final File srcFile = new File(EgovWebUtil.filePathBlackList(src));
            if (srcFile.exists()) {
                final Properties props = new Properties();
                fis = new FileInputStream(src);
                props.load(new BufferedInputStream(fis));
                fis.close();
                final Enumeration<?> plist = props.propertyNames();
                if (plist != null) {
                    while (plist.hasMoreElements()) {
                        final Map<String, String> map = new HashMap<String, String>();
                        final String key = (String)plist.nextElement();
                        map.put(key, props.getProperty(key));
                        keyList.add(map);
                    }
                }
            }
        }
        catch (IOException ex) {
            EgovProperties.LOGGER.debug("IO Exception", (Throwable)ex);
            throw new RuntimeException(ex);
        }
        finally {
            EgovResourceCloseHelper.close(new Closeable[] { fis });
        }
        return keyList;
    }

    static {
        LOGGER = LoggerFactory.getLogger((Class)EgovProperties.class);
        FILE_SEPARATOR = System.getProperty("file.separator");
        RELATIVE_PATH_PREFIX = EgovProperties.class.getResource("").getPath().substring(0, EgovProperties.class.getResource("").getPath().lastIndexOf("com"));
        GLOBALS_PROPERTIES_FILE = EgovProperties.RELATIVE_PATH_PREFIX + "egovProps" + EgovProperties.FILE_SEPARATOR + "globals.properties";
    }
}
