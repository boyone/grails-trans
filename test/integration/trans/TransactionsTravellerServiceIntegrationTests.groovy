package trans

import org.junit.*

class TransactionsTravellerServiceIntegrationTests extends GroovyTestCase {
    static transactional = false
    def travellerService

    @Before
    void setUp() {
        Traveller.list().each { it.delete() }
        CheckPointComment.list().each { it.delete() }
        CheckPoint.list().each { it.delete() }
    }

    @After
    void tearDown() {
        Traveller.list().each { it.delete() }
        CheckPointComment.list().each { it.delete() }
        CheckPoint.list().each { it.delete() }
    }

    void testAddCheckPointUnsaveComment() {
        assert 0 == CheckPointComment.count
        assert 0 == CheckPoint.count
        Traveller traveller = new Traveller(name: "little-tree").save()

        shouldFail {
            travellerService.addCheckPointWithTransaction(traveller, "deadsea", null)
        }

        assert Traveller.findByName("little-tree")
        assert 0 == CheckPointComment.count
        assert 0 == CheckPoint.count
    }

    void testAddCheckPointUnsaveCommentDefault() {
        assert 0 == CheckPointComment.count
        assert 0 == CheckPoint.count
        Traveller traveller = new Traveller(name: "big-tree").save()

        shouldFail {
            travellerService.addCheckPoint(traveller, "deepsea", null)
        }

        assert Traveller.findByName("big-tree")
        assert 0 == CheckPointComment.count
        assert 0 == CheckPoint.count
    }
}
