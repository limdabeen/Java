package NNH;
interface Item {
    void show();
}
class CellPhone implements Item {
//phoneID, brand
int phoneID;
    String brand;
    CellPhone(int phoneID, String brand) {
        this.phoneID = phoneID;
        this.brand = brand;
    }
    public void show() {
        System.out.println("전화기 일련변호: " + phoneID + " 생산자: " + brand);
    }
}
class Computer implements Item {
    int seriesID;
    String model;
    Computer(int seriesID, String model) {
        this.seriesID = seriesID;
        this.model = model;
    }
    public void show() {
        System.out.println("컴퓨터 번호: " + seriesID + " 모델명: " + model);
    }

}
class AISpeaker implements Item {
    int speakerID;
    String type;
    AISpeaker(int speakerID, String type) {
        this.speakerID = speakerID;
        this.type = type;
    }
    public void show() {
        System.out.println("인공지능 스피커 번호: " + speakerID + " 타입: " + type);
    }
}

public class pr3 {
    public static void main(String[] args) {
        Item[] iList = new Item[3];

        iList[0] = new CellPhone(1234, "Samsung");
        iList[1] = new Computer(5678, "GalaxyBook2");
        iList[2] = new AISpeaker(9123, "JBLPortable");

        for(int i = 0; i < iList.length; i++) {
            iList[i].show();
        }
    }
}