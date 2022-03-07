package tda;

import java.util.ArrayList;

public class Matriz<T> extends ArrayList<ArrayList<T>> implements IMatriz<T> {
    private int rows;
    private int columns;

    public Matriz(int rows) {
        super(rows);
        this.rows = rows;
        this.columns = rows;

        for (int i = 0; i < rows; i++) {
            ArrayList<T> fila = new ArrayList<T>();
            for (int j = 0; j < columns; j++) {
                fila.add(null);
            }
            this.add(fila);
        }
    }

    @Override
    public T get(int row, int col) {
        return this.get(row).get(col);
    }

    @Override
    public void set(int row, int col, T value) {
        this.get(row).set(col, value);
    }

    @Override
    public int getRows() {
        return this.rows;
    }

    @Override
    public int getCols() {
        return this.columns;
    }

    @Override
    public void addRows(int numberOfRows) {
        for (int i = 0; i < numberOfRows; i++) {
            ArrayList<T> fila = new ArrayList<T>();
            for (int j = 0; j < columns; j++) {
                fila.add(null);
            }
            this.add(fila);
        }
        this.rows += numberOfRows;

    }

    @Override
    public void addCols(int numberOfCols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < numberOfCols; j++) {
                this.get(i).add(null);
            }
        }
        this.columns += numberOfCols;
    }

    @Override
    public void removeRows(int numberOfRows) {
        for (int i = 0; i < numberOfRows; i++) {
            this.remove(this.size() - 1);
            //this.remove(0);
        }
        this.rows -= numberOfRows;
    }

    @Override
    public void removeCols(int numberOfCols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < numberOfCols; j++) {
                this.get(i).remove(this.get(i).size() - 1);
                // this.get(i).remove(0);
            }
        }
        this.columns -= numberOfCols;

    }

    @Override
    public void clear() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.set(i, j, null);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (this.get(i, j) != null) {
                    sb.append("[").append(this.get(i, j)).append("]");
                } else {
                    sb.append("[ ]");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
