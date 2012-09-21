package net.devmask.apns;

import org.junit.Test;

import java.io.File;

/**
 * APNS client test
 *
 * @author linux_china
 */
public class APNSClientTest {
    /**
     * test to send message
     *
     * @throws Exception exception
     */
    @Test
    public void testSend() throws Exception {
        String message = PayloadBuilder.getBuilder().badge(0).simpleAlert("你有未阅读的GuestPass消息").sound("default").toString();
        // creates a message 'message' to the 'DEVICE TOKEN' by the 'DEFAULT' connection
        APNSMessage apmessage = new APNSMessage("2537c7c1331fcff8509f627a032cc7fd19bea3758a9bd0c3c6a746c93d018e47", message, "DEFAULT");
        //single connection
        File p12File = new File(System.getProperty("user.home"), "apns/guestpath.p12");
        APNSConnectionHandler connectionHandler = new APNSConnectionHandler(p12File, "jjjjjjj".toCharArray());
        //sends the message
        connectionHandler.sendMessage(apmessage);
    }
}
