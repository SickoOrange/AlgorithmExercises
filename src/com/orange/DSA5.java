package com.orange;

/**
 * 等式变换
 * 输入一个正整数X，在下面的等式左边的数字之间添加+号或者-号，使得等式成立。
 * 1 2 3 4 5 6 7 8 9 = X
 * 比如：
 * 12-34+5-67+89 = 5
 * 1+23+4-5+6-7-8-9 = 5
 * 请编写程序，统计满足输入整数的所有整数个数。
 * 输入： 正整数，等式右边的数字
 * 输出： 使该等式成立的个数
 * 样例输入：5
 * 样例输出：21
 */
public class DSA5 {
    static int count = 0;

  public static void main(String[] args) {
    int[] result = new int[8];

    calculateEqualsCount(result, 0, 5);
    System.out.println(count);
  }

  //result用来存储运算符,0表示无符号，1表示'+',2表示'-'
  public static void calculateEqualsCount(int[] result, int index, int target) {
    if (index == 8) {
      showResult(result, target);
      return;
    } else {
      for (int i = 0; i < 3; i++) {
        result[index] = i;
        calculateEqualsCount(result, index + 1, target);
      }//for
    }
  }

  private static void showResult(int[] result, int target) {

    char oper = '+';
    String[] source = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String num = source[0];
    String exp = "";
    exp = exp + source[0];
    int sum = 0;

    for (int i = 0; i < result.length; i++) {
      switch (result[i]) {
        case 0://无运算符
          num = num + source[i + 1];
          exp = exp + source[i + 1];
          break;
        case 1://'+'
          //计算之前的结果
          sum = calculator(sum, num, oper);
          oper = '+';
          num = source[i + 1];
          exp = exp + '+' + source[i + 1];
          //	sum = calculator(sum, num, oper);
          break;
        case 2:
          sum = calculator(sum, num, oper);
          oper = '-';
          num = source[i + 1];
          exp = exp + '-' + source[i + 1];
          break;
      }
    }
    //最后一个num没有计算
    sum = calculator(sum, num, oper);
    if (sum == target) {
      System.out.println(exp + "=" + target);
      count++;
    }
  }

  private static int calculator(int sum, String num, char oper) {
    if (oper == '+') {
      sum = sum + Integer.parseInt(num);
    } else {
      sum = sum - Integer.parseInt(num);
    }
    return sum;
  }
}
