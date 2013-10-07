package trans

class TravellerService {

    def addCheckPointWithTransaction(Traveller traveller, String checkPointName, String comment) {
        CheckPoint.withTransaction {
            CheckPoint checkPoint = createCheckPoint(checkPointName)
            createCheckPointComment(traveller, checkPoint, comment)
        }
    }

    def addCheckPoint(Traveller traveller, String checkPointName, String comment) {
        CheckPoint checkPoint = createCheckPoint(checkPointName)
        createCheckPointComment(traveller, checkPoint, comment)
    }

    def createCheckPoint(String checkPointName) {
        new CheckPoint(name: checkPointName).save(failOnError:true)
    }

    def createCheckPointComment(Traveller traveller, CheckPoint checkPoint, String comment) {
        new CheckPointComment(traveller: traveller, checkPoint: checkPoint, comment: comment).save(failOnError: true)
    }
}
