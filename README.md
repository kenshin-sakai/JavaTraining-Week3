# JavaTraining-Week3
タスク管理アプリを作成しよう
## 概要
本アプリケーションは，コマンドライン上でタスク（ToDo）を登録・一覧表示・削除・完了にできるタスク管理システムである．  
入力ミスを例外処理で検知し，再入力を促すことで安定して操作できるようにした．

## 実行方法
```powershell
cd src
javac -encoding UTF-8 Task.java TaskManager.java TaskApp.java
java TaskApp**```**

## 工夫した点
- メニュー番号やタスク番号の入力は Integer.parseInt により数値化し，数値以外の入力は 　　　　　　　　　   NumberFormatException を用いて再入力を促す設計とした．

- 期限は LocalDate で扱い，LocalDate.parse の失敗を DateTimeParseException で捕捉することで，不正　　　な日付形式に対応した．

- タスクの削除・完了では，ユーザーが入力する番号（1始まり）を index = number - 1 により配列添字（0始     まり）へ変換し，範囲外は IndexOutOfBoundsException として処理した．

- 一覧表示は forEach とラムダ式により出力し，完了状態が視覚的に分かるよう表示形式を整えた．
