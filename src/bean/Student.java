package bean;

public class Student{
    private int iD;
    private String name;
    public Student(){
        super();
    }

    public Student(Integer id1, String name) {
        this.iD=id1;
        this.name=name;
    }

    public void setID(int iD){
        this.iD = iD; }

    public int getID(){
        return iD;}

    public void setName(String name){
        this.name = name; }

    public String getName(){
        return name; }
}