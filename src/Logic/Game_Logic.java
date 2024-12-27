/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author jerem
 */
public class Game_Logic {

    private static int Current_Player = 1;

    private static void Player_Turn(JLabel Label, int Player_Id) {
        // metodo para cargar el turno del jugador en un jlabel
        if (Player_Id != 0) {
            Label.setText(String.valueOf(Player_Id));
        }
        // si el juego termino en empate, se debe de setear en el label dicha infroamcion
        if (Player_Id == 0) {
            Label.setText("Empate!");
        }
    }

    public static void Set_Place(JButton[][] Buttons_Array, JLabel Label) {

        // Jugador 1. Sera X
        // Jugador 2. Sera O
        for (int i = 0; i < Buttons_Array.length; i++) {
            for (int j = 0; j < Buttons_Array[i].length; j++) {
                int Row = i;
                int Col = j;

                Buttons_Array[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (Buttons_Array[Row][Col].getText() == "") {
                            if (Current_Player == 1) {
                                Buttons_Array[Row][Col].setText("X");
                                Buttons_Array[Row][Col].setForeground(Color.BLUE);
                                Buttons_Array[Row][Col].setFont(new Font("Tahoma", Font.BOLD, 70));
                                Find_Winner(Buttons_Array, 1);
                                Player_Turn(Label, 1);
                                Current_Player = 2;
                            } else if (Current_Player == 2) {
                                Buttons_Array[Row][Col].setText("O");
                                Buttons_Array[Row][Col].setForeground(Color.RED);
                                Buttons_Array[Row][Col].setFont(new Font("Tahoma", Font.BOLD, 70));
                                Find_Winner(Buttons_Array, 2);
                                Player_Turn(Label, 2);
                                Current_Player = 1;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Ya este espacio ha sido usado");
                            return;
                        }
                    }
                });

            }
        }

    }

    private static String Get_X_O(JButton Button, int Player) {
        if (Player == 1) {
            if (Button.getText().equals("X")) {
                return "X";
            } else {
                return "";
            }
        } else {
            if (Button.getText().equals("O")) {
                return "O";
            } else {
                return "";
            }
        }
    }

    public static void Reset_Table(JButton[][] Buttons_Array) {
        for (int i = 0; i < Buttons_Array.length; i++) {
            for (int j = 0; j < Buttons_Array[i].length; j++) {
                Buttons_Array[i][j].setText("");
                Buttons_Array[i][j].setForeground(Color.BLACK);
                Buttons_Array[i][j].setFont(new Font("Tahoma", Font.PLAIN, 14));
            }
        }

        Current_Player = 1;

    }

    public static void Find_Winner(JButton[][] Botonera, int Turn) {
        boolean Winner_1 = false;
        boolean Winner_2 = false;

        if (Turn == 1) {
            for (int i = 0; i < 3; i++) {

                if (Get_X_O(Botonera[i][0], 1).equals("X") && Get_X_O(Botonera[i][1], 1).equals("X") && Get_X_O(Botonera[i][2], 1).equals("X")) {
                    Winner_1 = true;

                } else if (Get_X_O(Botonera[0][i], 1).equals("X") && Get_X_O(Botonera[1][i], 1).equals("X") && Get_X_O(Botonera[2][i], 1).equals("X")) {
                    Winner_1 = true;

                }
            }

            if (Get_X_O(Botonera[0][0], 1).equals("X") && Get_X_O(Botonera[1][1], 1).equals("X") && Get_X_O(Botonera[2][2], 1).equals("X")) {
                Winner_1 = true;

            } else if (Get_X_O(Botonera[0][2], 1).equals("X") && Get_X_O(Botonera[1][1], 1).equals("X") && Get_X_O(Botonera[2][0], 1).equals("X")) {
                Winner_1 = true;

            }
        }

        if (Winner_1 == true) {
            JOptionPane.showMessageDialog(null, "¡El jugador 1 ha ganado el juego!");
            Reset_Table(Botonera);
        }

        if (Turn == 2) {
            for (int i = 0; i < 3; i++) {

                if (Get_X_O(Botonera[i][0], 2).equals("O") && Get_X_O(Botonera[i][1], 2).equals("O") && Get_X_O(Botonera[i][2], 2).equals("O")) {
                    Winner_2 = true;

                }

                if (Get_X_O(Botonera[0][i], 2).equals("O") && Get_X_O(Botonera[1][i], 2).equals("O") && Get_X_O(Botonera[2][i], 2).equals("O")) {
                    Winner_2 = true;

                }
            }

            if (Get_X_O(Botonera[0][0], 2).equals("O") && Get_X_O(Botonera[1][1], 2).equals("O") && Get_X_O(Botonera[2][2], 2).equals("O")) {
                Winner_2 = true;

            }
            if (Get_X_O(Botonera[0][2], 2).equals("O") && Get_X_O(Botonera[1][1], 2).equals("O") && Get_X_O(Botonera[2][0], 2).equals("O")) {
                Winner_2 = true;
            }
        }
        if (Turn == 2) {
            for (int i = 0; i < 3; i++) {

                if (Get_X_O(Botonera[i][0], 2).equals("O") && Get_X_O(Botonera[i][1], 2).equals("O") && Get_X_O(Botonera[i][2], 2).equals("O")) {
                    Winner_2 = true;

                }

                if (Get_X_O(Botonera[0][i], 2).equals("O") && Get_X_O(Botonera[1][i], 2).equals("O") && Get_X_O(Botonera[2][i], 2).equals("O")) {
                    Winner_2 = true;

                }
            }

            if (Get_X_O(Botonera[0][0], 2).equals("O") && Get_X_O(Botonera[1][1], 2).equals("O") && Get_X_O(Botonera[2][2], 2).equals("O")) {
                Winner_2 = true;

            }
            if (Get_X_O(Botonera[0][2], 2).equals("O") && Get_X_O(Botonera[1][1], 2).equals("O") && Get_X_O(Botonera[2][0], 2).equals("O")) {
                Winner_2 = true;
            }
        }
        if (Winner_2 == true) {
            JOptionPane.showMessageDialog(null, "¡El jugador 2 ha ganado el juego!");
            Reset_Table(Botonera);
        }
    }

}
