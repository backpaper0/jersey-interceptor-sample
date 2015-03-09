Jerseyでトランザクション境界を実現するサンプル
==================================================

# これはなに？

[Jersey](jersey.java.net)が内部で使用している[HK2](https://hk2.java.net/)の
AOP機能を使ってリソースメソッドにトランザクション境界を設定するサンプルです。

# 起動

``gradlew run`` でJerseyが起動します。

* http://localhost:8080/api/sample/1 がトランザクション開始〜コミットをシミュレートするサンプルです。
* http://localhost:8080/api/sample/2 がトランザクション開始〜ロールバックをシミュレートするサンプルです。

# ライセンス

[Apache License Version 2.0](apache.org/licenses/LICENSE-2.0.txt)

