import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderStatusManagerTest {
    static int testCaseNumber = 1;

    @BeforeAll
    public static void init() {
        System.out.println("TestOrderStatusManager is started");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("------------------TC-" + testCaseNumber + ": is started---------------");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("------------------TC-" + testCaseNumber + ": is finished--------------");
        System.out.println("#################################################");
        testCaseNumber++;
    }

    @ParameterizedTest
    @ValueSource(strings = {"NEW", "PENDING"})
    public void testCancellation(String status) {
        OrderStatusManager.OrderState currentStatus = OrderStatusManager.OrderState.valueOf(status);
        OrderStatusManager.OrderState actualCase = OrderStatusManager.cancelOrder(currentStatus);
        OrderStatusManager.OrderState expectedCase = OrderStatusManager.OrderState.CANCELLED;
        System.out.println("cancelOrder() method is called :");
        System.out.println("input --> " + currentStatus + "\n" +
                "Expected result : 'CANCELLED\n" +
                "Actual result : " + actualCase);
        assertEquals(actualCase, expectedCase, "Cancellation must be handled successfully.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"SHIPPED", "DELIVERED", "CANCELLED"})
    public void testUnCancellation(String status) {
        OrderStatusManager.OrderState currentStatus = OrderStatusManager.OrderState.valueOf(status);
        OrderStatusManager.OrderState actualCase = OrderStatusManager.cancelOrder(currentStatus);
        OrderStatusManager.OrderState expectedCase = currentStatus;
        System.out.println("input --> " + currentStatus + "\n" +
                "Expected result : " + currentStatus +
                "\nActual result : " + actualCase);
        assertEquals(actualCase, expectedCase, "Cancellation must not be activated.");
    }

    @Test
    public void testNextStateTransitionFromNew() {
        OrderStatusManager.OrderState actualCase = OrderStatusManager.nextState(OrderStatusManager.OrderState.NEW);
        OrderStatusManager.OrderState expectedCase = OrderStatusManager.OrderState.PENDING;
        System.out.println("nextState() method is called with \ninput --> 'NEW'");
        System.out.println("Expected State : " + expectedCase);
        System.out.println("Actual State : " + actualCase);
        assertEquals(actualCase, expectedCase, "State should be transferred from NEW to PENDİNG ");

    }

    @Test
    public void testNextStateTransitionFromPENDING() {
        OrderStatusManager.OrderState actualCase = OrderStatusManager.nextState(OrderStatusManager.OrderState.PENDING);
        OrderStatusManager.OrderState expectedCase = OrderStatusManager.OrderState.SHIPPED;
        System.out.println("nextState() method is called with \ninput --> 'PENDING'");
        System.out.println("Expected State : " + expectedCase);
        System.out.println("Actual State : " + actualCase);
        assertEquals(actualCase, expectedCase, "State should be transferred from PENDING to SHIPPED ");

    }

    @Test
    public void testNextStateTransitionFromSHIPPED() {
        OrderStatusManager.OrderState actualCase = OrderStatusManager.nextState(OrderStatusManager.OrderState.SHIPPED);
        OrderStatusManager.OrderState expectedCase = OrderStatusManager.OrderState.DELIVERED;
        System.out.println("nextState() method is called with \ninput --> 'SHIPPED'");
        System.out.println("Expected State : " + expectedCase);
        System.out.println("Actual State : " + actualCase);
        assertEquals(actualCase, expectedCase, "State should be transferred from SHIPPED to DELIVERED ");

    }

    @Test
    public void testNextStateTransitionFromDELIVERED() {
        OrderStatusManager.OrderState actualCase = OrderStatusManager.nextState(OrderStatusManager.OrderState.DELIVERED);
        OrderStatusManager.OrderState expectedCase = OrderStatusManager.OrderState.DELIVERED;
        System.out.println("nextState() method is called with \ninput --> 'DELIVERED'");
        System.out.println("Expected State : " + expectedCase);
        System.out.println("Actual State : " + actualCase);
        assertEquals(actualCase, expectedCase, "State should not be changed from DELIVERED ");

    }

    @Test
    public void testNextStateTransitionFromCANCELLED() {
        OrderStatusManager.OrderState actualCase = OrderStatusManager.nextState(OrderStatusManager.OrderState.CANCELLED);
        OrderStatusManager.OrderState expectedCase = OrderStatusManager.OrderState.CANCELLED;
        System.out.println("nextState() method is called with \ninput --> 'CANCELLED'");
        System.out.println("Expected State : " + expectedCase);
        System.out.println("Actual State : " + actualCase);
        assertEquals(actualCase, expectedCase, "State should not be changed from CANCELLED ");

    }

    @AfterAll
    public static void cleanUp() {
        System.out.println("TestOrderStatusManager is finished.");
    }
}
