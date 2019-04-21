> 背景：当项目代码量很大的时候，或者你作为一名新人要快速掌握代码的时候，给函数打上log，来了解代码执行逻辑，这种方式会显然成本太大，要改动项目编译运行，NO！太耗时；或者你想debug的方式来给你想关注的几个函数，来了解代码执行逻辑，NO！因为你肯定会漏掉函数；也许你可以固执的给你写的项目打满log说这样也行，但是你要知道你方法所调用的jdk的函数或者第三方aar或者jar再或者android sdk中的函数调用顺序你怎么办，还能打log吗？显然不行吧，来~这个项目给让可以让你以包名为过滤点过滤你想要知道所有函数调用顺序。

项目地址：[https://github.com/zjw-swun/AppMethodOrder](https://github.com/zjw-swun/AppMethodOrder) 欢迎star


作者列表（排名按代码贡献时间顺序）：二精-霁雪清虹，xingstarx，大精-wing，pighead4u ,lijunjie，三精-虹猫，Harlber


# 1. 效果奉上

![图片描述](https://github.com/zjw-swun/AppMethodOrder/blob/master/images/1.gif)

动作简介：首先点击MainActivity的自定义MyTextView然后进入SecondActivity再点击textview之后finish跳转回MainActivity<br>
下面是库处理过所得到的函数调用顺序``order.txt``文件（我这里屏蔽了jdk函数，第三方库函数，以及android sdk中函数，换句话说我就保留了我自己包名中的函数顺序）
```
832 ent     67593 .....com.zjw.appmethodorder.MainActivity.onClick (Landroid/view/View;)V	MainActivity.java
832 ent     99956 ..........com.zjw.appmethodorder.MainActivity.onPause ()V	MainActivity.java
832 ent     99970 ...........com.zjw.appmethodorder.BaseActivity.onPause ()V	BaseActivity.java
832 ent    100472 ............com.zjw.appmethodorder.BaseActivity.baseOnPause ()V	BaseActivity.java
832 ent    128540 ........com.zjw.appmethodorder.SecondActivity.<init> ()V	SecondActivity.java
832 ent    128562 .........com.zjw.appmethodorder.BaseActivity.<init> ()V	BaseActivity.java
832 ent    213911 ........com.zjw.appmethodorder.SecondActivity.onCreate (Landroid/os/Bundle;)V	SecondActivity.java
832 ent    213928 .........com.zjw.appmethodorder.BaseActivity.onCreate (Landroid/os/Bundle;)V	BaseActivity.java
832 ent    258414 ..........com.zjw.appmethodorder.BaseActivity.baseOnCreate ()V	BaseActivity.java
832 ent   1440503 .........com.zjw.appmethodorder.SecondActivity.onResume ()V	SecondActivity.java
832 ent   1440563 ..........com.zjw.appmethodorder.BaseActivity.onResume ()V	BaseActivity.java
832 ent   1445675 ...........com.zjw.appmethodorder.BaseActivity.baseOnResume ()V	BaseActivity.java
832 ent   2954291 .................com.zjw.appmethodorder.MyTextView.onWindowVisibilityChanged (I)V	MyTextView.java
832 ent   3065664 ........com.zjw.appmethodorder.MainActivity.onStop ()V	MainActivity.java
832 ent   3065701 .........com.zjw.appmethodorder.BaseActivity.onStop ()V	BaseActivity.java
832 ent   3069155 ..........com.zjw.appmethodorder.BaseActivity.baseOnStop ()V	BaseActivity.java
832 ent   3139519 .......com.zjw.appmethodorder.SecondActivity.click (Landroid/view/View;)V	SecondActivity.java
832 ent   3146300 ........com.zjw.appmethodorder.SecondActivity.finish ()V	SecondActivity.java
832 ent   3183478 ..........com.zjw.appmethodorder.SecondActivity.onPause ()V	SecondActivity.java
832 ent   3183498 ...........com.zjw.appmethodorder.BaseActivity.onPause ()V	BaseActivity.java
832 ent   3183843 ............com.zjw.appmethodorder.BaseActivity.baseOnPause ()V	BaseActivity.java
832 ent   3209420 ........com.zjw.appmethodorder.MainActivity.<init> ()V	MainActivity.java
832 ent   3209438 .........com.zjw.appmethodorder.BaseActivity.<init> ()V	BaseActivity.java
832 ent   3283359 ........com.zjw.appmethodorder.MainActivity.onCreate (Landroid/os/Bundle;)V	MainActivity.java
832 ent   3283378 .........com.zjw.appmethodorder.BaseActivity.onCreate (Landroid/os/Bundle;)V	BaseActivity.java
832 ent   3330938 ..........com.zjw.appmethodorder.BaseActivity.baseOnCreate ()V	BaseActivity.java
832 ent   4363295 .....................com.zjw.appmethodorder.MyTextView.<init> (Landroid/content/Context;Landroid/util/AttributeSet;)V	MyTextView.java
832 ent   4436094 ..................com.zjw.appmethodorder.MyTextView.onFinishInflate ()V	MyTextView.java
832 ent   4449689 .........com.zjw.appmethodorder.MainActivity.initView ()V	MainActivity.java
832 ent   4539427 .........com.zjw.appmethodorder.MainActivity.onResume ()V	MainActivity.java
832 ent   4539467 ..........com.zjw.appmethodorder.BaseActivity.onResume ()V	BaseActivity.java
832 ent   4543597 ...........com.zjw.appmethodorder.BaseActivity.baseOnResume ()V	BaseActivity.java
832 ent   4917854 .................com.zjw.appmethodorder.MyTextView.onAttachedToWindow ()V	MyTextView.java
832 ent   4918658 .................com.zjw.appmethodorder.MyTextView.onWindowVisibilityChanged (I)V	MyTextView.java
832 ent   5090653 ...................................com.zjw.appmethodorder.MyTextView.onMeasure (II)V	MyTextView.java
832 ent   5355203 ..................................com.zjw.appmethodorder.MyTextView.onMeasure (II)V	MyTextView.java
832 ent   5456681 .......................................com.zjw.appmethodorder.MyTextView.onSizeChanged (IIII)V	MyTextView.java
832 ent   5467577 ....................................com.zjw.appmethodorder.MyTextView.onLayout (ZIIII)V	MyTextView.java
832 ent   5876623 ...........................................com.zjw.appmethodorder.MyTextView.onDraw (Landroid/graphics/Canvas;)V	MyTextView.java
832 ent   6121967 ........com.zjw.appmethodorder.SecondActivity.onStop ()V	SecondActivity.java
832 ent   6121986 .........com.zjw.appmethodorder.BaseActivity.onStop ()V	BaseActivity.java
832 ent   6123689 ..........com.zjw.appmethodorder.BaseActivity.baseOnStop ()V	BaseActivity.java
832 ent   6127522 ........com.zjw.appmethodorder.SecondActivity.onDestroy ()V	SecondActivity.java
832 ent   6127679 .........com.zjw.appmethodorder.BaseActivity.onDestroy ()V	BaseActivity.java
832 ent   6133301 ..........com.zjw.appmethodorder.BaseActivity.baseOnDestroy ()V	BaseActivity.java
```

# 2. 原理篇
废弃dmtracedump解析，采用android studio官方源码解析方案(官方android studio解析trace的移植版版本)，核心代码详见``com.android.tools.perflib.vmtrace.VmTraceParser``类,相比之前的方案无需再配置dmtracedump环境变量，以及兼容android studio 3.1及其以后掐表生成的trace格式。

# 3. 使用方法

## 3.1 生成trace文件的方式
生成trace文件的方式有2种操作，一种是在项目中使用代码操作 即``android.os.Debug.startMethodTracing();`` 和``android.os.Debug.stopMethodTracing();``，执行完``stopMethodTracing``将会在您手机app的sdcard下面生成``.trace``文件，该方式不区分版本，dumtracedump可解析<br>
第二种方式是掐表生成trace文件<br>
**android studio 3.0之前版本操作如下**<br>
第一次点击下图时钟icon代表开始掐表，然后回到您的app，进行您要跟踪函数调用顺序的操作，再次点击下图时钟icon代表结束掐表
![图片描述](https://github.com/zjw-swun/AppMethodOrder/blob/master/images/0.png)
掐表结束后即会在captures目录生成``com.zjw.appmethodorder_2017.03.25_21.41.trace``文件，android studio会默认打开一个可视化窗口

![图片描述](https://github.com/zjw-swun/AppMethodOrder/blob/master/images/00.png)

**android studio 3.0版本操作如下**<br><br>
点击CPU 进入CPU面板，然后选择Instrumented选项（Sampled和Instrumented区别在于，Sampled函数调用采样率低生成的trace文件小，采样率低会造成大部分函数调用顺序漏记，Instrumented相当于无损采样生成文件大），第一次点击下图红色圆形icon代表开始掐表，然后回到您的app，进行您要跟踪函数调用顺序的操作，再次点击下图红色圆形icon代表结束掐表，
![图片描述](https://github.com/zjw-swun/AppMethodOrder/blob/master/images/1.png)
![图片描述](https://github.com/zjw-swun/AppMethodOrder/blob/master/images/2.png)
结束掐表就会在``C:\Users\hasee\AppData\Local\Temp\cpu_trace.trace``(本人是windows环境，使用windows系统可以参照，使用Mac的同学 cd /private/var/folders在folders 搜索cpu_trace.trace)，存在cpu_trace.trace时会新建cpu_trace1.tracecpu_trace2.trace 以此类推

**android studio 3.1开始,掐表默认实现改成cpu profiler**<br><br>
详见[https://developer.android.google.cn/studio/profile/cpu-profiler](https://developer.android.google.cn/studio/profile/cpu-profiler),如果掐表生成的trace文件可以用文本编辑器打开看是否开头带有"slow"字样，dmtracedump无法解析，但是现在的小工具是基于最新android studio源码实现，支持此种trace格式啦啦啦！。android studio 3.4掐表生成trace文件在cpu面板右键支持自定义路径的export导出。


## 3.2 appMethodOrder小工具使用

appMethodOrder小工具  下载地址[AppMethodOrderUtils.jar](tool/AppMethodOrderUtils.jar)  
appMethodOrder小工具  源码地址[AppMethodOrderUtils.zip](tool/AppMethodOrderUtils.zip)
appMethodOrder小工具改良自 [https://github.com/Harlber/Method_Trace_Tool](https://github.com/Harlber/Method_Trace_Tool )
感谢Harlber[https://github.com/Harlber](https://github.com/Harlber)

**好消息，现在小工具使用无需配置dmtracedump环境变量了！开箱即用！！！**

将trace文件拖拽到小工具``File Path``左边区域
![图片描述](https://github.com/zjw-swun/AppMethodOrder/blob/master/images/3.png)
 ``package name``处填入您需要过滤的目标包名，或者填入空串（空串将生成所有线程所有包名的函数调用顺序）

![图片描述](https://github.com/zjw-swun/AppMethodOrder/blob/master/images/4.png)

如上图所示，查询结构存在四个tab，第一个``threadID``代表线程id，第二个``threadName``代表线程名，第三个``usecs``代表函数耗时(单位微秒，有时候耗时为-1不要惊讶，是因为该次掐表刚好没包括到其函数结束时机)，第四个``method``代表函数名，（查询结果是以时间排序的）

**特别注意**
这里注意android studio 3.1以后掐表生成的trace 解析的时候 时间耗时有点小问题(官方代码的问题)，在一段时间内函数ent 给出的threadTime都是一致的，这里需要小小的注意一下，所以3.1以后掐表要看耗时的朋友，建议还是在studio面板看相对耗时，或者使用代码方式生成trace文件。

# 4. 海量信息的处理手段
不难发现trace文件时间越长意味着记录的信息也会越来越多，这时候单纯以包名过滤其实满足不了需求，比如我们想通过3个条件（例如 主线程+含zjw包名的 or android.view）来过滤出结果，以下将给出解决办法。

appMethodOrder小工具会在该jar所在目录生成``appMethodOrderTrace.txt``，以文本方式记录查询结果。
我们可以借助数据库这个工具使用查询语句来帮助我们过滤出有用的信息，可以使用以下数据库命令，把``appMethodOrderTrace.txt``内容导入到数据库表中
//从text 导入数据到 mysql （以下语句在mysql中实验是OK的）
```
truncate table app;
LOAD DATA LOCAL INFILE 'C:/Users/hasee/Desktop/appMethodOrderTrace.txt' INTO TABLE `app`;
```
![图片描述](https://github.com/zjw-swun/AppMethodOrder/blob/master/images/5.png)

app表结创建语句如下
```
CREATE TABLE `app` (
  `threadId` int(11) DEFAULT NULL,
  `threadName` varchar(255) DEFAULT NULL,
  `usecs` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
查询语句示范
//查询main线程中 自定义包下最耗时的操作(以毫秒为单位，降序)
SELECT
	threadName,
	usecs/1000, 
	method
FROM
	app
WHERE
	app.threadName = "main" AND method like "%自定义包名%"
ORDER BY
	app.usecs DESC
![图片描述](https://github.com/zjw-swun/AppMethodOrder/blob/master/images/6.png)

# 5. 计算得出的函数耗时不是准确的时间
根据官方文档(https://developer.android.com/studio/profile/traceview.html) ``Interpreted code runs more slowly when profiling is enabled. Don't try to generate absolute timings from the profiler results (such as, "function X takes 2.5 seconds to run"). The times are only useful in relation to other profile output, so you can see if changes have made the code faster or slower relative to a previous profiling run.``所知(我也用了代码在函数开头结尾用System.nanoTime()时间相减，发现，生成trace的时候确实会拖慢所以函数的执行时间，比System.nanoTime()时间相减得出的时间差的比较多)。原因是trace过程会整体拖慢JVM执行，因此函数耗时只是一个参考值，比较哪个函数更耗时是可以的。
