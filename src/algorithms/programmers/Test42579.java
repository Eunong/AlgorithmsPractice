package algorithms.programmers;

import java.util.*;

// category : hash
// https://school.programmers.co.kr/learn/courses/30/lessons/42579
public class Test42579 {
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresTotalPlayCntMap    = new HashMap<>(); // Map<장르, 장르 별 전체 노래 재생 횟수>
        Map<String, Integer> genresMusicCntMap        = new HashMap<>(); // Map<장르, 장르 별 노래(고유번호가 i인 노래) 개수>
        Map<String, List<int[]>> genresTopTwoMusicMap = new HashMap<>(); // Map<장르, 장르 별 재생 횟수가 가장 높은 순으로 노래 리스트<int[0]:노래 별 재생 횟수, int[1]:노래고유번호index>

        int curPlayCnt;
        String curGenres;

        // 입력 배열을 loop 돌면서 필요한 map 저장
        for(int i = 0; i < genres.length; i++) {
            curPlayCnt = plays[i];
            curGenres = genres[i];

            genresTotalPlayCntMap.put(curGenres, genresTotalPlayCntMap.getOrDefault(curGenres, 0) + curPlayCnt); // 장르 별 전체 노래 재생 횟수 누적 저장
            genresMusicCntMap.put(curGenres, genresMusicCntMap.getOrDefault(curGenres, 0) + 1); // 장르 별 전체 노래 개수 누적 저장

            // 장르 별 재생 횟수가 가장 높은 순으로 노래 리스트 저장
            List<int[]> curTopTwoGenresList = genresTopTwoMusicMap.get(curGenres);

            if(curTopTwoGenresList == null || curTopTwoGenresList.isEmpty()) { // 장르 별 노래가 처음 등장한 경우는 신규 생성 및 0번째 위치에 add
                curTopTwoGenresList = new ArrayList<>();
                curTopTwoGenresList.add(new int[]{curPlayCnt, i});
            } else if(curPlayCnt > curTopTwoGenresList.get(0)[0]){ // 재생 횟수가 가장 큰지 우선 비교
                curTopTwoGenresList.add(0, new int[]{curPlayCnt, i});
            } else if(curTopTwoGenresList.size() < 2 // 장르 별 노래 재생횟수가 최대가 아니고 노래가 2개 미만으로 등장했을 경우에는 2번째 위치에 저장
                    || curPlayCnt > curTopTwoGenresList.get(1)[0]) { // 재생횟수 2등보다 큰지 까지만 비교해서 저장 (문제에서 장르 별 2건까지만 수록한다고 되어있으므로 재생 횟수가 2등보다 낮은 경우는 비교 및 저장 안함)
                curTopTwoGenresList.add(1, new int[]{curPlayCnt, i});
            }

            genresTopTwoMusicMap.put(curGenres, curTopTwoGenresList);
        }

        System.out.println("genresTotalPlayCntMap : " + genresTotalPlayCntMap);
        System.out.println("genresMusicCntMap : " + genresMusicCntMap);
        System.out.println("topTwoGenresMap : " + genresTopTwoMusicMap);
        
        // 전체 재생횟수가 가장 높은 순으로 장르명(key) 정렬한 List 생성
        List<String> sortedGenresList = new ArrayList<>(genresTotalPlayCntMap.keySet());
        Collections.sort(sortedGenresList, (o1, o2) -> genresTotalPlayCntMap.get(o2).compareTo((genresTotalPlayCntMap.get(o1))));

        // 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하기 때문에 장르 별로 출시할 수 있는 건수를 더함 => 결과 배열의 사이즈 구하기
        int recordingCnt = 0;
        for(int n : genresMusicCntMap.values()) {
            recordingCnt += (n>2) ? 2 : n;
        }

        // 최종 결과 저장
        int[] recordingList = new int[recordingCnt];
        int genrePos = 0;
        List<int[]> playList;
        for(String genre : sortedGenresList) {
            playList = genresTopTwoMusicMap.get(genre);
            for(int i = 0; i < 2 && i < playList.size(); i++) {
                recordingList[genrePos++] = playList.get(i)[1];
            }
        }

        return recordingList;
    }

    public static void main(String[] args) {
        System.out.println("TestCase1 : " + solution(new String[]{"classic", "pop"}, new int[]{500, 700}));
        System.out.println("TestCase2 : " + solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));
    }
}
