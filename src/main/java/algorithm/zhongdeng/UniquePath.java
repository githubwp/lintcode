package algorithm.zhongdeng;

public class UniquePath {
/*
    描述
    给两个整数代表网格的高和宽，起点为左上角以及终点为右上角。你可以往右上角、右或者右下角走。求你可以到达终点的路径数。结果需要 mod 1000000007.

    width > 1, height > 1

    您在真实的面试中是否遇到过这个题？
    样例
    input:
    height = 3
    width = 3
    output:
            2
   */


    public static int uniquePath(int height, int width) {
        //需要考虑int不要越界
        //计算有多少*3点，*2点

        //可以转换思路为左下角走到右下角

        //先找出有效的height
        int validHeight = (width + 1) / 2;
        validHeight = Math.min(validHeight, height);
        boolean hasTopPoint = (validHeight * 2) == (width + 1);
        double t = 1d;
        for (int y = 0; y < validHeight; y++) {
            if (y == validHeight) {
                if (!hasTopPoint) {
                    t *= Math.pow(2d, (width - (2 * y) - 1));
                }
            } else if (y == 0) {
                t *= Math.pow(2d, width - 2);
            } else {
                t *= Math.pow(3d, (width - (2 * y) - 2));
                t *= 2;
            }
        }
        return (int) (t % 1000000007);

//        //有顶点的height
//        int[][] data = new int[width][height];
//
//        long num = 1L;
////        底边永远2条路径，不包含倒数第二条边和底边的重叠点
//        if (hasTopPoint) {
//            //有顶点的
////            顶点为(height,height)，右边所有点一条路径，右边倒数第二条边各店2条路径，不包含底边
//            //最后一个点不向外发射边
//            for (int x = 0; x < width - 1; x++) {
//                for (int y = 0; y <= Math.min(x, validHeight); y++) {
//                    //找到点的可触发路径数量
//                    int edge = 1;
//                    if (y == 0) {
//                        //底边
//                        num *= 2;
//                    } else {
//                        if (y == validHeight) {
//                            //到顶了
//                            if (!hasTopPoint) {
//                                if () {
//                                    //不是最右边
//                                    num *= 2;
//                                }
//                            }
//                        }
//
//                    }
//                }
//            }
//
//
//        } else {
//            //平头，没有顶点，四边形
//            //上边右边，各点一条路径，倒数右边第二条边各点2条路径，底边重合点1条路径
//
//        }
//        //若width为奇数则可能有顶点
//        // Write your code here
//        return 0;
    }

    public static void main(String[] args) {
        System.out.println(uniquePath(3, 3));
//        System.out.println((int) (Math.pow(2147483647, 2) % 1000000007));
    }


}
