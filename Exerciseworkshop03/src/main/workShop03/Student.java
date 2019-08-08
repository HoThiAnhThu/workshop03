package workShop03;

public class Student {
    private int id;
    private String name;
    private float mathPoint;
    private float chemistryPoint;
    private float physicPoint;
    private String status;
    public static String Collage = "test";

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getMathPoint() {
        return mathPoint;
    }

    public float getChemistryPoint() {
        return chemistryPoint;
    }

    public float getPhysicPoint() {
        return physicPoint;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMathPoint(float mathPoint) {
        this.mathPoint = mathPoint;
    }

    public void setChemistryPoint(float chemistryPoint) {
        this.chemistryPoint = chemistryPoint;
    }

    public void setPhysicPoint(float physicPoint) {
        this.physicPoint = physicPoint;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student(int id, String name, float mathPoint, float chemistryPoint, float physicPoint, String status) {
        this.id = id;
        this.name = name;
        this.mathPoint = mathPoint;
        this.chemistryPoint = chemistryPoint;
        this.physicPoint = physicPoint;
        this.status = status;
    }

    public Student() {
    }

    public void getInfo() {
        System.out.println("id " + id + " name " + name + " math point " + mathPoint + " physic point " + physicPoint + "chemistry point " + chemistryPoint + " status " + status);
    }

    public float averagePoint(){
        return (mathPoint + physicPoint + chemistryPoint) / 3;
    }
    public void updateStatus() {
        if(averagePoint() < 5) {
            setStatus("NOT PASS");
        }
        else {
            setStatus("PASS");
        }
    }
}
