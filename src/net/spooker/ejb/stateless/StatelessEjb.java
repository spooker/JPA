package net.spooker.ejb.stateless;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 4/28/13
 * Time: 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class StatelessEjb
{
    private final static Logger logger = Logger.getLogger(
            StatelessEjb.class.getName());
    @PostConstruct
    public void postConstruct()
    {
        logger.info("postConstruct called for " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void preDestroy()
    {
        logger.info("preDestroy called for " + this.getClass().getSimpleName());
    }

}
