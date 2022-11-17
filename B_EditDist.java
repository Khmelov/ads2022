package by.it.group151004.buhovets.lesson07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Задача на программирование: расстояние Левенштейна
    https://ru.wikipedia.org/wiki/Расстояние_Левенштейна
    http://planetcalc.ru/1721/

Дано:
    Две данных непустые строки длины не более 100, содержащие строчные буквы латинского алфавита.

Необходимо:
    Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ
    Итерационно вычислить расстояние редактирования двух данных непустых строк

    Sample Input 1:
    ab
    ab
    Sample Output 1:
    0

    Sample Input 2:
    short
    ports
    Sample Output 2:
    3

    Sample Input 3:
    distance
    editing
    Sample Output 3:
    5

*/

public class B_EditDist {
    int getDistanceEdinting(String word_a, String word_b) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        int m=word_a.length(), n=word_b.length();
        int[][] cell = new int[m+1][n+1];
        for(int i=0; i<m+1;i++){
            cell[i][0]=i;
        }
        for(int j=1; j<n+1;j++){
            cell[0][j]=j;
        }

        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1;j++){
                cell[i][j]=min(cell[i][j-1]+1,cell[i-1][j]+1,cell[i-1][j-1]+mCount(word_a.charAt(i-1),word_b.charAt(j-1)));
            }
        }

        //printMatrix(cell, m+1,n+1);

        int result=cell[m][n];
        return result;
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!

    }
    private static int min(int a,int b, int c){
        return Math.min(Math.min(a,b),c);
    }

    private static int mCount(char a, char b){
        return a==b ? 0 :1;
    }

    public void printMatrix(int[][] a, int m, int n){
        for(int i=0; i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }



    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group151004/buhovets/lesson07/dataABC.txt");
        B_EditDist instance = new B_EditDist();
        Scanner scanner = new Scanner(stream);
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
    }

}