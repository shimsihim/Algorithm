# 문제 풀이
정사각형의 카펫트는 필연적으로 각각의 모서리 4개를 갖는다. <br/> 
이것만 파악한다면 문제가 매우 쉬워진다. <br/> 
예시문제를 가져와 설명하자면 갈10 노2인 카페트가 존재할 시 갈색은 모서리를 제외한 6개의 칸을 갖는다.<br/>
이는 모서리를 제외한 (가로+세로)*2 = 6이라는 말이므로 가로+세로의 값은 2+1이다(가로>=세로)  <br/>
하지만 위에서 구한 값은 실제 가로*세로가 아닌 모서리를 제외한 값이며 위에서 구한 가로와 세로의 크기는 테두리를 제외한 값 <br/>
즉, 노란색 타일의 크기가 된다. => 전체 카페트의 크기는 위에서 구한 (가로+2)*(세로+2) 이다. <br/>

추가로 위의 예시에서는 1가지의 경우만 가능하지만 가로+세로 = 10일 경우 (5,5)[5,5가 세로가 갖는 최대 값],(6,4),(7,3),(8,2),(9,1) 까지 가능하므로<br/>
while 반복을 통해서 각각의 가로*세로 = yellow가 되면 return해주면 된다.


# [level 2] 카펫 - 42842 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42842) 

### 성능 요약

메모리: 75.7 MB, 시간: 0.02 ms

### 구분

코딩테스트 연습 > 완전탐색

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 11월 5일 21:39:19

### 문제 설명

<p>Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/b1ebb809-f333-4df2-bc81-02682900dc2d/carpet.png" title="" alt="carpet.png"></p>

<p>Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.</p>

<p>Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.</p>

<h5>제한사항</h5>

<ul>
<li>갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.</li>
<li>노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.</li>
<li>카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>brown</th>
<th>yellow</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>10</td>
<td>2</td>
<td>[4, 3]</td>
</tr>
<tr>
<td>8</td>
<td>1</td>
<td>[3, 3]</td>
</tr>
<tr>
<td>24</td>
<td>24</td>
<td>[8, 6]</td>
</tr>
</tbody>
      </table>
<p><a href="http://hsin.hr/coci/archive/2010_2011/contest4_tasks.pdf" target="_blank" rel="noopener">출처</a></p>

<p>※ 공지 - 2020년 2월 3일 테스트케이스가 추가되었습니다.<br>
※ 공지 - 2020년 5월 11일 웹접근성을 고려하여 빨간색을 노란색으로 수정하였습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
