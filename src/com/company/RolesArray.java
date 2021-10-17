package com.company;

import java.util.Random;

public class RolesArray {
    ComputerTalk computerTalk = new ComputerTalk();
    static int[] rolesArray = new int[ComputerTalk.playerNumber];
    int playerID = 1;
    int spyID = 0;

    public void creatingArrayOfPlayer(){
        for(int i = 0; i < ComputerTalk.playerNumber - ComputerTalk.spyNumber; i++){
            rolesArray[i] = playerID;
        }
        for(int i = ComputerTalk.playerNumber - ComputerTalk.spyNumber; i < rolesArray.length; i++){
            rolesArray[i] = spyID;
        }

        //SHIFTING ARRAY
        Random random = new Random();

        for(int i = 0; i < rolesArray.length; i++){
            int randomIndexToSwap = random.nextInt(rolesArray.length);
            int temp = rolesArray[randomIndexToSwap];
            rolesArray[randomIndexToSwap] = rolesArray[i];
            rolesArray[i] = temp;
        }
    }
}

