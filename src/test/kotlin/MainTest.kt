import co.edu.eam.disenosoftware.ejercicio.createAll
import co.edu.eam.disenosoftware.ejercicio.createCustomer
import co.edu.eam.disenosoftware.ejercicio.getBalanceByCities
import co.edu.eam.disenosoftware.ejercicio.getCities
import co.edu.eam.disenosoftware.ejercicio.getCustomerByName
import co.edu.eam.disenosoftware.ejercicio.getCustomerWithLeastMoney
import co.edu.eam.disenosoftware.ejercicio.getCustomerWithMostMoney
import co.edu.eam.disenosoftware.ejercicio.getCustomersByCity
import co.edu.eam.disenosoftware.ejercicio.getSumAllAccountsAllClients
import co.edu.eam.disenosoftware.ejercicio.getSumCheckAccountsAllClients
import co.edu.eam.disenosoftware.ejercicio.getSumSavingAccountsAllClients
import co.edu.eam.disenosoftware.ejercicio.sortCustomerByBalanceDesc
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MainTest {

    @BeforeEach
    fun setup() {
        createAll()
    }

    @Test
    fun getSumAllAccountsAllClientsTest() {
        val sum = getSumAllAccountsAllClients()
        Assertions.assertEquals(107000.0, sum)
    }
    @Test
    fun getSumCheckAccountsAllClientsTest() {
        val result = getSumCheckAccountsAllClients()
        Assertions.assertEquals(76000.0, result)
    }

    @Test
    fun getSumSavingAccountsAllClientsTest(){
        val result = getSumSavingAccountsAllClients()
        Assertions.assertEquals(31000.0, result)
    }

    @Test
    fun getCitiesTest() {
        val result = getCities()
        Assertions.assertEquals(listOf("bogota",
            "armenia", "el caimo", "montenegro", "tebaida", "calarca"), result)
    }

    @Test
    fun getCustomersByCityTest() {
        val result = getCustomersByCity("armenia")
        Assertions.assertEquals(listOf("camilo",
            "claudia", "gladys", "fabian"), result?.map { it.name })

    }

    @Test
    fun getBalanceByCitiesTest() {
        val result = getBalanceByCities()
        val assert = result?.values.toMutableList().sorted()
        Assertions.assertEquals(listOf(2000.0, 3000.0, 8000.0, 17000.0, 25000.0, 52000.0), assert)
    }

    @Test
    fun getCustomerByNameTest() {
        val result = getCustomerByName("claudia")
        Assertions.assertEquals("claudia", result?.name)
    }

    @Test
    fun getCustomerWithMostMoneyTest() {
        val result = getCustomerWithMostMoney()
        Assertions.assertEquals("amalia", result?.name)
    }

    @Test
    fun getCustomerWithLeastMoneyTest() {
        val result = getCustomerWithLeastMoney()
        Assertions.assertEquals("yojan", result?.name)
    }

    @Test
    fun sortCustomerByBalanceDescTest() {
        val result = sortCustomerByBalanceDesc()
        Assertions.assertEquals(listOf("amalia", "jorge",
            "gladys", "juan", "jose", "diego",
            "clara", "fabian", "claudia", "julieth",
            "camilo", "hernando", "yojan"), result?.map { it.name })
    }

    @Test
    fun calculateCheckBalance() {
        val customer = createCustomer("name", "lastName", "armenia", 3,3)
        val balance = customer.calculateBalanceCheckAccounts()
        Assertions.assertEquals(6000.0, balance)
    }

    @Test
    fun calculateSavingBalance() {
        val customer = createCustomer("name", "lastName", "armenia", 3,3)
        val balance = customer.calculateBalanceSavingAccounts()
        Assertions.assertEquals(3000.0, balance)
    }
}