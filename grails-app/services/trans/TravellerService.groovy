package trans

class TravellerService {

    def serviceMethod() {

    }

    void addCheckPoint(Traveller traveller, String checkPointName, String comment) {
        CheckPoint checkPoint = new CheckPoint(name: checkPointName).save()
        CheckPointComment checkPointComment = new CheckPointComment(traveller, checkPoint, comment)
        checkPointComment.save()
    }
}
