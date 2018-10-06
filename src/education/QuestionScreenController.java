package education;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import java.io.BufferedReader;
import java.io.FileReader;


public class QuestionScreenController implements Initializable{


    @FXML Label questionLabel = new Label();
    @FXML Label questionNumber = new Label();
    @FXML Label scoreLabel = new Label();
    @FXML Label congrats = new Label();
    @FXML Button choiceA = new Button();
    @FXML Button choiceB = new Button();
    @FXML Button choiceC = new Button();
    @FXML Button choiceD = new Button();
    @FXML Button submitButton = new Button();
    @FXML Button backButton = new Button();
    @FXML Button homeButton = new Button();
    @FXML Button returnToUserProfile = new Button();
    @FXML AnchorPane anchorPane = new AnchorPane();
    Scene scene = new Scene(anchorPane);

    static String quizId;
    String [] question = new String[7];
    String [] answer = new String[7];
    String [] A = new String[7];
    String [] B = new String[7];
    String [] C = new String[7];
    String [] D = new String[7];
    String [] userAnswer = new String[7];
    int score = 0;
    int questionCount = 1;
    int userAnswerCount = 1;
    BufferedReader br;



    public void setQuizQuestions()
    {
        QuizDatabase quizDatabase = new QuizDatabase(quizId);
        quizDatabase.setQuestion();
    }

    public int setQuizQuestions1()
    {
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Weisslogia\\IdeaProjects\\E-Ducation\\src\\education\\Assets\\Quiz\\Grade 4\\English\\Chapter 1.txt"));
            String newlines;
            int count=1;
            while ((newlines = br.readLine()) != null)
            {
                question[count]=newlines;
                A[count] = br.readLine();
                B[count] = br.readLine();
                C[count] = br.readLine();
                D[count] = br.readLine();
                answer[count] = br.readLine();
                count++;
            }
            if (newlines==null)
            {
                return 1;
            }
            else return 0;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        /*setQuizQuestions();
        questionLabel.setText(question[questionCount]);
        choiceA.setText(A[questionCount]);
        choiceB.setText(B[questionCount]);
        choiceC.setText(C[questionCount]);
        choiceD.setText(D[questionCount]);
        questionCount++;*/
        returnToUserProfile.setVisible(false);
        int x = setQuizQuestions1();
        /*if (x==1)
        {
            returnToUserProfile.setVisible(true);
        }*/
        System.out.println(question[2]);
        questionLabel.setText(question[1]);
        /*choiceA.setText("A. " + A[1]);
        choiceB.setText("B. " + B[1]);
        choiceC.setText("C. " + C[1]);
        choiceD.setText("D. " + D[1]);*/
        choiceA.setText(A[1]);
        choiceB.setText(B[1]);
        choiceC.setText(C[1]);
        choiceD.setText(D[1]);
        //answer[1]=
        System.out.println(answer[questionCount]);
        questionCount++;

    }

    public void set_scene() throws IOException
    {
        System.out.println("Trying to set up question scene");
        Parent rootQuestionScreen = FXMLLoader.load(getClass().getResource("QuestionScreen.fxml"));
        scene = new Scene(rootQuestionScreen);
        System.out.println("Successfully set up question scene");
    }

    public Scene get_scene()
    {
        return scene;
    }

    @FXML public void choiceAClicked()
    {
        System.out.println(answer[questionCount]);

        if (choiceA.getText().equals(answer[questionCount-1]))
            score++;


        questionLabel.setText(question[questionCount]);
        choiceA.setText(A[questionCount]);
        choiceB.setText(B[questionCount]);
        choiceC.setText(C[questionCount]);
        choiceD.setText(D[questionCount]);
        userAnswer[questionCount] = choiceA.getText();

        if (questionCount>5)
        {
            returnToUserProfile.setVisible(true);
            choiceA.setVisible(false);
            choiceB.setVisible(false);
            choiceC.setVisible(false);
            choiceD.setVisible(false);
            questionLabel.setVisible(false);

            scoreLabel.setText("Congratulations! You have completed the quiz. :)\n"+"Score: "+Integer.toString(score)+"\nCorrect answers:\n"+question[1]+" Answer: "+answer[1]+"\n"+question[2]+" Answer: "+answer[2]+"\n"+question[3]+" Answer: "+answer[3]+"\n"+question[4]+" Answer: "+answer[4]+"\n"+question[5]+" Answer: "+answer[5]);
            System.out.println("Congratulations! You have completed the quiz. :)\n"+"Score: "+Integer.toString(score)+"\n"+question[1]+" Answer: "+answer[1]+"\n"+question[2]+" Answer: "+answer[2]+"\n"+question[3]+" Answer: "+answer[3]+"\n"+question[4]+" Answer: "+answer[4]+"\n"+question[5]+" Answer: "+answer[5]);
            scoreLabel.setVisible(true);
        }
        questionCount++;

        System.out.println(score);
    }

    @FXML public void choiceBClicked()
    {
        System.out.println(answer[questionCount]);

        if (choiceB.getText().equals(answer[questionCount-1]))
            score++;

        questionLabel.setText(question[questionCount]);


        choiceA.setText(A[questionCount]);
        choiceB.setText(B[questionCount]);
        choiceC.setText(C[questionCount]);
        choiceD.setText(D[questionCount]);
        userAnswer[questionCount] = choiceB.getText();
        if (questionCount>5)
        {
            returnToUserProfile.setVisible(true);
            choiceA.setVisible(false);
            choiceB.setVisible(false);
            choiceC.setVisible(false);
            choiceD.setVisible(false);
            questionLabel.setVisible(false);

            scoreLabel.setText("Congratulations! You have completed the quiz. :)\n"+"Score: "+Integer.toString(score)+"\nCorrect answers:\n"+question[1]+" Answer: "+answer[1]+"\n"+question[2]+" Answer: "+answer[2]+"\n"+question[3]+" Answer: "+answer[3]+"\n"+question[4]+" Answer: "+answer[4]+"\n"+question[5]+" Answer: "+answer[5]);
            System.out.println("Congratulations! You have completed the quiz. :)\n"+"Score: "+Integer.toString(score)+"\n"+question[1]+" Answer: "+answer[1]+"\n"+question[2]+" Answer: "+answer[2]+"\n"+question[3]+" Answer: "+answer[3]+"\n"+question[4]+" Answer: "+answer[4]+"\n"+question[5]+" Answer: "+answer[5]);
            scoreLabel.setVisible(true);
        }
        questionCount++;

        System.out.println(score);
    }

    @FXML public void choiceCClicked()
    {
        System.out.println(answer[questionCount]);

        if (choiceC.getText().equals(answer[questionCount-1]))
            score++;

        questionLabel.setText(question[questionCount]);

        choiceA.setText(A[questionCount]);
        choiceB.setText(B[questionCount]);
        choiceC.setText(C[questionCount]);
        choiceD.setText(D[questionCount]);
        userAnswer[questionCount] = choiceC.getText();
        if (questionCount>5)
        {
            returnToUserProfile.setVisible(true);
            choiceA.setVisible(false);
            choiceB.setVisible(false);
            choiceC.setVisible(false);
            choiceD.setVisible(false);
            questionLabel.setVisible(false);

            scoreLabel.setText("Congratulations! You have completed the quiz. :)\n"+"Score: "+Integer.toString(score)+"\nCorrect answers:\n"+question[1]+" Answer: "+answer[1]+"\n"+question[2]+" Answer: "+answer[2]+"\n"+question[3]+" Answer: "+answer[3]+"\n"+question[4]+" Answer: "+answer[4]+"\n"+question[5]+" Answer: "+answer[5]);
            System.out.println("Congratulations! You have completed the quiz. :)\n"+"Score: "+Integer.toString(score)+"\n"+question[1]+" Answer: "+answer[1]+"\n"+question[2]+" Answer: "+answer[2]+"\n"+question[3]+" Answer: "+answer[3]+"\n"+question[4]+" Answer: "+answer[4]+"\n"+question[5]+" Answer: "+answer[5]);
            scoreLabel.setVisible(true);
        }
        questionCount++;


        System.out.println(score);
    }

    @FXML public void choiceDClicked()
    {
        System.out.println(answer[questionCount]);

        if (choiceD.getText().equals(answer[questionCount-1]))
            score++;

        questionLabel.setText(question[questionCount]);

        choiceA.setText(A[questionCount]);
        choiceB.setText(B[questionCount]);
        choiceC.setText(C[questionCount]);
        choiceD.setText(D[questionCount]);
        userAnswer[questionCount] = choiceD.getText();

        if (questionCount>5)
        {
            returnToUserProfile.setVisible(true);
            choiceA.setVisible(false);
            choiceB.setVisible(false);
            choiceC.setVisible(false);
            choiceD.setVisible(false);
            questionLabel.setVisible(false);

            //congrats.setVisible(true);
            //scoreLabel.setText("Score: "+Integer.toString(score)+"\n Correct answers (in order): 1." + answer[1] + " 2. "+ answer[2] + " 3. " + answer[3]+ " 4. " + answer[4] + " 5. " + answer[5]);
            scoreLabel.setText("Congratulations! You have completed the quiz. :)\n"+"Score: "+Integer.toString(score)+"\nCorrect answers:\n"+question[1]+" Answer: "+answer[1]+"\n"+question[2]+" Answer: "+answer[2]+"\n"+question[3]+" Answer: "+answer[3]+"\n"+question[4]+" Answer: "+answer[4]+"\n"+question[5]+" Answer: "+answer[5]);
            System.out.println("Congratulations! You have completed the quiz. :)\n"+"Score: "+Integer.toString(score)+"\n"+question[1]+" Answer: "+answer[1]+"\n"+question[2]+" Answer: "+answer[2]+"\n"+question[3]+" Answer: "+answer[3]+"\n"+question[4]+" Answer: "+answer[4]+"\n"+question[5]+" Answer: "+answer[5]);
            scoreLabel.setVisible(true);
        }
        questionCount++;

        System.out.println(score);
    }

    public void scoreUpdater()
    {
        int prevScore = Integer.parseInt(Main.userProfileScreen.getSkilllevel());
        score = score + prevScore;
        WelcomeScreenController._skilllevel = Integer.toString(score);
        UserDatabase objectUserDatabase = new UserDatabase("mayosenpai","mayosenpai");
        objectUserDatabase.updateScore(Main.userProfileScreen.getUsername(),score);
    }

    @FXML public void backButtonPressed() throws IOException
    {
        scoreUpdater();
        Main.userProfileScreen.set_scene();
        Main.mainWIndow.setScene(Main.userProfileScreen.get_scene());
        Main.mainWIndow.show();
    }

    @FXML public void homeButtonPressed()
    {
        scoreUpdater();
        Main.mainWIndow.setScene(Main.welscreen.get_scene());
        Main.mainWIndow.show();
    }

    @FXML public void returnToUserProfilePressed() throws IOException
    {
        scoreUpdater();
        Main.userProfileScreen.set_scene();
        Main.mainWIndow.setScene(Main.userProfileScreen.get_scene());
        Main.mainWIndow.show();
    }



}
