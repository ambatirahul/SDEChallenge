import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Queue implementation of {@link IMovingAverage}
 * 
 * @param <T>
 */
public class MovingAverageQueueImpl<T extends Number> implements IMovingAverage<Number> {

    private int windowSize;
    private double windowSum = 0;
    private Deque<Number> queue;

    public MovingAverageQueueImpl(int windowSize) {
        if (windowSize <= 0) {
            throw new IllegalArgumentException("Window can't be less than 1");
        }
        this.queue = new ArrayDeque<>();
        this.windowSize = windowSize;
    }

    @Override
    public Double getMovingAverageOfElements() {
        return this.windowSum * 1.0 / Math.min(this.windowSize, this.queue.size());
    }

    @Override
    public void addElement(Number element) {

        queue.add(element);
        Number tail = this.queue.size() > this.windowSize ? this.queue.poll() : 0;
        this.windowSum = this.windowSum - tail.doubleValue() + element.doubleValue();
    }

    @Override
    public List<Number> getElements() {
        return new ArrayList<>(this.queue);
    }

    @Override
    public void clearList() {
        this.queue = new ArrayDeque<Number>();
    }

    @Override
    public void updateWindowSizeWith(int windowSize) {
        this.windowSize = windowSize;
    }

}
