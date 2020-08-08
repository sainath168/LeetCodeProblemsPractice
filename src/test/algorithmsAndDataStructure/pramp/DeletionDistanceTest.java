package test.algorithmsAndDataStructure.pramp;

import main.algorithmsAndDataStructure.pramp.DeletionDistance;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

import java.util.Objects;

class DeletionDistanceTest {
    /**
     * This class is responsible for testing the deletionDistance method in PrampInterviewProblem1.
     *
     * Test Case1 :
     *  input:  str1 = "dog", str2 = "frog"
     *  output: 3
     *
     * Test Case2 :
     *  input:  str1 = "some", str2 = "some"
     *  output: 0
     *
     * Test Case3 :
     *  input:  str1 = "some", str2 = "thing"
     *  output: 9
     *
     * Test Case4 :
     *  input:  str1 = "", str2 = ""
     *  output: 0
     *
     * Test Case5 :
     *  input:  str1 = "heat", str2 = "hit"
     *  output: 3
     *
     * Test Case6:
     *  input:  str1 = "sainath", str2 = "sai"
     *  output: 4
     */

    DeletionDistance obj;

    @BeforeEach
    void createObjectForEachTest() {
        obj = new DeletionDistance();
    }

    @Test
    @DisplayName("Testcase with dog and frog")
    void test1() {
        String str1 = "dog";
        String str2 = "frog";
        Assumptions.assumeTrue(assumeStringisNotNull(str1, str2));
        assertEquals(3, obj.deletionDistance(str1, str2));
    }

    @Test
    @DisplayName("Testcase with equal strings")
    void test2() {
        String str1 = "some";
        String str2 = "some";
        assertEquals(0, obj.deletionDistance(str1, str2));
    }

    @Test
    @DisplayName("Multiple usecase in one test method")
    void test3() {
        assertAll(
                () -> assertEquals(9, obj.deletionDistance("some", "thing")),
                () -> assertEquals(0, obj.deletionDistance("", ""))
        );
    }

    @Test
    void test5() {
        String str1 = "heat";
        String str2 = "hit";
        assertEquals(3, obj.deletionDistance(str1, str2));
    }

    @Test
    @EnabledOnJre({JRE.JAVA_8})
    @DisplayName("Testcase enabled / runs on Java 8")
    void test6() {
        String str1 = "ab";
        String str2 = "ba";
        assertEquals(2, obj.deletionDistance(str1, str2));
    }

    @Test
    @Disabled
    @DisplayName("Testcase disabled")
    void test7() {
        String str1 = "dasdkadgagdagdkagds";
        String str2 = "dhashdahsdaodhoahduhadhashdosa";
        assertEquals(4, obj.deletionDistance(str1, str2));
        fail("just random strings but don't want to test it, so disabled :)");
    }

    @Test
    @DisplayName("Using assumeTrue to assume strings are not null, if so, then don't run this testcase.")
    void test8() {
        String str1 = "";
        String str2 = null;
        Assumptions.assumeTrue(assumeStringisNotNull(str1, str2));
        assertEquals(0, obj.deletionDistance(str1, str2));
    }


    boolean assumeStringisNotNull(String str1, String str2) {
        return Objects.nonNull(str1) && Objects.nonNull(str2);
    }

}
