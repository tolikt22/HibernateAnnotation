package terela.com;

import terela.com.dao.BusDAO;
import terela.com.dao.BusDAOImpl;
import terela.com.model.Bus;

import java.sql.SQLException;
import java.util.List;

public class Test {

    private static BusDAO busDAO = new BusDAOImpl();

    public static void main(String[] args) {
        try {
            List<Bus> buses = busDAO.getAllBusses();
//            for (int i = 0; i < buses.size(); i++) {
//                System.out.println(buses.get(i));
//            }
//
//            Bus bus = busDAO.getBusById(1L);
//            System.out.println(bus);

            // add Buss
            Bus busForAdd = new Bus();
            busForAdd.setNumber("433");
            busDAO.addBus(busForAdd);
            busDAO.getBusById((long) 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
