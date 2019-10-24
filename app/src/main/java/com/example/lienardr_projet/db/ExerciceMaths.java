package com.example.lienardr_projet.db;


import java.util.ArrayList;
import java.util.Random;

public class ExerciceMaths extends Exercice {


    private int operand;

    private String operateur;

    private ArrayList<Integer> reponses;

    private ArrayList<Integer> operands1;

    private ArrayList<Integer> operands2;

    private boolean isNegativAuthorized;




    public int getOperand() {
        return operand;
    }

    public void setOperand(int operand) {
        this.operand = operand;
    }

    public String getOperateur() {
        return operateur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    public ArrayList<Integer> getReponses() {
        return reponses;
    }

    public void setReponses(ArrayList<Integer> reponses) {
        this.reponses = reponses;
    }

    public boolean isNegativAuthorized() {
        return isNegativAuthorized;
    }

    public void setNegativAuthorized(boolean negativAuthorized) {
        isNegativAuthorized = negativAuthorized;
    }

    public ArrayList<Integer> getOperands1() {
        return operands1;
    }

    public ArrayList<Integer> getOperands2() {
        return operands2;
    }

    public void setOperands1(ArrayList<Integer> operands1) {
        this.operands1 = operands1;
    }

    public void setOperands2(ArrayList<Integer> operands2) {
        this.operands2 = operands2;
    }

    public void setReponsesTables(int table)
    {
        reponses = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            reponses.add(i*table);
        }
    }


    public void setListesOperands(){
        operands1 = new ArrayList<>();
        operands2 = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            int op1;
            int op2;
            if (isNegativAuthorized) {
                op1 = new Random().nextInt(operand + operand) - operand;
                op2 = new Random().nextInt(operand + operand) - operand;
            } else {
                op1 = new Random().nextInt(operand);
                op2 = new Random().nextInt(operand);
            }
            operands1.add(op1);
            operands2.add(op2);
        }
    }


    public void setReponsesLibres(){
        reponses = new ArrayList<>();
        for(int i = 0; i < 10; i++){

            if (operateur.equals("Additions")){
                reponses.add(operands1.get(i)+operands2.get(i));
            }else if(operateur.equals("Soustractions")){
                reponses.add(operands1.get(i)-operands2.get(i));
            }else{
                reponses.add(operands1.get(i)*operands2.get(i));
            }
        }
    }


    public int verifReponses(ArrayList<Integer> resultats) {
        int nbErreurs = 0;
        for (int i = 0; i < resultats.size(); i++) {
            if (resultats.get(i) != reponses.get(i)) {
                nbErreurs++;
            }
        }
        return nbErreurs;
    }

    public String getRealOperator(){
        if (operateur.equals("Additions")){
            return "+";
        }else if(operateur.equals("Soustractions")){
            return "-";
        }else{
            return "x";
        }
    }
}
