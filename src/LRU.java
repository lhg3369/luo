

import java.util.ArrayList;
import java.util.List;

/**
 * 最近最久未用置换算法
 * @author cnkeysky
 *
 */

public class LRU {

    public static void main(String[] args) {
        String[] inputStr = {"7", "0", "1", "2", "0", "3", "4", "2", "3", "0", "3",
        		"2","1","2","0","1","7","0","1"};
        // 内存块
        int memory = 3;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < inputStr.length; i++){
            if(i == 0){
                list.add(inputStr[i]);
                System.out.println("第"+ i +"次访问：\t\t" + listToString(list));
            }else {
                if(find(list, inputStr[i])){
                    // 存在字符串，则获取该下标
                    int index = findIndex(list, inputStr[i]);
                    // 下标不位于栈顶时，且list大小不为1时
                    if(!(list.get(list.size() - 1)).equals(inputStr[i]) && list.size() != 1) {
                        String str = list.get(index);
                        list.remove(index);
                        list.add(str);
                    }
                    System.out.println("第" + i + "次" + "访问：\t\t" + listToString(list));
                }else{
                    if(list.size()>= memory) {
                        list.remove(0);
                        list.add(inputStr[i]);
                        System.out.println("第" + i + "次" + "访问：\t\t" + listToString(list));
                    }else {
                        list.add(inputStr[i]);
                        System.out.println("第" + i + "次" + "访问：\t\t" + listToString(list));
                    }
                }
            }
        }
    }
    public static String listToString(List list){

        StringBuffer content = new StringBuffer();
        for(int i = 0; i < list.size(); i++){
            content.append(list.get(i));
            if(i < list.size() - 1){
                content.append(",");
            }
        }
        return content.toString();
    }

    /**
     * 在list中查找是否有str
     * @param list
     * @param str
     * @return
     */
    public static boolean find(List<String> list, String str){
        boolean flag = false;
        for(String lis : list){
            if(lis.equals(str)){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 在List中查找是否有String,如果有返回下标, 否则返回 -1
     * @param list
     * @param str
     * @return
     */
    public static int findIndex(List<String> list, String str) {

        int index = 0;
        for(String lis : list) {
            if(lis.equals(str)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static boolean clockJudge(String[] clock, int index) {
        if(clock[index].equals("0")) {
            return true;
        }
        return false;
    }
    /**
     * 
     * @param index 下标
     * @param clock 时钟
     * @param range 当前使用内存块
     * @return
     */
    public static int findZero(int index, String[] clock, int range) {

        while(true) {

            if(clock[index].equals("0")) {
                break;
            }else {
                clock[index] = "0";
                index++;
                if(index > range-1) {
                    index = Math.abs(range - index);
                }
            }
        }
        return index;
    }

    /**
     * 在数组中查找是否存在该字符串
     * @param obj
     * @param str
     * @return
     */
    public static boolean strJudge(Object[] obj, String str) {
        boolean flag = false;
        if(obj == null) {
            return flag;
        }
        for(int i = 0; i < obj.length; i++) {
            if(str.equals(obj[i])) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 获取二维数组中同一列的行的长度
     * @param str 数据
     * @param length 二维数组的列
     * @param memory 内存块
     * @return
     * 
     */

    public static int findNull(Object[][] str, int length, int memory) {

        int index = 0;
        if(str == null) {
            return -1;
        }
        for(int i = 0; i < memory; i++) {
            if(str[i][length] != null) {
                index = i;
            }
        }
        return index;
    }
}

