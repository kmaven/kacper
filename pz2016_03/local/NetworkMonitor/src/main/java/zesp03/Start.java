package zesp03;

import zesp03.pojo.CheckInfo;
import zesp03.pojo.ControllerRow;
import zesp03.pojo.DeviceRow;
import zesp03.pojo.SurveyRow;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Start {
    private final Management mgm;

    public Start() throws IOException {
        mgm = new Management();
    }

    public static void main(String[] args) throws IOException, SNMPException, SQLException, AdminException, InterruptedException {
        Start s = new Start();
        //s.examine();
        s.check();
    }

    public void examine() throws IOException, SQLException, SNMPException {
        System.out.println("start examine()");
        long t0 = System.nanoTime();

        mgm.examineAll();

        long t1 = System.nanoTime();
        double d = (t1 - t0) * 0.000000001;
        String f = String.format("czas trwania examine() = %.3fs", d);
        System.out.println( f );
    }

    public void check() throws SQLException {
        System.out.println("start check()");
        long t0 = System.nanoTime();

        final ArrayList<CheckInfo> list = mgm.checkDevices();

        long t1 = System.nanoTime();
        double d = (t1 - t0) * 0.000000001;
        String f = String.format("czas trwania check() = %.3fs", d);
        System.out.println(f);
        System.out.println("stany urządzeń:");
        for(CheckInfo ci : list) {
            ControllerRow ct = ci.controller();
            DeviceRow dev = ci.device();
            SurveyRow sur = ci.survey();
            System.out.println("[" + dev.getName() + "] " +
                    (sur.isEnabled() ? "on  " : "off ") +
                    sur.getClientsSum() );
        }
    }
}
