# QuickQuizGame
Minecraft内で早押しクイズができるようになるものです。 

Spigot version 1.21.1

plugin version 1.0

チームはRed, Blue, Yellow, Grenn の４つまでです。

# 注意

config.ymlを直接入力することは推奨されません。

反映されないことがあります。

必ずコマンドを利用してください。

## 機能

早押し機能(誰が一番最初にボタンを押したかがわかる)

## コマンド

/press < teamColor >

ボタンを押したときにこのコマンドが実行される必要があります。

/setpos < teamColor > 

 実行した場所の足元のブロックの一つ下のブロックの座標をレッドストーンブロックを設置する座標としてconfig.ymlに保存します。
 
 ※OPを所持しているプレイヤーのみ実行可能

/qqg

&emsp;get
 
&emsp;&emsp;gui

&emsp;&emsp;&emsp;出題者用のGUIを開く本を入手します。

&emsp;set

&emsp;&emsp;performer

&emsp;&emsp;&emsp;< プレイヤーディスプレイネーム >

&emsp;&emsp;&emsp;&emsp;指定したプレイヤーを出題者として設定します。

&emsp;&emsp;&emsp;&emsp;※OPを所持しているプレイヤーのみ実行可能
