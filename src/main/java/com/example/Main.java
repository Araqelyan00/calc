package com.example;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Output: " + result);
        } catch (Exception e) {
            System.out.println("Output: throws Exception");
        }
    }

    public static String calc(String input) throws Exception {
        String trimmed = input.trim();

        String[] parts = trimmed.split(" ");
        if (parts.length != 3) {
            throw new Exception("Input is not correct");
        }

        int num1, num2;
        String operator = parts[1];

        try {
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Invalid numbers");
        }

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Numbers out of range");
        }

        int result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;

            default -> throw new Exception("Invalid operator");
        };

        return String.valueOf(result);
    }
}
