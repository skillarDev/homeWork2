public class Main {
    public static void main(String[] args) {
        // Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("Исходный массив: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(+arr1[i]+" ");
        }
        System.out.print("\nМассив после замены: ");
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] == 0) {
                arr1[i] = 1;
            } else {
                arr1[i] = 0;
            }
            System.out.print(arr1[i]+" ");
        }


        //Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] arr2 = new int[8];
        String result = "";
        for (int i = 1; i < arr2.length; i++) {
            arr2[i] = arr2[i - 1] + 3;
            result += arr2[i]+" ";
        }
        System.out.println(arr2[0]+" "+result);


        // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr3.length; i++) {
            if(arr3[i] < 6){
                arr3[i] *= 2;
            }
            System.out.print(arr3[i]+" ");
        }


        // Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] arr4 = new int[4][4];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                if((i == 0 || i == 3) && (j == 0 || j == 3)){
                    arr4[i][j] = 1;
                }
                if((i == 1 || i == 2) && (j == 1 || j == 2)){
                    arr4[i][j] = 1;
                }
                System.out.print(arr4[i][j]);
            }
            System.out.println();
        }


        //** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] arr5 = {13, 5, 3, 2, 17, 4, 5, 2, 4, 8, 9, 1};
        int min = arr5[0];
        int max = arr5[0];
        for (int i = 1; i < arr5.length; i++) {
            if(arr5[i] < min){
                min = arr5[i];
            }
            if(arr5[i] > max){
                max = arr5[i];
            }
        }
        System.out.println("Минимальное значение: "+min);
        System.out.println("Максимальное значение: "+max);


        //** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        // если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        // граница показана символами ||, эти символы в массив не входят.
        // 2, 2, 2, 1, 2, 2, 10, 1 | 1, 1, 1, 2, 1 |

        boolean a = compareSum(new int[]{2, 2, 2, 1, 2, 2, 10, 1});
        System.out.println(a);


        //**** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        // при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        // Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
        // При каком n в какую сторону сдвиг можете выбирать сами.

        String b = arrRep(new int[]{3, 5, 6, 1, 8}, 0);
        System.out.println(b);

    }

    public static String arrRep(int[] arr8, int n) {
        String result = "";
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                int a = arr8[arr8.length - 1];
                for (int j = arr8.length - 1; j >= 0; j--) {

                    if (j == 0) {
                        arr8[j] = a;
                    } else {
                        arr8[j] = arr8[j - 1];
                    }
                }
            }
        } else {
            for (int i = 0; i < Math.abs(n); i++) {
                int a = arr8[0];
                for (int j = 0; j < arr8.length; j++) {

                    if (j == arr8.length - 1) {
                        arr8[j] = a;
                    } else {
                        arr8[j] = arr8[j + 1];
                    }
                }
            }
        }
        for (int i = 0; i < arr8.length; i++) {
            result += arr8[i]+" ";
        }
        return result;
    }

    public static boolean compareSum(int[] arr6){
        boolean result = false;
        int sumI = arr6[0];
        int sumJ = arr6[arr6.length - 1];
        int[][] arr7 = new int[2][arr6.length - 3];
        for (int i = 1, j = arr6.length - 2, k = 0, l = arr6.length - 4; k < arr6.length - 3; i++, k++, j--, l--) {
            sumI += arr6[i];
            sumJ += arr6[j];
            arr7[0][k] += sumI;
            arr7[1][l] += sumJ;
        }

        for (int i = 0; i < arr7[0].length; i++) {
                if(arr7[0][i] == arr7[1][i]){
                    result= true;
                    break;
                }
        }
        return result;
    }

}

