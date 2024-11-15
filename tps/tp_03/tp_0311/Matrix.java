import java.util.Scanner;

class Cel {
    public int el;
    public Cel left;
    public Cel right;
    public Cel up;
    public Cel down;

    Cel() {
        this.el = 0;
        this.left = this.right = this.up = this.down = null;
    }
}

public class Matrix {
    public Cel start;
    public int rows;
    public int columns;

    Matrix() {
        start = createRow();
        Cel next = createRow();

        for (Cel i = start, tmp = next; i != null; i = i.right) {
            i.down = tmp;
            tmp.up = i;

            tmp = tmp.right;
        }
        rows = 2;
        columns = 2;
    }

    Cel createRow() {
        Cel Cel1 = new Cel();
        Cel Cel2 = new Cel();

        Cel1.right = Cel2;
        Cel2.left = Cel1;

        return Cel1;
    }

    Cel createRow(int x) {
        Cel Cel1 = new Cel();
        Cel tmp = Cel1;

        for (int j = 0; j < x - 1; j++) {
            Cel newCel = new Cel();
            tmp.right = newCel;
            newCel.left = tmp;
            tmp = newCel;
        }

        return Cel1;
    }

    Cel createColumn(int x) {
        Cel Cel1 = new Cel();
        Cel tmp = Cel1;

        for (int j = 0; j < x - 1; j++) {
            Cel newCel = new Cel();
            tmp.down = newCel;
            newCel.up = tmp;

            tmp = newCel;
        }

        return Cel1;
    }

    void addRow() {
        Cel current;
        for (current = start; current.down != null; current = current.down)
            ;

        for (Cel newRow = createRow(columns); newRow != null; newRow = newRow.right) {
            current.down = newRow;
            newRow.up = current;

            current = current.right;
        }
        rows++;
    }

    void addColumn() {
        Cel current;
        for (current = start; current.right != null; current = current.right)
            ;

        for (Cel newColumn = createColumn(rows); newColumn != null; newColumn = newColumn.down) {
            current.right = newColumn;
            newColumn.left = current;

            current = current.down;
        }

        columns++;
    }

    void insertElement(int el, int rowPosition, int colPosition) {
        if (rowPosition >= rows || colPosition >= columns || rowPosition < 0 || colPosition < 0) {
            try {
                throw new Exception("Invalid position");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Cel tmp = start;
            for (int i = 0; i < colPosition; i++) {
                tmp = tmp.right;
            }
            for (int i = 0; i < rowPosition; i++) {
                tmp = tmp.down;
            }
            tmp.el = el;
        }
    }

    void diagonalMain() {
        if (columns != rows) {
            try {
                throw new Exception("This matrix doesn't have a main diagonal");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Cel current = start;

            while (current != null) {
                System.out.print(current.el + " ");
                current = current.right;
                if (current != null) {
                    current = current.down;
                }
            }
            System.out.println();
        }
    }

    void diagonalSecondary() {
        if (columns != rows) {
            try {
                throw new Exception("This matrix doesn't have a secondary diagonal");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Cel current = start;

            while (current.right != null) {
                current = current.right;
            }

            while (current != null) {
                System.out.print(current.el + " ");
                current = current.left;
                if (current != null) {
                    current = current.down;
                }
            }
            System.out.println();
        }
    }

    void show() {
        for (Cel i = start; i != null; i = i.down) {
            for (Cel j = i; j != null; j = j.right) {
                System.out.print(j.el + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void multiplication(Matrix mat1, Matrix mat2) {
        if (mat1.columns == mat2.rows) {
            for (Cel row = mat1.start; row != null; row = row.down) {
                for (Cel col = mat2.start; col != null; col = col.right) {
                    int sum = 0;
                    for (Cel elem1 = row, elem2 = col; elem1 != null
                            && elem2 != null; elem1 = elem1.right, elem2 = elem2.down) {
                        sum += (elem1.el * elem2.el);
                    }
                    System.out.print(sum + " ");
                }
                System.out.println();
            }
        }
    }

    public static void sum(Matrix mat1, Matrix mat2) {
        for (Cel row1 = mat1.start, row2 = mat2.start; row1 != null
                && row2 != null; row1 = row1.down, row2 = row2.down) {
            for (Cel col1 = row1, col2 = row2; col1 != null && col2 != null; col1 = col1.right, col2 = col2.right) {
                System.out.print((col1.el + col2.el) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numInstances = sc.nextInt();

        for (int i = 0; i < numInstances; i++) {
            Matrix mat = new Matrix();
            Matrix mat1 = new Matrix();

            int numRows = sc.nextInt();
            int numCols = sc.nextInt();

            for (int j = 0; j < numRows - 2; j++) {
                mat.addRow();
            }
            for (int j = 0; j < numCols - 2; j++) {
                mat.addColumn();
            }

            for (int j = 0; j < numRows; j++) {
                for (int k = 0; k < numCols; k++) {
                    mat.insertElement(sc.nextInt(), j, k);
                }
            }

            numRows = sc.nextInt();
            numCols = sc.nextInt();

            for (int j = 0; j < numRows - 2; j++) {
                mat1.addRow();
            }
            for (int j = 0; j < numCols - 2; j++) {
                mat1.addColumn();
            }

            for (int j = 0; j < numRows; j++) {
                for (int k = 0; k < numCols; k++) {
                    mat1.insertElement(sc.nextInt(), j, k);
                }
            }

            mat.diagonalMain();
            mat.diagonalSecondary();
            sum(mat, mat1);
            multiplication(mat, mat1);
        }
    }
}