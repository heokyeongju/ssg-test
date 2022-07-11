package com.ll.exam;

import java.io.File;
import java.util.Scanner;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class App {
    public void run() throws IOException {
        System.out.println("== 명언 SSG ==");
        int wiseSayingLastId = 0; //가장 마지막 명언글의 번호
        List<WiseSaying> wiseSayings = new ArrayList<>();
        JSONObject json = new JSONObject();
        Scanner sc = new Scanner(System.in);
        File jsonFile = new File("C:\\Users\\32174918\\IdeaProjects\\ssg-test\\src\\wiseSaying.json"); // 이 파일이 존재하는지 검사하고 없으면 만들고ㅡ 아니면 있는걸 불러와서.
        String jsonStr = "";



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

                    wiseSayings.add(wiseSaying);

                    json.put("id",wiseSaying.id);
                    json.put("content",wiseSaying.content);
                    json.put("author",wiseSaying.author);
                    jsonStr = json.toJSONString();
                    if(jsonStr != null){
                        writeStringToFile(jsonStr, jsonFile);
                    }

                    System.out.printf("%d번 명언이 등록되었습니다.\n",id);
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("-----------------");
                    for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                        WiseSaying wiseSaying_ = wiseSayings.get(i);
                        System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.content, wiseSaying_.author);
                    }
                    break;
                case "삭제":
                    break;
                case "종료":
                    break outer;
            }
        }
        sc.close();
    }

    public static void writeStringToFile(String str, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
        writer.write(str);
        writer.close();
    }
}

/*
    1. 목록을 json 파일로
    2. id를 파일에서 가져와서 last id 유지
 */