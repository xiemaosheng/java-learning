package tomcat.connect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.URLClassLoader;
import java.text.MessageFormat;
import java.util.Hashtable;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/7/8 0008.
 */
public class StringManager {

    private ResourceBundle bundle;
    private static Log log = LogFactory.getLog(StringManager.class);

    private static Hashtable managers = new Hashtable();

    private StringManager(String packageName)
    {
        String bundleName = packageName + ".LocalStrings";
        try {
            this.bundle = ResourceBundle.getBundle(bundleName);
            return;
        }
        catch (MissingResourceException ex) {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl != null)
                try {
                    this.bundle = ResourceBundle.getBundle(bundleName, Locale.getDefault(), cl);
                    return;
                }
                catch (MissingResourceException ex2) {
                }
            if (cl == null) {
                cl = getClass().getClassLoader();
            }
            if (log.isDebugEnabled()) {
                log.debug("Can't find resource " + bundleName + " " + cl);
            }
            if (((cl instanceof URLClassLoader)) &&
                    (log.isDebugEnabled()))
                log.debug(((URLClassLoader)cl).getURLs());
        }
    }

    public String getString(String key)
    {
        return MessageFormat.format(getStringInternal(key), (Object[])null);
    }

    protected String getStringInternal(String key)
    {
        if (key == null) {
            String msg = "key is null";

            throw new NullPointerException(msg);
        }

        String str = null;

        if (this.bundle == null)
            return key;
        try {
            str = this.bundle.getString(key);
        } catch (MissingResourceException mre) {
            str = "Cannot find message associated with key '" + key + "'";
        }

        return str;
    }

    public String getString(String key, Object[] args)
    {
        String iString = null;
        String value = getStringInternal(key);
        try
        {
            Object[] nonNullArgs = args;
            for (int i = 0; i < args.length; i++) {
                if (args[i] == null) {
                    if (nonNullArgs == args) nonNullArgs = (Object[])args.clone();
                    nonNullArgs[i] = "null";
                }
            }

            iString = MessageFormat.format(value, nonNullArgs);
        } catch (IllegalArgumentException iae) {
            StringBuffer buf = new StringBuffer();
            buf.append(value);
            for (int i = 0; i < args.length; i++) {
                buf.append(" arg[" + i + "]=" + args[i]);
            }
            iString = buf.toString();
        }
        return iString;
    }

    public String getString(String key, Object arg)
    {
        Object[] args = { arg };
        return getString(key, args);
    }

    public String getString(String key, Object arg1, Object arg2)
    {
        Object[] args = { arg1, arg2 };
        return getString(key, args);
    }

    public String getString(String key, Object arg1, Object arg2, Object arg3)
    {
        Object[] args = { arg1, arg2, arg3 };
        return getString(key, args);
    }

    public String getString(String key, Object arg1, Object arg2, Object arg3, Object arg4)
    {
        Object[] args = { arg1, arg2, arg3, arg4 };
        return getString(key, args);
    }

    public static synchronized StringManager getManager(String packageName)
    {
        StringManager mgr = (StringManager)managers.get(packageName);

        if (mgr == null) {
            mgr = new StringManager(packageName);
            managers.put(packageName, mgr);
        }
        return mgr;
    }
}
