# OS_CALCULATOR说明文档

小组名称：第六十五组

| 小组成员 | 学号     | 任务职责                     |
| -------- | -------- | ---------------------------- |
| 周思源   | 21210113 | 页面设计及算法编写并提出需求 |
| 马永健   | 21210104 | 页面设计及算法编写           |

## 一、设计目的

在本学期的课程学习中，操作系统作业的计算总是让人十分头痛，因此我们小组决定做出一个计算器方便大家更好的完成相应作业。本软件为操作系统计算器，我们从计算机操作系统领域的实践过程中现有的计算器无法满足的需求出发，适配操作系统作业中对于常规计算器、科学计算器、进制转换、的位运算、计算机16进制地址解析、页面置换模拟、进程调度模拟、磁盘寻道模拟等多种需求，进行了软件开发，本产品将为用户提供了在操作系统学科及其线管领域的学习实践过程中更加便利的体验。

## 二、软件相关信息

项目运行环境为Android 29.0.2，

Java JDK版本为8，

使用gradle:3.5.2帮助运行。

## 三、各模块的功能及程序说明

### 3.1 计算器各界面设计

#### 3.1.1主界面

主界面展示

![img](file:///C:\Users\19208\AppData\Roaming\Tencent\Users\1920858503\QQ\WinTemp\RichOle\5B]]06{[]R~%DZ1QAKUG93W.png)

About页面展示

![img](file:///C:\Users\19208\AppData\Roaming\Tencent\Users\1920858503\QQ\WinTemp\RichOle\]%INX@8`~N%}E_NFSV9}564.png)

#### 3.1.2  NORAML计算器界面

计算功能展示：

![image-20220622192341203](C:\Users\19208\AppData\Roaming\Typora\typora-user-images\image-20220622192341203.png)

异常抛出展示

![image-20220622192501503](C:\Users\19208\AppData\Roaming\Typora\typora-user-images\image-20220622192501503.png)

### 3.1.3 Scientific计算器界面

计算功能展示

![image-20220622192633677](C:\Users\19208\AppData\Roaming\Typora\typora-user-images\image-20220622192633677.png)

异常抛出展示

![image-20220622192703865](C:\Users\19208\AppData\Roaming\Typora\typora-user-images\image-20220622192703865.png)

### 3.1.4 进制转换计算器

进制转换功能展示

![image-20220622192820338](C:\Users\19208\AppData\Roaming\Typora\typora-user-images\image-20220622192820338.png)

### 3.1.5 位运算计算器

位运算功能展示

![image-20220622193124061](C:\Users\19208\AppData\Roaming\Typora\typora-user-images\image-20220622193124061.png)

当运算使用的符号为&、|时，运算数1与运算数2都为十六进制；当使用运算符号<<、>>时，运算数1为十六进制，运算数2为十进制；当使用运算符号~时，运算数1输入框无效，对运算数2框内的十六进制数字进行运算；其中，运算框2只允许输入一个符号，以最后一次向文本框输入的符号为准，当使用~进行运算时，对输入框1的输入进行清空，以代表其无法使用。

### 3.1.6 地址解析计算器

地址解析计算展示：

![image-20220622194103055](C:\Users\19208\AppData\Roaming\Typora\typora-user-images\image-20220622194103055.png)

### 3.1.7 页面置换计算器

页面置换计算展示



页面置换异常抛出：



### 3.1.8 进程调度计算器

进程调度计算展示：

FCFS:

![image-20220622194638162](C:\Users\19208\AppData\Roaming\Typora\typora-user-images\image-20220622194638162.png)

SJF:

![image-20220622194721944](C:\Users\19208\AppData\Roaming\Typora\typora-user-images\image-20220622194721944.png)

静态优先级：

![image-20220622194846628](C:\Users\19208\AppData\Roaming\Typora\typora-user-images\image-20220622194846628.png)

抢占式SJF：

<img src="C:\Users\19208\AppData\Roaming\Typora\typora-user-images\image-20220622195107177.png" alt="image-20220622195107177" style="zoom:200%;" />

当输入非法时：

![image-20220622195154178](C:\Users\19208\AppData\Roaming\Typora\typora-user-images\image-20220622195154178.png)

当未选择算法：

![image-20220622195300449](C:\Users\19208\AppData\Roaming\Typora\typora-user-images\image-20220622195300449.png)

### 3.1.8 磁盘寻道计算器

磁盘寻道计算展示：



### 3.1.9 历史界面展示

![image-20220622195546986](C:\Users\19208\AppData\Roaming\Typora\typora-user-images\image-20220622195546986.png)

