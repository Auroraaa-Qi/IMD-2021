# Flutter

Flutter: Google的UI工具包，可以从单一代码库为[mobile][https://flutter.dev/docs], [web][https://flutter.dev/web], 和[桌面][https://flutter.dev/desktop]构建好看的、本机编译的app。

### 特点

1.  Fast Development

2.  Expressive and Flexible UI

3.  Native Performance



### Installation

##### 地址 (MacOS)

>   https://storage.googleapis.com/flutter_infra/releases/stable/macos/flutter_macos_2.0.1-stable.zip

##### Mac安装

解压：

```shell
cd ~/Documents
unzip ~/Downloads/flutter_macos_2.0.1-stable.zip
```

把flutter加入路径：

```shell
export PATH="$PATH:`pwd`/flutter/bin"
```

>   此命令仅将`PATH`变量设置为<strong>当前</strong>终端窗口

若要永久更新此变量，以便flutter可以在任何终端会话中运行

```shell
vim ~/.bash_profile
export PATH="$PATH:[PATH_TO_FLUTTER_GIT_DIRECTORY]/flutter/bin"
source ~/.bash_profile
```

flutter/bin通过运行以下命令来验证该目录现在位于`PATH`中：

```shell
echo $PATH
```

验证flutter命令是否可用：

```shell
which flutter
```

之后，应该可以正常[Setting up Flutter][export PUB_HOSTED_URL=https://pub.flutter-io.cn export FLUTTER_STORAGE_BASE_URL=https://storage.flutter-io.cn git clone -b dev https://github.com/flutter/flutter.git export PATH="$PWD/flutter/bin:$PATH" cd ./flutter flutter doctor]

### Set up

##### 安装Android Studio

>   https://developer.android.com/studio

或者也可以安装IntelliJ:

>   https://www.jetbrains.com/idea/download

##### 安装Flutter和Dart插件

1.  Configure > Plugins > 选择Flutter > Install 

2.  出现提示安装Dart插件 > Yes

3.  Restart