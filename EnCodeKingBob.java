
/**
 * Created by Mr.TOTO on 4/7/2016.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class EnCodeKingBob {
    public static void main(String[] args){
        char[] origin = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] trans = new char[26];
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());
            for(int i=0; i<n; i++){
                System.out.println("Enter k");
                int k = Integer.parseInt(reader.readLine());
                int count = 0, column=k-1, index =k-1;
                while(count<26){
                    trans[count]=origin[index];
                    count++;
                    index+=k;
                    if(index>25){
                        column--;
                        index=column;
                    }
                }
//                for (int a=0; a<26; a++){
//                    System.out.print(origin[a]+" ");
//                }
//                System.out.println();
//                for (int a=0; a<26; a++){
//                    System.out.print(trans[a]+" ");
//                }
                System.out.println("\nEnter String");
                String s = reader.readLine();
                for(int j=0; j<s.length(); j++){
                    if(s.charAt(j)==' '){
                        System.out.print(" ");
                    }else{
                        char c = trans[(s.charAt(j)-97)];
                        System.out.print(origin[(c-97+k)%26]);

                    }
                }
                System.out.println();
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }
    
}
