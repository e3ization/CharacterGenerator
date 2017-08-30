/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charactergenerator;
import java.util.Scanner;
/**
 *
 * @author erwri
 */
public class Player {
    private String firstName;
    private String nickName;
    private String lastName;
    private int age;
    private String race;
    private String[] nameInfo= new String[5];
    private int strength;
    private int constitution;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int charisma;

    Scanner scan =new Scanner(System.in);
    
    Player(){
        this("Robert","Bob","Bobington", 9, "Elf");
        
        strength=rollDice();
        constitution=rollDice();
        dexterity=rollDice();
        intelligence=rollDice();
        wisdom=rollDice();
        charisma=rollDice();
    }
    Player(String firstName, String nickName, String lastName, int age, String race){
        this.firstName = firstName;
        this.nickName = nickName;
        this.lastName = lastName;
        this.age = age;
        this.race = race;
        
        strength=rollDice();
        constitution=rollDice();
        dexterity=rollDice();
        intelligence=rollDice();
        wisdom=rollDice();
        charisma=rollDice();
       
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
        nameInfo[0]="First Name: "+name;
    }
    public String getNickName(){
        return nickName;
    }
    public void setNickName(String nickName){
        this.nickName=nickName;
        nameInfo[1]="Call me: "+nickName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
        nameInfo[2]="Last Name: "+lastName;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=1 && age<=100){
            this.age = age;
            nameInfo[3]="Age: "+Integer.toString(age);
        }else{
            noTolerance();
        }
    }

     public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
        nameInfo[4]="Race: "+race;
    }
    
    public void getNameInfo(){
     System.out.println("Here is your new character: ");
        int i =0;
        while(i<nameInfo.length){
            System.out.println(nameInfo[i].toUpperCase());
            i++;
        }
    }
    public void printStats(){
        System.out.println("Here are your stats:");
        System.out.println("Strength: "+strength);
        System.out.println("Constitution: "+constitution);
        System.out.println("Dexterity: "+dexterity);
        System.out.println("Intelligence: "+intelligence);
        System.out.println("Wisdom: "+wisdom);
        System.out.println("Charisma: "+charisma);
    }
//    public void addToInventory(String stat){
//        for(int i=0;i<nameInfo.length;i++){
//            if(nameInfo[i]==null){
//                nameInfo[i]=stat;
//                break;
//            }
//        }
//    }
    
    public void noTolerance(){
        System.out.println("You had 1 shot and you failed. Exiting Character generation. Now you have to start all over.");
        System.exit(0);
    }
    public int rollDice(){
        int roll = (int)(Math.random()*20)+1;
        return roll;
    }
    public void firstNamePrompt(){
        System.out.println("Choose a First Name: ");
        String newScan=scan.nextLine();
        setFirstName(newScan);
    }
    public void nickNamePrompt(){
        System.out.println("Choose a Nickname: ");
        String newScan=scan.nextLine();
        setNickName(newScan);
    }
    public void lastNamePrompt(){
        System.out.println("Choose a Last Name: ");
        String newScan=scan.nextLine();
        setLastName(newScan);
    }
    public void agePrompt(){
        System.out.println("What's your age?(HINT: Pick an integer between 1-100. If you don't, you lose): ");
        int newScan=scan.nextInt();
        setAge(newScan);
    }
    public void racePrompt(){
        System.out.println("What's your race? (HINT: it can be made up):");
        String newScan =scan.nextLine();
        setRace(newScan);
        
    }
    public void startPlayer(){
        firstNamePrompt();
        nickNamePrompt();
        lastNamePrompt();
        racePrompt();
        agePrompt();
        
        
        getNameInfo();
        System.out.println("");
        printStats();
    }
}
