package week6;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.max;

/**
 * Dynamic Programming LCS
 */
public class DP_LCS {
    private String _x, _y;
    private int _lenX, _lenY;
    private int[][] _lcs;
    private ArrayList<String> _allLcs;

//    public DP_LCS(String _x, String _y) {
//        this._x = _x;
//        this._y = _y;
//        _lenX = _x.length();
//        _lenY = _y.length();
//        _lcs = new int[_lenY][_lenX];
//        initArr();
//    }

    /**
     * set 2 strings to execute the LCS algo on them
     *
     * @param x
     * @param y
     */
    public void setStrings(String x, String y) {
        _x = x;
        _y = y;
        _lenX = _x.length();
        _lenY = _y.length();
        _lcs = new int[_lenY][_lenX];
        initArr();
    }

    /**
     * init the matrix for the algo inner used
     */
    private void initArr() {
        int counter = 0;
        for (int i = 0; i < _lcs[0].length; i++) {
            if (_x.charAt(i) == _y.charAt(0)) counter = 1;
            _lcs[0][i] = counter;
        }
        counter = 0;
        for (int i = 0; i < _lcs.length; i++) {
            if (_x.charAt(0) == _y.charAt(i)) counter = 1;
            _lcs[i][0] = counter;
        }
        for (int i = 1; i < _lenY; i++) {
            for (int j = 1; j < _lenX; j++) {
                if (_x.charAt(j) != _y.charAt(i)) _lcs[i][j] = max(_lcs[i - 1][j], _lcs[i][j - 1]);
                else _lcs[i][j] = _lcs[i - 1][j - 1] + 1;
            }
        }
    }

    public int length() {
        return _lcs[_lenY - 1][_lenX - 1];
    }

    /**
     * get one of the LCS strings
     * @return
     */
    public String getOneOf() {
        int i = _lenY - 1, j = _lenX - 1;
        String res = "";
        while (i >= 0 && j >= 0) {
            if (_x.charAt(j) == _y.charAt(i)) {
                res = _y.charAt(i) + res;
                i--;
                j--;
            } else {
                i--;
            }
        }
        return res;
    }

    /**
     * get all of the LCS possible strings
     * @return
     */
    public ArrayList<String> getAllOf() {
        int i = _lenY - 1, j = _lenX - 1;
        _allLcs = new ArrayList<>();
        getAllOf(i, j, "");
        return _allLcs;
    }

    public void getAllOf(int i, int j, String w) {
        if (i < 0 || j < 0) {
            if (w.length() > 0)
                _allLcs.add(w);
            return;
        }
        if (_x.charAt(j) != _y.charAt(i)) {
            getAllOf(--i, j, w);
            getAllOf(i, --j, w);
        } else {
            w = _y.charAt(i) + w;
            getAllOf(--i, --j, w);
        }
    }

    public int amountOfAllOf() {
        getAllOf();
        return _allLcs.size();
    }

    public void printArr(int[][] a) {
        for (int[] ints : a) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
