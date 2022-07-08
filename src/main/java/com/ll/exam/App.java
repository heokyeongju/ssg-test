package com.ll.exam;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("== 명언 SSG ==");
        int wiseSayingLastId = 0; //가장 마지막 명언글의 번호
        Scanner sc = new Scanner(System.in);

        outer:
        while (true) {
            System.out.printf("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "등록":
                    System.out.printf("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.printf("작가 : ");
                    String author = sc.nextLine().trim();
                    int id = ++wiseSayingLastId;
                    WiseSaying wiseSaying = new WiseSaying(id, content,author);
                    System.out.println(wiseSaying);

                    System.out.printf("%d번 명언이 등록되었습니다.\n",id);
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    printf
                    break;
                case "삭제":
                    break;
                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}

