package model2;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model2 {

    public static void main(String[] args) throws IOException {
  
        
        start st = new start();
        st.setVisible(true);
       /*Scanner sc = new Scanner(System.in);
        String doc = new String();
        String query = new String();
        String file = new String();
        String docsName[] = new String[4];
        ArrayList<String> wordslist[] = new ArrayList[4];
       for (int i = 1; i < 5; i++) {
            System.out.println("Enter Document " + i + " Name : ");
            file = sc.nextLine();
            docsName[i - 1] = file;
            System.out.println("Enter Document " + i + " Content : ");
            doc = sc.nextLine();
            write_file(file, doc);
        }
        
        for (int i = 0; i < 4; i++) {
            wordslist[i] = new ArrayList<String>();
            wordslist[i] = notreapet(token(readFile(docsName[i])));
            System.out.println(docsName[i] + wordslist[i] + "\n");
        }
       
        ArrayList<String> docs = notreapetWordsDocument(wordslist[0], wordslist[1], wordslist[2], wordslist[3]);
        Collections.sort(docs);
        ArrayList<Integer> Posting = new ArrayList<Integer>();
        HashMap<String, ArrayList<Integer>> tokensWDocsId = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < docs.size(); i++) {
            Posting = getPosting(docs.get(i), wordslist);
            System.out.println(docs.get(i) + " " + Posting);
            tokensWDocsId.put(docs.get(i), Posting);
        }
        System.out.println("Enter Query : ");
        query = sc.nextLine();
        ArrayList<ArrayList<Integer>> result = queryResult(query,tokensWDocsId);
                for (int j = 0; j < result.size(); j++) {
            if (result.get(j).contains(1)) {
                System.out.println(docsName[0]);
            }
            if (result.get(j).contains(2)) {
                System.out.println(docsName[1]);
            }
            if (result.get(j).contains(3)) {
                System.out.println(docsName[2]);
            }
            if (result.get(j).contains(4)) {
                System.out.println(docsName[3]);
            }
        }
        System.out.println(result);*/
    }

    public static ArrayList<ArrayList<Integer>> queryResult(String query, HashMap<String, ArrayList<Integer>> tokensWDocsId) {
ArrayList<ArrayList<Integer>> allPosting = new ArrayList<ArrayList<Integer>>();
        String[] quList = query.split(" ");
        for (int i = 0; i < quList.length; i++) {
            ArrayList<Integer> postingOfNot = null;
            ArrayList<Integer> postingOfToken = null;
            if (quList[i].toUpperCase().equals("NOT")) {
                int afterNot = i + 1;
                postingOfNot = tokensWDocsId.get(quList[afterNot]);
                for (int k = 1; k < 5; k++){
                    if (postingOfNot.contains(new Integer(k))) {
                        postingOfNot.remove(new Integer(k));
                    }
                    else{
                        postingOfNot.add(new Integer(k));
                    }
                }
                allPosting.add(postingOfNot);
            }
        }

        for (int i = 0; i < quList.length; i++) {
            ArrayList<Integer> postingBeAnd = null;
            ArrayList<Integer> postingAfAnd = null;
            if (quList[i].toUpperCase().equals("AND")) {
                int afterAnd = i + 1;
                int beforAnd = i - 1;
                postingAfAnd = tokensWDocsId.get(quList[afterAnd]);
                postingBeAnd = tokensWDocsId.get(quList[beforAnd]);
                allPosting.add(anding(postingAfAnd,postingBeAnd));
            }
        }
        
        ArrayList<Integer> rrrrrrr = new ArrayList<Integer>();
        for (int i = 0;i < quList.length; i++) {
            ArrayList<Integer> postingBeOr = null;
            ArrayList<Integer> postingAfOr = null;
            
            if (quList[i].toUpperCase().equals("OR")) {
                allPosting.remove(rrrrrrr);
                int afterOr = i + 1;
                int beforeOr = i - 1;
                postingBeOr = tokensWDocsId.get(quList[beforeOr]);
                postingAfOr = tokensWDocsId.get(quList[afterOr]);
                postingAfOr.addAll(postingBeOr);
                LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
                lhs.addAll(postingAfOr);
                postingAfOr.clear();
                postingAfOr.addAll(lhs);
                Collections.sort(postingAfOr);
                rrrrrrr = postingAfOr;
                allPosting.add(postingAfOr);
            }
        }
        if(quList.length==1)
        {
            ArrayList<Integer> posting = null;
            posting = tokensWDocsId.get(quList[0]);
            allPosting.add(posting);
        }
       return allPosting;
        
    }
    
    public static ArrayList<Integer> anding (ArrayList<Integer> b,ArrayList<Integer> f){
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i=0;i<f.size();i++){
            for(int j=0;j<b.size();j++)
            {
               if(f.get(i)==b.get(j))
               {
                   result.add(f.get(i));
               }
            }
        }
        return result;
    }

    
    public static ArrayList<Integer> queryPosting (HashMap<String,ArrayList<Integer>> tokensWDocsId,ArrayList<String> query){
        
        ArrayList<Integer> tokenPosting = new ArrayList<Integer>();
        
        

        
        
        return tokenPosting;
    }
    public static ArrayList<Integer> getPosting(String token, ArrayList<String> docs[]) {

        ArrayList<Integer> Posting = new ArrayList<Integer>();

        if (docs[0].contains(token)) {
            Posting.add(1);
        }
        if (docs[1].contains(token)) {
            Posting.add(2);
        }
        if (docs[2].contains(token)) {
            Posting.add(3);
        }
        if (docs[3].contains(token)) {
            Posting.add(4);
        }

        return Posting;
    }

    public static void write_file(String file_name, String doc) {

        Scanner sc = new Scanner(System.in);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(file_name + ".txt"));
            bw.write(doc);
            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(Model2.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String readFile(String name) throws FileNotFoundException, IOException {
        String everything = null;
        BufferedReader br = null;
        String line = null;
        br = new BufferedReader(new FileReader(name + ".txt"));
        StringBuilder sb = new StringBuilder();
        line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }

        everything = sb.toString();
        br.close();
        //br.close();
        return everything;
    }

    public static ArrayList<String> token(String document) {
        String words[];
        ArrayList<String> word = new ArrayList<String>();
        String[] lines = document.split(System.lineSeparator());

        for (int i = 0; i < lines.length; i++) {
            words = lines[i].split(" ");
            for (int j = 0; j < words.length; j++) {
                word.add(words[j]);
            }

        }
        return word;
    }

    public static ArrayList<String> notreapet(ArrayList<String> wordsFile) {
        String[] stopWords = {"are", "is", "and", "or", "the", "a", "we", "an", ",", "than", " ", "?", "!", "not", "then", "@", "$", "%", "as",
            "able", "about", "above", "away", "awfully", "be", "became", "because", "become", "becomes", "becoming", "been", "before",
            "beforehand", "behind", "being", "believe", "below", "beside", "besides", "best", "better", "between", "beyond", "both",
            "brief", "but", "by", "cannot", "her", "his", "there", "these", "that", "those", "its", "can", "too"};
        ArrayList<String> listword = new ArrayList<String>();
        for (String word : wordsFile) {
            if (!listword.contains(word)) {
                listword.add(word);
            }
        }
        for (int i = 0; i < stopWords.length; i++) {
            listword.remove(stopWords[i]);
        }

        return listword;
    }

    public static ArrayList<String> notreapetWordsDocument(ArrayList<String> wordsFile1, ArrayList<String> wordsFile2, ArrayList<String> wordsFile3, ArrayList<String> wordsFile4) {
        String[] stopWords = {"are", "too", "is", "and", "or", "the", "a", "we", "an", ",", "than", " ", "?", "!", "not", "then", "@", "$", "%", "as",
            "able", "about", "above", "away", "awfully", "be", "became", "because", "become", "becomes", "becoming", "been", "before",
            "beforehand", "behind", "being", "believe", "below", "beside", "besides", "best", "better", "between", "beyond", "both",
            "brief", "but", "by", "cannot", "her", "his", "there", "these", "that", "those", "its", "can"};
        ArrayList<String> listword = new ArrayList<String>();
        for (String word : wordsFile1) {
            if (!listword.contains(word)) {
                listword.add(word);
            }
        }
        for (String word : wordsFile2) {
            if (!listword.contains(word)) {
                listword.add(word);
            }
        }
        for (String word : wordsFile3) {
            if (!listword.contains(word)) {
                listword.add(word);
            }
        }
        for (String word : wordsFile4) {
            if (!listword.contains(word)) {
                listword.add(word);
            }
        }
        for (int i = 0; i < stopWords.length; i++) {
            listword.remove(stopWords[i]);
        }
        return listword;
    }


    }
        
