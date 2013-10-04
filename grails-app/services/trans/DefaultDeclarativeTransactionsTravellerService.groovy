package trans

class DefaultDeclarativeTransactionsTravellerService {
    static transactional = true

    def addCheckPoint(Traveller traveller, String checkPointName, String comment) {
        CheckPoint checkPoint = new CheckPoint(name: checkPointName).save()
        new CheckPointComment(traveller: traveller, checkPoint: checkPoint, comment: comment).save()
    }
}
