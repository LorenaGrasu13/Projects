package org.example.GUI;

import org.example.Logic.Operatii;
import org.example.Model.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Controller {
    private Operatii o;
    private View view;

    public Controller(Operatii op, View view) {
            o = op;
            this.view = view;

            // ... Add listeners to the view.
            view.addMulListener(new MulListener());
            view.addAddListener(new AddListener());
            view.addSubListener(new SubListener());
            view.addClearListener(new ClearListener());
            view.addDerListener(new DerivListener());
            view.addIntegralListener(new IntegralListener());
        }

        ////////////////////////////////////////// inner class MultiplyListener
        /**
         * When a mulitplication is requested. 1. Get the user input number from the
         * View. 2. Call the model to mulitply by this number. 3. Get the result from
         * the Model. 4. Tell the View to display the result. If there was an error,
         * tell the View to display it.
         */
        class MulListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String userInput1 = "";
                String userInput2 = "";
                try {
                    userInput1 = view.getUserInput1();
                    userInput2 = view.getUserInput2();
                    Polinom p1=new Polinom(userInput1);
                    Polinom p2=new Polinom(userInput2);
                    Polinom result=o.inmultire(p1,p2);
                    view.setTotal(result.afis());

                } catch (NumberFormatException nfex) {
                    view.showError("Bad input");
                }
            }
        }// end inner class MultiplyListener

        class AddListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String userInput1 = "";
                String userInput2 = "";
                try {
                    userInput1 = view.getUserInput1();
                    userInput2 = view.getUserInput2();
                    Polinom p1=new Polinom(userInput1);
                    Polinom p2=new Polinom(userInput2);
                    Polinom result=o.adunare(p1,p2);
                    view.setTotal(result.afis());

                } catch (NumberFormatException nfex) {
                    view.showError("Bad input");
                }
            }
        }

    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1 = "";
            String userInput2 = "";
            try {
                userInput1 = view.getUserInput1();
                userInput2 = view.getUserInput2();
                Polinom p1=new Polinom(userInput1);
                Polinom p2=new Polinom(userInput2);
                Polinom result=o.scadere(p1,p2);
                view.setTotal(result.afis());

            } catch (NumberFormatException nfex) {
                view.showError("Bad input");
            }
        }
    }

    class DerivListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1 = "";
            try {
                userInput1 = view.getUserInput1();
                Polinom p1=new Polinom(userInput1);
                Polinom result=o.derivare(p1);
                view.setTotal(result.afis());

            } catch (NumberFormatException nfex) {
                view.showError("Bad input");
            }
        }
    }

    class IntegralListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1 = "";
            try {
                userInput1 = view.getUserInput1();
                Polinom p1=new Polinom(userInput1);
                Polinom result=o.integrare(p1);
                view.setTotal("ct" + result.afis());

            } catch (NumberFormatException nfex) {
                view.showError("Bad input");
            }
        }
    }
        //////////////////////////////////////////// inner class ClearListener
        class ClearListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                o.reset();
                view.reset();
            }
        }// end inner class ClearListener
}
