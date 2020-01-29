import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

// guess class
public class Guess {

    public JButton guessButton; // selects guessed number
    public JPanel mainPanel;
    public JButton newGameButton;// creates new game
    public JSlider slider1; // slider format
    public JLabel lblSlideNumbers; // label showing the numbers on the slider
    public JLabel lblNumberOfGuesses; // number of guesses used by user
    public JLabel numFeedbackResults; // label showing results


    //variables
    public int guessedNumber = 0; // user number guessed
    public int guessCount = 0; // guesses count tries
    public String results = ""; // feedback operation
    public int num1 = 0;


    // guess constructor
    public Guess() {

        Random rand = new Random();
        num1 = rand.nextInt(100) + 1;
        slider1.setValue(50);
    //    numFeedbackResults.setText("");
        newGameButton.setEnabled(false);
        //lblNumberOfGuesses.setText("0");
        System.out.println(num1);
        slider1.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);

                guessedNumber = slider1.getValue();
              //lblSlideNumbers.setText(guessedNumber.toString());
                lblSlideNumbers.setText(String.valueOf(slider1.getValue()));
                System.out.println(slider1.getValue());
            }
        });

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(num1);
                guessCount++;
                lblNumberOfGuesses.setText(" Number of Guesses:  " + guessCount);
                guessedNumber = slider1.getValue();



                if (guessedNumber == num1) {
                  numFeedbackResults.setText("You Guessed It!");

                   guessButton.setEnabled(false);
                    newGameButton.setEnabled(true);


                }
                if (guessedNumber >num1) {
                    numFeedbackResults.setText("Number Too High!. Try Again");

                }
                if (guessedNumber< num1) {
                    numFeedbackResults.setText("Number Too Low!. Try Again");
                }


            }
        });
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                //guessedNumber = rand.nextInt(100) + 1;
                num1 = rand.nextInt(100) + 1;
                guessCount = 0;
                lblNumberOfGuesses.setText(" Number of Guesses: " + guessCount);
               guessedNumber = Integer.parseInt(lblSlideNumbers.getText());
                newGameButton.enableInputMethods(false);
                guessButton.isEnabled();
               guessButton.setEnabled(true);
                newGameButton.setEnabled(false);
                System.out.println(results);
                slider1.setValue(50);
                lblSlideNumbers.setText("50");
                numFeedbackResults.setText("Guess a number!");


            }
        });

    }


        public static void main(String[] args) {

            JFrame frame = new JFrame("Guessing Game");
            frame.setContentPane(new Guess().mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);
            frame.setVisible(true);
        }

    }







