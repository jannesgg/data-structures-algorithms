import java.io.PrintStream;

public class TestSinglyLinkedList {
  public TestSinglyLinkedList() {}
  
  private static boolean checkInsert1() {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n inspect result of s.size()\n";
    
    int j = 1;
    int i;
    try { SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      i = localSinglyLinkedList.size();
    } catch (Exception|StackOverflowError localException) {
      failedS(str, j);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (i != j) {
      failedS(str, j);
      System.out.println("Actual answer: " + i);
      return false;
    }
    
    return true;
  }
  
  private static boolean checkInsert2()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n inspect result of s.get(0)\n";
    



    int j = 2;
    int i;
    try { SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      i = ((Integer)localSinglyLinkedList.get(0)).intValue();
    } catch (Exception|StackOverflowError localException) {
      failedS(str, j);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (i != j) {
      failedS(str, j);
      System.out.println("Actual answer: " + i);
      return false;
    }
    
    return true;
  }
  
  private static boolean checkInsert3()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n inspect result of s.get(i) for 0 <= i < 2\n";
    



    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = { 2, 5 };
    try {
      SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      for (int i = 0; i < 2; i++) arrayOfInt1[i] = ((Integer)localSinglyLinkedList.get(i)).intValue();
    } catch (Exception|StackOverflowError localException) {
      failedSA(str, arrayOfInt2);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (!java.util.Arrays.equals(arrayOfInt1, arrayOfInt2)) {
      failedSA(str, arrayOfInt2);
      System.out.println("Actual answer: " + show(arrayOfInt1));
      return false;
    }
    
    return true;
  }
  
  private static boolean checkInsert4()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(0, 5);\n inspect result of s.get(i) for 0 <= i < 2\n";
    



    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = { 5, 2 };
    try {
      SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(0, Integer.valueOf(5));
      for (int i = 0; i < 2; i++) arrayOfInt1[i] = ((Integer)localSinglyLinkedList.get(i)).intValue();
    } catch (Exception|StackOverflowError localException) {
      failedSA(str, arrayOfInt2);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (!java.util.Arrays.equals(arrayOfInt1, arrayOfInt2)) {
      failedSA(str, arrayOfInt2);
      System.out.println("Actual answer: " + show(arrayOfInt1));
      return false;
    }
    
    return true;
  }
  
  private static boolean checkRemove1()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n s.removeAt(0);\n inspect result of s.size()\n";
    





    int j = 1;
    int i;
    try { SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      localSinglyLinkedList.removeAt(0);
      i = localSinglyLinkedList.size();
    } catch (Exception|StackOverflowError localException) {
      failedS(str, j);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (i != j) {
      failedS(str, j);
      System.out.println("Actual answer: " + i);
      return false;
    }
    
    return true;
  }
  
  private static boolean checkRemove2()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n s.removeAt(0);\n inspect result of s.get(i) for 0 <= i < 1\n";
    




    int[] arrayOfInt1 = new int[1];
    int[] arrayOfInt2 = { 5 };
    try {
      SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      localSinglyLinkedList.removeAt(0);
      for (int i = 0; i < 1; i++) arrayOfInt1[i] = ((Integer)localSinglyLinkedList.get(i)).intValue();
    } catch (Exception|StackOverflowError localException) {
      failedSA(str, arrayOfInt2);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (!java.util.Arrays.equals(arrayOfInt1, arrayOfInt2)) {
      failedSA(str, arrayOfInt2);
      System.out.println("Actual answer: " + show(arrayOfInt1));
      return false;
    }
    
    return true;
  }
  
  private static boolean checkRemove3()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n s.removeAt(1);\n inspect result of s.get(i) for 0 <= i < 1\n";
    




    int[] arrayOfInt1 = new int[1];
    int[] arrayOfInt2 = { 2 };
    try {
      SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      localSinglyLinkedList.removeAt(1);
      for (int i = 0; i < 1; i++) arrayOfInt1[i] = ((Integer)localSinglyLinkedList.get(i)).intValue();
    } catch (Exception|StackOverflowError localException) {
      failedSA(str, arrayOfInt2);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (!java.util.Arrays.equals(arrayOfInt1, arrayOfInt2)) {
      failedSA(str, arrayOfInt2);
      System.out.println("Actual answer: " + show(arrayOfInt1));
      return false;
    }
    
    return true;
  }
  
  private static boolean checkReverse1()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n s.reverse();\n inspect result of s.get(i) for 0 <= i < 2\n";
    




    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = { 5, 2 };
    try {
      SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      localSinglyLinkedList.reverse();
      for (int i = 0; i < 2; i++) arrayOfInt1[i] = ((Integer)localSinglyLinkedList.get(i)).intValue();
    } catch (Exception|StackOverflowError localException) {
      failedSA(str, arrayOfInt2);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (!java.util.Arrays.equals(arrayOfInt1, arrayOfInt2)) {
      failedSA(str, arrayOfInt2);
      System.out.println("Actual answer: " + show(arrayOfInt1));
      return false;
    }
    
    return true;
  }
  
  private static boolean checkReverse2()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n s.insertAt(2, 3);\n s.reverse();\n inspect result of s.get(i) for 0 <= i < 2\n";
    





    int[] arrayOfInt1 = new int[3];
    int[] arrayOfInt2 = { 3, 5, 2 };
    try {
      SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      localSinglyLinkedList.insertAt(2, Integer.valueOf(3));
      localSinglyLinkedList.reverse();
      for (int i = 0; i < 3; i++) arrayOfInt1[i] = ((Integer)localSinglyLinkedList.get(i)).intValue();
    } catch (Exception|StackOverflowError localException) {
      failedSA(str, arrayOfInt2);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (!java.util.Arrays.equals(arrayOfInt1, arrayOfInt2)) {
      failedSA(str, arrayOfInt2);
      System.out.println("Actual answer: " + show(arrayOfInt1));
      return false;
    }
    
    return true;
  }
  
  private static boolean checkIter1()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n SinglyLinkedList.Iterator<Integer> it = s.first();\n inspect result of it.next()\n";

    int j = 2;
    int i;
    try { SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      SinglyLinkedList.Iterator localIterator = localSinglyLinkedList.first();
      i = ((Integer)localIterator.next()).intValue();
    } catch (Exception|StackOverflowError localException) {
      failedS(str, j);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (i != j) {
      failedS(str, j);
      System.out.println("Actual answer: " + i);
      return false;
    }
    
    return true;
  }
  
  private static boolean checkIter2()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n SinglyLinkedList.Iterator<Integer> it = s.first();\n it.next();\n inspect result of it.next()\n";
    
    int j = 5;
    int i;
    try { SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      SinglyLinkedList.Iterator localIterator = localSinglyLinkedList.first();
      localIterator.next();
      i = ((Integer)localIterator.next()).intValue();
    } catch (Exception|StackOverflowError localException) {
      failedS(str, j);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (i != j) {
      failedS(str, j);
      System.out.println("Actual answer: " + i);
      return false;
    }
    
    return true;
  }
  
  private static boolean checkIter3()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n SinglyLinkedList.Iterator<Integer> i = s.first();\n i.next();\n inspect result of i.hasNext()\n";
    






    boolean bool2 = true;
    boolean bool1;
    try { SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      SinglyLinkedList.Iterator localIterator = localSinglyLinkedList.first();
      localIterator.next();
      bool1 = localIterator.hasNext();
    } catch (Exception|StackOverflowError localException) {
      failedSB(str, bool2);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (bool1 != bool2) {
      failedSB(str, bool2);
      System.out.println("Actual answer: " + bool1);
      return false;
    }
    
    return true;
  }
  
  private static boolean checkIter4()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n SinglyLinkedList.Iterator<Integer> it = s.first();\n it.next();\n it.next();\n inspect result of it.hasNext()\n";
    







    boolean bool2 = false;
    boolean bool1;
    try { SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      SinglyLinkedList.Iterator localIterator = localSinglyLinkedList.first();
      localIterator.next();
      localIterator.next();
      bool1 = localIterator.hasNext();
    } catch (Exception|StackOverflowError localException) {
      failedSB(str, bool2);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (bool1 != bool2) {
      failedSB(str, bool2);
      System.out.println("Actual answer: " + bool1);
      return false;
    }
    
    return true;
  }
  
  private static boolean checkIter5()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n SinglyLinkedList.Iterator<Integer> it = s.first();\n it.insert(3);\n inspect result of s.size()\n";
    






    int j = 3;
    int i;
    try { SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      SinglyLinkedList.Iterator localIterator = localSinglyLinkedList.first();
      localIterator.insert(Integer.valueOf(3));
      i = localSinglyLinkedList.size();
    } catch (Exception|StackOverflowError localException) {
      failedS(str, j);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (i != j) {
      failedS(str, j);
      System.out.println("Actual answer: " + i);
      return false;
    }
    
    return true;
  }
  
  private static boolean checkIter6()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n SinglyLinkedList.Iterator<Integer> it = s.first();\n it.insert(3);\n inspect result of s.get(i) for 0 <= i < 3\n";
    





    int[] arrayOfInt1 = new int[3];
    int[] arrayOfInt2 = { 3, 2, 5 };
    try {
      SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      SinglyLinkedList.Iterator localIterator = localSinglyLinkedList.first();
      localIterator.insert(Integer.valueOf(3));
      for (int i = 0; i < 3; i++) arrayOfInt1[i] = ((Integer)localSinglyLinkedList.get(i)).intValue();
    } catch (Exception|StackOverflowError localException) {
      failedSA(str, arrayOfInt2);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (!java.util.Arrays.equals(arrayOfInt1, arrayOfInt2)) {
      failedSA(str, arrayOfInt2);
      System.out.println("Actual answer: " + show(arrayOfInt1));
      return false;
    }
    
    return true;
  }
  
  private static boolean checkIter7()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n SinglyLinkedList.Iterator<Integer> it = s.first();\n it.next();\n it.insert(3);\n inspect result of s.get(i) for 0 <= i < 3\n";
    






    int[] arrayOfInt1 = new int[3];
    int[] arrayOfInt2 = { 2, 3, 5 };
    try {
      SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      SinglyLinkedList.Iterator localIterator = localSinglyLinkedList.first();
      localIterator.next();
      localIterator.insert(Integer.valueOf(3));
      for (int i = 0; i < 3; i++) arrayOfInt1[i] = ((Integer)localSinglyLinkedList.get(i)).intValue();
    } catch (Exception|StackOverflowError localException) {
      failedSA(str, arrayOfInt2);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (!java.util.Arrays.equals(arrayOfInt1, arrayOfInt2)) {
      failedSA(str, arrayOfInt2);
      System.out.println("Actual answer: " + show(arrayOfInt1));
      return false;
    }
    
    return true;
  }
  
  private static boolean checkIter8()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n SinglyLinkedList.Iterator<Integer> it = s.first();\n it.next();\n it.next();\n it.insert(3);\n inspect result of s.get(i) for 0 <= i < 3\n";
    







    int[] arrayOfInt1 = new int[3];
    int[] arrayOfInt2 = { 2, 5, 3 };
    try {
      SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      SinglyLinkedList.Iterator localIterator = localSinglyLinkedList.first();
      localIterator.next();
      localIterator.next();
      localIterator.insert(Integer.valueOf(3));
      for (int i = 0; i < 3; i++) arrayOfInt1[i] = ((Integer)localSinglyLinkedList.get(i)).intValue();
    } catch (Exception|StackOverflowError localException) {
      failedSA(str, arrayOfInt2);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (!java.util.Arrays.equals(arrayOfInt1, arrayOfInt2)) {
      failedSA(str, arrayOfInt2);
      System.out.println("Actual answer: " + show(arrayOfInt1));
      return false;
    }
    
    return true;
  }
  
  private static boolean checkIter9()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n SinglyLinkedList.Iterator<Integer> it = s.first();\n it.next();\n it.remove();\n inspect result of s.size()\n";
    







    int j = 1;
    int i;
    try { SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      SinglyLinkedList.Iterator localIterator = localSinglyLinkedList.first();
      localIterator.next();
      localIterator.remove();
      i = localSinglyLinkedList.size();
    } catch (Exception|StackOverflowError localException) {
      failedS(str, j);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (i != j) {
      failedS(str, j);
      System.out.println("Actual answer: " + i);
      return false;
    }
    
    return true;
  }
  
  private static boolean checkIter10()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n SinglyLinkedList.Iterator<Integer> it = s.first();\n it.next();\n it.remove();\n inspect result of s.get(i) for 0 <= i < 1\n";
    






    int[] arrayOfInt1 = new int[1];
    int[] arrayOfInt2 = { 5 };
    try {
      SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      SinglyLinkedList.Iterator localIterator = localSinglyLinkedList.first();
      localIterator.next();
      localIterator.remove();
      for (int i = 0; i < 1; i++) arrayOfInt1[i] = ((Integer)localSinglyLinkedList.get(i)).intValue();
    } catch (Exception|StackOverflowError localException) {
      failedSA(str, arrayOfInt2);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (!java.util.Arrays.equals(arrayOfInt1, arrayOfInt2)) {
      failedSA(str, arrayOfInt2);
      System.out.println("Actual answer: " + show(arrayOfInt1));
      return false;
    }
    
    return true;
  }
  
  private static boolean checkIter11()
  {
    String str = " SinglyLinkedList<Integer> s new SinglyLinkedList<Integer>();\n s.insertAt(0, 2);\n s.insertAt(1, 5);\n SinglyLinkedList.Iterator<Integer> it = s.first();\n it.next();\n it.next();\n it.remove();\n inspect result of s.get(i) for 0 <= i < 1\n";
    







    int[] arrayOfInt1 = new int[1];
    int[] arrayOfInt2 = { 2 };
    try {
      SinglyLinkedList localSinglyLinkedList = new SinglyLinkedList();
      localSinglyLinkedList.insertAt(0, Integer.valueOf(2));
      localSinglyLinkedList.insertAt(1, Integer.valueOf(5));
      SinglyLinkedList.Iterator localIterator = localSinglyLinkedList.first();
      localIterator.next();
      localIterator.next();
      localIterator.remove();
      for (int i = 0; i < 1; i++) arrayOfInt1[i] = ((Integer)localSinglyLinkedList.get(i)).intValue();
    } catch (Exception|StackOverflowError localException) {
      failedSA(str, arrayOfInt2);
      System.out.println("Threw exception:");
      localException.printStackTrace(System.out);
      return false;
    }
    
    if (!java.util.Arrays.equals(arrayOfInt1, arrayOfInt2)) {
      failedSA(str, arrayOfInt2);
      System.out.println("Actual answer: " + show(arrayOfInt1));
      return false;
    }
    
    return true;
  }
  
  private static void failed(int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
    System.out.println("Failed!");
    System.out.println("Input array: " + show(paramArrayOfInt1));
    System.out.println("Expected answer: " + show(paramArrayOfInt2));
  }
  
  private static void failedS(String paramString, int paramInt) {
    System.out.println("Failed!");
    System.out.println("Test case:\n" + paramString);
    System.out.println("Expected answer: " + paramInt);
  }
  
  private static void failedSA(String paramString, int[] paramArrayOfInt) {
    System.out.println("Failed!");
    System.out.println("Test case:\n" + paramString);
    System.out.println("Expected answer: " + show(paramArrayOfInt));
  }
  
  private static void failedSB(String paramString, boolean paramBoolean) {
    System.out.println("Failed!");
    System.out.println("Test case:\n" + paramString);
    System.out.println("Expected answer: " + paramBoolean);
  }
  
  private static void failedSim(int[] paramArrayOfInt1, int[] paramArrayOfInt2) {
    System.out.println("Failed!");
    System.out.println("Input array: " + show(paramArrayOfInt1));
    System.out.println("Expected answer: " + show(paramArrayOfInt2) + " (or similar)");
  }
  
  private static void failedInt(int[] paramArrayOfInt, int paramInt) {
    System.out.println("Failed!");
    System.out.println("Input array: " + show(paramArrayOfInt));
    System.out.println("Expected answer: " + paramInt);
  }
  
  private static String show(int[] paramArrayOfInt) {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    if (paramArrayOfInt.length > 0) localStringBuilder.append(paramArrayOfInt[0]);
    for (int i = 1; i < paramArrayOfInt.length; i++) {
      localStringBuilder.append(", ");
      localStringBuilder.append(paramArrayOfInt[i]);
    }
    localStringBuilder.append("}");
    
    return localStringBuilder.toString();
  }
  
  public static void main(String[] paramArrayOfString) {
    System.out.printf("Note: Most test cases require correct implementation of get().\n", new Object[0]);
    System.out.printf("Testing insertAt()...\n", new Object[0]);
    for (int i = 0; i < 1; i++) {
      System.out.printf(" Test case 1...\n", new Object[0]);
      if (!checkInsert1()) break;
      System.out.printf(" Test case 2...\n", new Object[0]);
      if (!checkInsert2()) break;
      System.out.printf(" Test case 3...\n", new Object[0]);
      if (!checkInsert3()) break;
      System.out.printf(" Test case 4...\n", new Object[0]);
      if (!checkInsert4()) break;
    }
    System.out.printf("Testing removeAt()...\n", new Object[0]);
    for (int i = 0; i < 1; i++) {
      System.out.printf(" Test case 1...\n", new Object[0]);
      if (!checkRemove1()) break;
      System.out.printf(" Test case 2...\n", new Object[0]);
      if (!checkRemove2()) break;
      System.out.printf(" Test case 3...\n", new Object[0]);
      if (!checkRemove3()) break;
    }
    System.out.printf("Testing reverse()...\n", new Object[0]);
    for (int i = 0; i < 1; i++) {
      System.out.printf(" Test case 1...\n", new Object[0]);
      if (!checkReverse1()) break;
      System.out.printf(" Test case 2...\n", new Object[0]);
      if (!checkReverse2()) break;
    }
    System.out.printf("Testing iterators...\n", new Object[0]);
    for (int i = 0; i < 1; i++) {
      System.out.printf(" Test case 1...\n", new Object[0]);
      if (!checkIter1()) break;
      System.out.printf(" Test case 2...\n", new Object[0]);
      if (!checkIter2()) break;
      System.out.printf(" Test case 3...\n", new Object[0]);
      if (!checkIter3()) break;
      System.out.printf(" Test case 4...\n", new Object[0]);
      if (!checkIter4()) break;
      System.out.printf(" Test case 5...\n", new Object[0]);
      if (!checkIter5()) break;
      System.out.printf(" Test case 6...\n", new Object[0]);
      if (!checkIter6()) break;
      System.out.printf(" Test case 7...\n", new Object[0]);
      if (!checkIter7()) break;
      System.out.printf(" Test case 8...\n", new Object[0]);
      if (!checkIter8()) break;
      System.out.printf(" Test case 9...\n", new Object[0]);
      if (!checkIter9()) break;
      System.out.printf(" Test case 10...\n", new Object[0]);
      if (!checkIter10()) break;
      System.out.printf(" Test case 11...\n", new Object[0]);
      if (!checkIter11()) {
        break;
      }
    }
  }
}
