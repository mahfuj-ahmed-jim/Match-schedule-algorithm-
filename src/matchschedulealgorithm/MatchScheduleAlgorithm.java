package matchschedulealgorithm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchScheduleAlgorithm {
    
    private static Team team [][];
    
    private static void showFixture() {
        
        for(int i=0; i<team[0].length; i++){
            try{
                System.out.println(team[0][i].getName()+" vs "+team[1][i].getName());
            }catch(Exception e){
                
            }
        }
        
        System.out.println("");
    
    }
    
    public static void addOddTeams(List <Team> teamList){
        
        if(teamList.size()%2==0){
            team = new Team [2][teamList.size()/2];
        }else{
            team = new Team [2][teamList.size()/2+1];
        }
        
        int count = 0;
        
        for(int i=0; i<2; i++){
            
            if(i==0){
                for(int j=0; j<team[0].length; j++){
                    team [i][j] = teamList.get(count);
                    count++;
                }
            }else{
                if(teamList.size()%2==0){
                    for(int j=teamList.size()/2-1; j>=0; j--){
                        team [i][j] = teamList.get(count);
                        count++;
                    }
                }else{
                    for(int j=teamList.size()/2-1; j>=0; j--){
                        team [i][j] = teamList.get(count);
                        count++;
                    }
                }
            }
            
        }
    
        if(teamList.size()%2==0){
            evenFixture();
        }else{
            oddFixture();
        }
        
    }
    
    public static void oddFixture(){
        
        for(int x=0; x<team[0].length*2-1; x++){
            
            showFixture();
            
            Team temp1 = team[1][0];
            Team temp2 = team[0][team[0].length-1];
            
            for(int i=0; i<2; i++){
                
                if(i==0){
                    
                    for(int j=team[0].length-1; j>0; j--){
                        team[0][j] = team[0][j-1];
                    }
                    
                }else{
                    
                    for(int j=0; j<team[0].length-2; j++){
                        team[1][j] = team[1][j+1];
                    }
                    
                }
                
            }
            
            team[0][0] = temp1;
            team[1][team[0].length-2] = temp2;
            
        }
        
    }
    
    public static void evenFixture(){
        
        for(int x=0; x<team[0].length*2-1; x++){
            
            showFixture();
            
            Team temp1 = team[1][0];
            Team temp2 = team [0][team[0].length-1];
            
            for(int i=0; i<2; i++){
                
                if(i==0){
                    
                    for(int j=team[0].length-1; j>1; j--){
                        team[0][j] = team[0][j-1];
                    }
                    
                }else{
                    for(int j=0; j<team[0].length-1; j++){
                        team[1][j] = team[1][j+1];
                    }
                    
                }
                
            }
            
            team [0][1] = temp1;
            team [1][team[0].length-1] = temp2;
                
        }
            
    }

    public static void main(String[] args) {
        
        List <Team> teamList = new ArrayList();

        Team team1 = new Team("Jim");
        Team team2 = new Team("Munna");
        Team team3 = new Team("Tamim");
        Team team4 = new Team("Fida");
        Team team5 = new Team("Mahadi");
        Team team6 = new Team("Murgi");
        Team team7 = new Team("Banu");
        Team team8 = new Team("Rafin");
        Team team9 = new Team("Rahim");
        Team team10 = new Team("Moba");
        Team team11 = new Team("Shanto");
        Team team12 = new Team("Touhid");
        Team team13 = new Team("Mahim");
        Team team14 = new Team("Yasin");
        Team team15 = new Team("Nasif");
        Team team16 = new Team("Tarif");
        Team team17 = new Team("Chayon");
        Team team18 = new Team("Anis");
        Team team19 = new Team("Ehsan");
        Team team20 = new Team("Fahad");
        
        teamList.add(team1);
        teamList.add(team2);
        teamList.add(team3);
        teamList.add(team4);
        teamList.add(team5);
        teamList.add(team6);
        teamList.add(team7);
        teamList.add(team8);
        teamList.add(team9);
        teamList.add(team10);
        /*teamList.add(team11);
        teamList.add(team12);
        teamList.add(team13);
        teamList.add(team14);
        teamList.add(team15);
        teamList.add(team16);
        teamList.add(team17);
        teamList.add(team18);
        teamList.add(team19);
        teamList.add(team20);*/
        
        Collections.shuffle(teamList);
        
        addOddTeams(teamList);
        
    }
    
}
