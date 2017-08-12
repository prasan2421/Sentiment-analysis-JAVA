package project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FinalView {

    ArrayList<String> ar = new ArrayList<String>();

    ArrayList<String> ar2 = new ArrayList<String>();

    ArrayList<Integer> ar3 = new ArrayList<Integer>();

    Porter p = new Porter();

    File fileName = new File("Friends.txt");

    private Scanner x;
    private Scanner y;

    public void openFile() {
        try {

            x = new Scanner(new File("chinese.txt"));
            y = new Scanner(new File("chinese.txt"));

        } catch (Exception e) {
            System.out.println("Could not find file");
        }
    }

    public void readFile() throws IOException {
        System.out.println("Whole Documents for finding Distinct Terms");
        System.out.println();

        while (x.hasNext()) {
            System.out.println();
            String b = x.nextLine();
            String c = b.toLowerCase();

            System.out.println(c);

            StringTokenizer st = new StringTokenizer(c, " .");
            System.out.println();

            while (st.hasMoreTokens()) {
                String d = st.nextToken();
                System.out.println(d);

                ar.add(d);
                System.out.println(ar);

            }

            //removing stop words starts
            String stopwords[] = {"i", "to", "the", "go", "my", "is", "up", "in", "all", "this", "has", "so", "now", "am", "gonna", "some", "on", "me"};

            for (int i = 0; i < stopwords.length; i++) {
                for (int j = 0; j < ar.size(); j++) {
                    if (ar.get(j).equals(stopwords[i])) {
                        ar.remove(j);
                    }

                }

            }
            System.out.println();
            System.out.println("The stop words are removed...");
            System.out.println(ar);
    //stopwords removing  finished

        }

        //Stemming
        System.out.println();

        System.out.println("Stemming performed...");

        for (int k = 0; k < ar.size(); k++) {

            ar.set(k, p.stripAffixes(ar.get(k)));

        }

          //Stemming finish
        //HashSet for distinct terms
        System.out.println(ar);

        HashSet<String> set = new HashSet<String>(ar);

        System.out.println();
        System.out.println("Set of Distinct terms...");
        System.out.println(set);
        System.out.println();

            //HashSet finish
            //For INDIVIDUAL DOCUMENTS
        System.out.println("Individual Documents");
        System.out.println();

        System.out.println();
        while (y.hasNext()) {
            String e = y.nextLine();
            String f = e.toLowerCase();

            System.out.println(f);

            StringTokenizer st = new StringTokenizer(f, " .");
            System.out.println();

            while (st.hasMoreTokens()) {
                String g = st.nextToken();
                System.out.println(g);

                ar2.add(g);
                System.out.println(ar2);

            }

            String stopwords[] = {"i", "to", "the", "go", "my", "is", "up", "in", "all", "this", "has", "so", "now", "am", "gonna", "some", "on", "me"};

            for (int i = 0; i < stopwords.length; i++) {
                for (int j = 0; j < ar2.size(); j++) {
                    if (ar2.get(j).equals(stopwords[i])) {
                        ar2.remove(j);
                    }

                }
            }

            System.out.println();
            System.out.println("removing stop words");
            System.out.println(ar2);

            System.out.println();

            for (int k = 0; k < ar2.size(); k++) {

                ar2.set(k, p.stripAffixes(ar2.get(k)));

            }
            System.out.println("docs=\t" + ar2);

            ArrayList<String> ar1 = new ArrayList<String>(set);

            HelloWorld(ar1, ar2);

            ar2.removeAll(ar2);

        }
    }

    public void HelloWorld(ArrayList<String> arList, ArrayList<String> strList) {

        System.out.println();
        System.out.println("THIS IS FIRST ARRAYLIST" + "\t" + arList);
        System.out.println("THIS IS SECOND ARRAYLIST" + "\t" + strList);
        System.out.println();
        for (int i = 0; i < arList.size(); i++) {

            int counter = 0;

            for (int j = 0; j < strList.size(); j++) {

                if (arList.get(i).equals(strList.get(j))) {
                    counter++;

                }
                if (j == strList.size() - 1) {
                    System.out.println("the term\t" + arList.get(i) + "\t" + "present" + "\t" + counter + "\t" + "times");

                    ar3.add(counter);
                    System.out.println(ar3);
                    System.out.println();
                }
            }
        }

        ar3.removeAll(ar3);

    }

    public static void main(String[] args) throws IOException {
        FinalView f = new FinalView();
        f.openFile();
        f.readFile();

    }
}
