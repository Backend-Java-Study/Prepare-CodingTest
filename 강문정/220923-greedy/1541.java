import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("-");	// "-" 기준으로 분리
        int answer = 0;

        for (int i = 0; i < s.length; i++) {
            int sum = 0;
            String[] s2 = s[i].split("\\+");
            for(int j = 0; j < s2.length; j++) {
                sum += Integer.parseInt(s2[j]);
            }
            if (i == 0) {
                answer += sum; // 처음에 나오는 묶음인 경우는 더해준다 
            } else {
                answer -= sum;  
            }
        }
        System.out.println(answer);
    }
}
