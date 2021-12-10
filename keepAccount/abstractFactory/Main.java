// cd ${workspaceFolder} && javac -d ${relativeFileDirname}/bin ${relativeFile} ${relativeFileDirname}/purchaseBookFactory/PurchaseBookFactory.java && java -classpath ${relativeFileDirname}/bin:${relativeFileDirname}/bin/keepAccount/abstractFactory/purchaseBookFactory ${fileBasenameNoExtension}

import keepAccount.abstractFactory.factory.*;

public class Main {
    public static void main(String[] args) {
        
        Factory factory = Factory.getFactory("keepAccount.abstractFactory.purchaseBookFactory.PurchaseBookFactory");
        
        Receipt book1 = factory.createReceipt(
            "スラスラわかるJava第2版",
            "2021/11/20",
            600, 
            "クレジットカード",
            "メルカリ",
            52
        );
        Receipt book2 = factory.createReceipt(
            "Rubyの冒険 遊遊編",
            "2021/11/20",
            400,
            "メルペイ残高",
            "メルカリ"
        );
        Receipt book3 = factory.createReceipt(
            "Rubyの冒険 旅立ち編",
            "2021/11/20",
            400,
            "メルペイ残高",
            "メルカリ"
        );
        
        Table books = factory.createTable();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        
        Document doc = factory.createDocument("2021年11月の購入本");
        doc.add(books);
        doc.dumpFile("abstractFactoryOutput");
    }
}
