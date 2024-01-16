import com.mihahoni.productslistapp.data.repository.ProductsRepositoryImpl
import com.mihahoni.productslistapp.data.service.ApiService
import com.mihahoni.productslistapp.fakeProductList
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class ProductsRepositoryTest {

    @Mock
    private lateinit var mockApiService: ApiService

    private lateinit var repository: ProductsRepositoryImpl

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repository = ProductsRepositoryImpl(mockApiService)
    }

    @Test
    fun testGetAllProductFromApi() = runBlocking {
        `when`(mockApiService.getAllProducts()).thenReturn(fakeProductList)

        val actualProducts = repository.getAllProductFromApi()

        assertEquals(fakeProductList, actualProducts)
    }
}