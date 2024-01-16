import android.util.Log
import com.mihahoni.productslistapp.data.StateHandler
import com.mihahoni.productslistapp.data.model.Product
import com.mihahoni.productslistapp.data.model.ProductRating
import com.mihahoni.productslistapp.domain.ProductsUseCase
import com.mihahoni.productslistapp.fakeProductList
import com.mihahoni.productslistapp.ui.product.viewmodels.ProductsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class ProductsViewModelTest {

    @Mock
    lateinit var productsUseCase: ProductsUseCase

    private lateinit var viewModel: ProductsViewModel

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher) // Set the main dispatcher explicitly
        viewModel = ProductsViewModel(productsUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadData should update productsList and productsFetchingState on success`() =
        testDispatcher.runBlockingTest {
            `when`(productsUseCase.getProducts()).thenReturn(fakeProductList)

            viewModel.loadData()

            assert(viewModel.productsList.value == fakeProductList)
            assert(viewModel.productsFetchingState.value is StateHandler.Success<*>)
        }

    @Test
    fun `loadData should update productsFetchingState on failure`() =
        testDispatcher.runBlockingTest {
            val errorMessage = "Network error"
            `when`(productsUseCase.getProducts()).thenThrow(RuntimeException(errorMessage))

            viewModel.loadData()

            assert(viewModel.productsFetchingState.value is StateHandler.Failure)
            assert(
                (viewModel.productsFetchingState.value as StateHandler.Failure).message == errorMessage
            )
        }

    @Test
    fun `onSearchTextChange should update searchText in ViewModel`() {
        val searchText = "Test Search Text"

        viewModel.onSearchTextChange(searchText)

        assert(viewModel.searchText.value == searchText)
    }

}
