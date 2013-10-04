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
        service.addCheckPoint(traveller, "deadsea", "so good")

        assert 1 == Traveller.count
        assert 1 == CheckPoint.count
        assert 1 == CheckPointComment.count
    }

    void testAddCheckPointUnsaveComment() {
        Traveller traveller = new Traveller(name: "little-tree").save()
        service.addCheckPoint(traveller, "deadsea", null)

        assert 1 == Traveller.count
        assert 1 == CheckPoint.count
        assert 0 == CheckPointComment.count
    }
}
