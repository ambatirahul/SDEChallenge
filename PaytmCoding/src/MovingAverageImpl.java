import java.util.ArrayList;
import java.util.List;

/**
 * Queue implementation of {@link IMovingAverage}
 * 
 * @param <T>
 */
public class MovingAverageImpl<T extends Number> implements IMovingAverage<Number> {

    private List<Number> list;
    private int window = 0;

    public MovingAverageImpl(int window) {
        if (window <= 0) {
            throw new IllegalArgumentException("Window can't be less than 1");
        }
        this.list = new ArrayList<>();
        this.window = window;
    }

    @Override
    public Double getMovingAverageOfElements() {

        if (this.list.isEmpty()) {
            return 0.0;
        }

        int size = this.list.size();
        double totalSum = 0.0;

        if (size < this.window) {
            for (Number value : this.list) {
                totalSum = totalSum + value.doubleValue();
            }
            return totalSum / size;
        }

        for (int i = size - 1; i >= size - this.window; i--) {
            totalSum = totalSum + list.get(i).doubleValue();
        }
        return totalSum / this.window;
    }

    @Override
    public void addElement(Number element) {
        if (element != null) {
            this.list.add(element);
        }
    }

    @Override
    public List<Number> getElements() {
        return this.list;
    }

    @Override
    public void clearList() {
        this.list = new ArrayList<>();
    }

    @Override
    public void updateWindowSizeWith(int windowSize) {
        this.window = windowSize;
    }

}
