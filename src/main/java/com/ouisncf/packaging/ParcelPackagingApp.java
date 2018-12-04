package com.ouisncf.packaging;

import com.ouisncf.packaging.service.PackagingRobot;
import com.ouisncf.packaging.service.SmartPackingRobot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main application program
 * Only the first argument will be taken into account,
 * considering  it as the input of the items size intended to be packed
 *
 * @author Seiffeddine BALLOUM
 */

public class ParcelPackagingApp {

    private static final Logger logger = LoggerFactory.getLogger(SmartPackingRobot.class);

    public static void main(String[] args) {
        PackagingRobot packagingRobot = new SmartPackingRobot(args != null && args.length > 0 ? args[0] : null);
        logger.info(packagingRobot.packReceivedItems());


    }
}
