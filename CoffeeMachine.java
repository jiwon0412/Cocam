import java.util.Scanner;

abstract class Box {
    protected int size; // 현재 박스에 들어 있는 재료의 양

    public Box(int size) { // 생성자
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0; // 박스가 빈 경우 true 리턴
    }

    public abstract boolean consume(); // 박스에 들어 있는 재료를 일정량 소비
    public abstract void print(); // 박스에 들어 있는 양을 "*" 문자로 출력
}

class IngredientBox extends Box {
    private String name;

    public IngredientBox(String name, int size) {
        super(size);
        this.name = name;
    }

    @Override
    public boolean consume() {
        if (size > 0) {
            size--;
            return true;
        } else {
            System.out.println(name + " 원료 부족");
            return false;
        }
    }

    @Override
    public void print() {
        System.out.print(name + ": ");
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.println(" (" + size + ")");
    }
}

public class CoffeeMachine {
    public int choice = 0;

    public void run() {
        System.out.println("***** 청춘 커피 자판기 *****");
        IngredientBox Coffee = new IngredientBox("커피", 5);
        IngredientBox Fream = new IngredientBox("프림", 5);
        IngredientBox Sugar = new IngredientBox("설탕", 5);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            Coffee.print();
            Fream.print();
            Sugar.print();

            System.out.print("다방커피:1, 설탕커피:2, 블랙커피:3, 종료:4 >> ");
            choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("청춘 커피 자판기 프로그램 종료");
                break;
            }

            ingredientConsume(Coffee, Fream, Sugar);
        }
        scanner.close(); // Scanner 닫기
    }

    public void ingredientConsume(IngredientBox Coffee, IngredientBox Fream, IngredientBox Sugar) {
        switch (choice) {
            case 1: { // 다방커피 (커피1, 프림1, 설탕1)
                if (Coffee.size > 0 && Fream.size > 0 && Sugar.size > 0) {
                    Coffee.consume();
                    Fream.consume();
                    Sugar.consume();
                    System.out.println("다방커피 나왔습니다!");
                } else {
                    System.out.println("재료가 부족합니다.");
                }
            }
            break;

            case 2: { // 설탕커피 (커피1, 설탕1)
                if (Coffee.size > 0 && Sugar.size > 0) {
                    Coffee.consume();
                    Sugar.consume();
                    System.out.println("설탕커피 나왔습니다!");
                } else {
                    System.out.println("재료가 부족합니다.");
                }
            }
            break;

            case 3: { // 블랙커피 (커피1)
                if (Coffee.size > 0) {
                    Coffee.consume();
                    System.out.println("블랙커피 나왔습니다!");
                } else {
                    System.out.println("재료가 부족합니다.");
                }
            }
            break;

            default: // 잘못된 입력 처리
                System.out.println("번호를 정확히 입력해주세요.");
                break;
        }
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.run();
    }
}
