package trans



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(TravellerService)
@Mock([Traveller, CheckPoint, CheckPointComment])
class TravellerServiceTests {

    void testAddCheckPoint() {
        Traveller traveller = new Traveller(name: "little-tree").save()
        service.addCheckPoint(traveller.id, "deadsea", "so good")

        assert 1 == CheckPoint.count
        assert 1 == CheckPointComment.count
    }
}