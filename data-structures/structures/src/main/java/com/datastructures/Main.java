package com.datastructures;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Request> rQueue = new PriorityQueue<>((a, b) -> Request.compare(a, b));

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite os dados, digite . parar");

        String data;
        int priority;
        while (true) {
            System.out.print("Dados: ");
            data = sc.nextLine();

            if (".".equals(data)) {
                break;
            }

            System.out.print("Prioridade: ");
            priority = sc.nextInt();
            sc.nextLine();
            
            rQueue.add(new Request(data, priority));
        }

        while (rQueue.size() > 0) {
            System.out.println("Aperte enter para pegar um valor."); 
            sc.nextLine();

            System.out.println(rQueue.pool().toString());
        }

        sc.close();
    }
}