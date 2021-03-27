import java.util.List;

/**
 * 
 *
 * @param <T>
 */
public interface IMovingAverage<T extends Number> {

    /**
     * Calculates the moving average for window size N and returns the calculated
     * value. <br/>
     * If list is empty or window size is less than zero then returns 0.
     *
     * @return moving average
     */
    Double getMovingAverageOfElements();

    /**
     * Add element to the list of elements.
     *
     * @param element - of type Number
     */
    void addElement(T element);

    /**
     * Returns elements present in the list.
     *
     * @return list of elements
     */
    public List<T> getElements();

    /**
     * Clears elements in the list.
     */
    void clearList();

    /**
     * Update window size.
     * 
     * @param windowSize - with
     */
    void updateWindowSizeWith(int windowSize);

}
