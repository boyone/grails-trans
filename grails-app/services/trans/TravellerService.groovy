package trans

class TravellerService {

    void addCheckPoint(Traveller traveller, String checkPointName, String comment) {
        CheckPoint checkPoint = new CheckPoint(name: checkPointName).save()
        new CheckPointComment(traveller: traveller, checkPoint: checkPoint, comment: comment).save()
    }
}
