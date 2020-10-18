package level3;
// 좌표 구현할 필요 없이 boolean[][] 으로 기둥, 보 표시만 해주는거였다. 
// https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B8%B0%EB%91%A5%EA%B3%BC-%EB%B3%B4-%EC%84%A4%EC%B9%98-Java
public class 기둥과보설치 {
	// 좌표(x, y) 기준 기둥은 위쪽, horizon은  오른쪽
	static final int PILLAR = 0;
	static final int BEAM = 1;
	static final int DESTRUCT = 0;
	static final int CONSTRUCT = 1;
	
	static boolean[][] pillars, beams; // 기둥, 보 
	
	public static void main(String[] args) {
		
		int[][] build_frame =  {{1,0,0,1}, // (x y) a(0은 기둥, 1은 보) b(0은 삭제, 1은 설치)
								{1,1,1,1},
								{2,1,0,1},
								{2,2,1,1},
								{5,0,0,1},
								{5,1,0,1},
								{4,2,1,1},
								{3,2,1,1}};
		
		int n = 5;
		/*
		int[][] build_frame =  {{0,0,0,1}, // (x y) a(0은 기둥, 1은 보) b(0은 삭제, 1은 설치)
								{2,0,0,1}, // 지워짐
								{4,0,0,1},
								{0,1,1,1},
								{1,1,1,1},
								{2,1,1,1},
								{3,1,1,1},
								{2,0,0,0}, // 지워짐
								{1,1,1,0}, // 무시된다.
								{2,2,0,1}}; // 무시된다.
		*/
		// x좌표 기준 오름차순, 같을 경우 y좌표 기준 오름차순
		
		int structureCount = 0;
		
		pillars = new boolean[n+3][n+3];
		beams = new boolean[n+3][n+3];
		
		for (int i=0; i<build_frame.length; i++) {
			int x = build_frame[i][0] + 1;
			int y = build_frame[i][1] + 1;
			int structureType = build_frame[i][2];
			int commandType = build_frame[i][3];
			
			if (commandType == CONSTRUCT) {
				if (structureType == PILLAR && canConstructPillar(x, y)) {
					pillars[x][y] = true;
					structureCount++;
				}
				if (structureType == BEAM && canConstructPillar(x, y)) {
					beams[x][y] = true;
					structureCount++;
				}
			}
			else if (commandType == DESTRUCT){ // 일단 철거 하고 cacDestruct인지 확인하는게 중요 
				if (structureType == PILLAR) {
					pillars[x][y] = false;
				}
				else if (structureType == BEAM) {
					beams[x][y] = false;
				}
				
				if (canDestruct(x, y, structureType, n)) {
					structureCount--;
					continue;
				}
				if (structureType == PILLAR) {
					pillars[x][y] = true;
				}
				else if (structureType == BEAM) {
					beams[x][y] = true;
				}
			}
		}
		
		int index = 0;
        int[][] answer = new int[structureCount][3];
        
        for(int i = 1 ; i <= n + 1 ; ++i){
            for(int j = 1 ; j <= n + 1 ; ++j){
                if(pillars[i][j]) answer[index++] = new int[]{i - 1, j - 1, PILLAR};
                if(beams[i][j]) answer[index++] = new int[]{i - 1, j - 1, BEAM};
            }
        }
        
        for (int i=0; i<structureCount; i++) {
        	for (int j=0; j<3; j++) {
        		System.out.print(answer[i][j]+" ");
        	}
        	System.out.println();
        }
	}
	
	private static boolean canConstructPillar(int x, int y){
        return y == 1 || pillars[x][y - 1] || beams[x][y] || beams[x - 1][y];
    }
    
    private static boolean canConstructBeam(int x, int y){
        return pillars[x][y - 1] || pillars[x + 1][y - 1] || (beams[x - 1][y] && beams[x + 1][y]);
    }
    
    private static boolean canDestruct(int x, int y, int structureType, int n){       
        for(int i = 1 ; i <= n + 1 ; ++i){
            for(int j = 1 ; j <= n + 1 ; ++j){
                if(pillars[i][j] && !canConstructPillar(i, j)){
                    return false;
                }
                if(beams[i][j] && !canConstructBeam(i, j)){
                    return false;
                }
            }
        }
        
        return true;
    }

}
