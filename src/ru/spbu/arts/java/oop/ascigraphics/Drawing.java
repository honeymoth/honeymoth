package ru.spbu.arts.java.oop.ascigraphics;

public class Drawing {
    char[][] canvas;

    public Drawing(int x, int y, char s) {
        this.canvas = new char[y][x];
        for (int i = 0; i != y; ++i) {
            for (int j = 0; j != x; ++j) {
                this.canvas[i][j] = s;
            }
        }
    }

    void print() {
        for (int i = 0; i != canvas.length; i++) {
            for (int j = 0; j != canvas[i].length; ++j) {
                System.out.print(this.canvas[i][j]);
            }
            System.out.println();
        }
    }

    void setPoint(int x, int y, char c) {
        this.canvas[y][x] = c;
    }

    void drawHorizontalLine(int x1, int x2, int y, char c) {
        if (x1 > x2) {
            for (int j = x2; j != x1 + 1; ++j) {
                this.canvas[y][j] = c;
            }
        } else {
            for (int j = x1; j != x2 + 1; ++j) {
                this.canvas[y][j] = c;
            }
        }

    }

    void drawVerticalLine(int y1, int y2, int x, char c) {
        if (y1 > y2) {
            for (int i = y2; i != y1 + 1; ++i) {
                this.canvas[i][x] = c;
            }
        } else {
            for (int i = y1; i != y2 + 1; ++i) {
                this.canvas[i][x] = c;
            }
        }

    }

    void drawRectangle(int x1, int y1, int x2, int y2, char c) {
        drawHorizontalLine(x1, x2, y1, c);
        drawHorizontalLine(x1, x2, y2, c);
        drawVerticalLine(y1, y2, x1, c);
        drawVerticalLine(y1, y2, x2, c);
    }

    void drawCircle(int x, int y, int r, char c) {
        for (int i = 0; i != canvas.length; ++i) {
            for (int j = 0; j != canvas[i].length; ++j) {
                int check = (j - x) * (j - x) + (i - y) * (i - y);
                if (check <= r * r && check > (r - 1) * (r - 1)) {
                    this.canvas[i][j] = c;
                }
            }
        }
    }

    void drawFilledCircle(int x, int y, int r, char c) {
        for (int i = 0; i != canvas.length; ++i) {
            for (int j = 0; j != canvas[i].length; ++j) {
                int check = (j - x) * (j - x) + (i - y) * (i - y);
                if (check <= r * r) {
                    this.canvas[i][j] = c;
                }
            }
        }
    }

    void draw(int x, int y, char[][] drawing) {
        int len = Math.min(canvas[0].length, drawing[0].length);
        int wid = Math.min(canvas.length, drawing.length);
        for (int i = 0; i != wid - 1; ++i) {
            for (int j = 0; j != len - 1; ++j) {
                this.canvas[i + y][j + x] = drawing[i][j];
            }
        }
    }

    //void drawLine(int x1, int y1, int x2, int y2, char c) {
    //int end_x = Math.max(x1, x2);
    //int end_y = Math.max(y1, y2);
    //int beg_x = Math.min(x1, x2);
    //int beg_y = Math.min(y1, y2);
    //for (int i = beg_y; i != end_y; ++i) {
    //for (int j = beg_x; j != end_x; ++j) {
    //int check = (j - x1) / (x2 - x1);
    //if (check == (i - y1) / (y2 - y1)) {
    // this.canvas[i][j] = c;
    //}
    //}
    // }
    //}
}
