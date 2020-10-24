package com.gauravg.dynamo.helper;

import java.util.List;

public class TestDynamo {

    public static void main(String arg[]) {

        FakePicture pix = new FakePicture();
        pix.setFrontView("http://example.com/products/123_front.jpg");
        pix.setRearView("http://example.com/products/123_rear.jpg");
        pix.setSideView("http://example.com/products/123_left_side.jpg");


        FakeCustomer mc1 = new FakeCustomer();
        mc1.setPARTITION_KEY("SGSG");
        mc1.setSORT_KEY("1");
        mc1.setFees(600);
        mc1.setImg(pix);

        FakeCustomer mc3 = new FakeCustomer();
        mc3.setPARTITION_KEY("FFFFRR");
        mc3.setSORT_KEY("1");
        mc3.setFees(600);
        mc3.setImg(pix);
        
        FakeStudent s1 = new FakeStudent();
        // department
        s1.setPARTITION_KEY("Engineering");
        // roll number;
        s1.setSORT_KEY("120");

        final List<FakeStudent> item1 = EHelper.querySortKeyGreaterThanOrEqualTo(s1,null,true);


//        FakeCustomer item2 = EHelper.getItem(mc1);
         mc1 = EHelper.getItem(mc3);
         mc1.setFees(600);


        EHelper.TxnPacket packet = EHelper.TxnPacket.builder()
//                .update(item1, FakeStudent.class, null )
//                .insert(item2, FakeCustomer.class)
//                .update(item1, FakeCustomer.class,null)
//                .insert(mc1,FakeCustomer.class)
//                .insert(mc2, FakeCustomer.class)
                .build();


        EHelper.executeTransactionWrite(packet);

        FakeCustomer item = EHelper.getItem(mc1);
//        FakeCustomer item1 = EHelper.getItem(mc2);
        System.out.println(" ITEM  "+ item);
//        System.out.println(" ITEM  1 "+ item1);


    }


}
