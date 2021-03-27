public class MovingAverageTest {

    public static void main(String[] args) {

        IMovingAverage<Number> movingAverage = new MovingAverageImpl<Integer>(3);
        IMovingAverage<Number> movingAverageQueue = new MovingAverageQueueImpl<Integer>(3);

        Integer[] sampleElements = { 1, 3, 5, 7, 9, 11, 13 };

        for (Integer sample : sampleElements) {
            movingAverage.addElement(sample);
            movingAverageQueue.addElement(sample);
        }

        System.out.println("moving average : " + movingAverage.getMovingAverageOfElements());
        System.out.println("moving average queue : " + movingAverageQueue.getMovingAverageOfElements());

        System.out.println(movingAverage.getElements());
        System.out.println(movingAverageQueue.getElements());

    }

}
