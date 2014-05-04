import net.spooker.ejb.stateless.controller.interfaces.ControllerEJBRemote;

import java.rmi.RemoteException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 4/25/13
 * Time: 12:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestClient
{
    static Logger logger = Logger.getLogger(
            TestClient.class.getName());

    public static void main(String... args) throws NamingException, RemoteException
    {
        TestClient testClient = new TestClient();

        for (int i =0;i<1;i++)
        {
            logger.info("new Thread i="+i);
            Runnable r =  testClient.new MyThread();
            Thread t = new Thread(r);
            t.start();
        }

    }

    public class MyThread implements Runnable
    {
        @Override
        public void run()
        {
            ControllerEJBRemote controllerEJBRemote = null;
            InitialContext context = null;
            try
            {
                Hashtable<String, String> envs = new Hashtable<String, String>();
                envs.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
                context = new InitialContext(envs);

                controllerEJBRemote = (ControllerEJBRemote) InitialContext.doLookup("ejb:App/ejb//ControllerEJBBean!net.spooker.ejb.stateless.controller.interfaces.ControllerEJBRemote");
            }
            catch (NamingException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    context.close();
                }
                catch (NamingException e)
                {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
            logger.info("updating");
            //controllerEJBRemote.updateEmployeeFirstName(new Integer(100), "spooker1",new Integer(1));

            //controllerEJBRemote.removeNicknameFromEmployee(new Integer(100), "fireman");

            //controllerEJBRemote.getPhones(new Integer(100));

            //controllerEJBRemote.getHobbies(new Integer(100));

            //controllerEJBRemote.updateAddressBirthdateEmbeddable(new Integer(100));

            controllerEJBRemote.getEmployeesFirstNameLastNameTuple("John");






        }
    }



}
