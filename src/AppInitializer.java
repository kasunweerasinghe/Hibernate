import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;
import lk.ijse.hibernate.entity.OrderDetail;
import lk.ijse.hibernate.entity.Orders;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class AppInitializer {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        //Add Customer
        Customer c1 = new Customer();
        c1.setId("C001");
        c1.setName("Kasun");
        c1.setAddress("Wennappuwa");
        c1.setSalary(87000.00);

        Customer c2 = new Customer();
        c2.setId("C002");
        c2.setName("Amal");
        c2.setAddress("Colombo");
        c2.setSalary(65000.00);

        session.save(c1);
        session.save(c2);
        //Add Item
        Item i1 = new Item();
        i1.setCode("I001");
        i1.setDescription("Soap");
        i1.setUnitPrice(120.00);
        i1.setQtyOnHand(80);

        Item i2 = new Item();
        i2.setCode("I002");
        i2.setDescription("ToothBrush");
        i2.setUnitPrice(200.00);
        i2.setQtyOnHand(100);

        session.save(i1);
        session.save(i2);

        //Add Order
        Customer c3 = new Customer();
        c3.setId("C003");
        c3.setName("Bandara");
        c3.setAddress("Panadura");
        c3.setSalary(50000.00);

        Orders o1 = new Orders();
        o1.setId("O001");
        o1.setDate(LocalDate.now());
        o1.setCustomer(c3);

        Orders o2 = new Orders();
        o2.setId("O002");
        o2.setDate(LocalDate.now());
        o2.setCustomer(c3);

        session.save(c3);
        session.save(o1);
        session.save(o2);

        //Order Detail
        Item i3 = new Item();
        i3.setCode("I003");
        i3.setDescription("Pen");
        i3.setUnitPrice(20.00);
        i3.setQtyOnHand(80);

        Item i4 = new Item();
        i4.setCode("I004");
        i4.setDescription("Bread");
        i4.setUnitPrice(250.00);
        i4.setQtyOnHand(20);

        Customer c4 = new Customer();
        c4.setId("C004");
        c4.setName("Kamal");
        c4.setAddress("Colombo");
        c4.setSalary(34000.00);

        Orders o3 = new Orders();
        o3.setId("O003");
        o3.setDate(LocalDate.now());
        o3.setCustomer(c4);


        OrderDetail od1 = new OrderDetail();
        od1.setId("OD001");
        od1.setItem(i3);
        od1.setOrders(o3);
        od1.setQty(10);

        OrderDetail od2 = new OrderDetail();
        od2.setId("OD002");
        od2.setItem(i4);
        od2.setOrders(o3);
        od2.setQty(12);

        session.save(i3);
        session.save(i4);
        session.save(c4);
        session.save(o3);
        session.save(od1);
        session.save(od2);


        transaction.commit();
        session.close();

    }
}
