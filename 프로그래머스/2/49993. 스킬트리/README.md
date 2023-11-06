# 문제풀이
해당 문제는 선행스킬이 존재하는 스킬들이 존재하며 주어진 스킬트리가 이러한 선행조건을 만족하는지 확인하는 문제이다<br/>
1. 문제의 접근은 우선 선행스킬트리 목록들을 순서대로 HashMap에 해당 스킬의 {문자 , 1} , {문자 , 2},{문자 , 3} 형식으로 저장한다. <br/>
2. 주어진 스킬트리 리스트를 순회하며 가능한지 여부를 판단하고 가능하면 결과값에 +1을 해준다. <br/>
3. 가능한지 여부는 우선 초기 preindex를 0으로 설정해준다(선행스킬트리들은 1,2,3,으로 1부터 시작) 이후 문자들을 탐색하며 Map에 저장된 문자열이라면<br/>
    해당 순위가 preindex +1의 값이라면 반복문을 지속하고 아니라면 false를 반환한다.

# [level 2] 스킬트리 - 49993 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/49993) 

### 성능 요약

메모리: 80.8 MB, 시간: 0.13 ms

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2023년 11월 1일 21:29:36

### 문제 설명

<p>선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.</p>

<p>예를 들어 선행 스킬 순서가 <code>스파크 → 라이트닝 볼트 → 썬더</code>일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.</p>

<p>위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 <code>스파크 → 힐링 → 라이트닝 볼트 → 썬더</code>와 같은 스킬트리는 가능하지만, <code>썬더 → 스파크</code>나 <code>라이트닝 볼트 → 스파크 → 힐링 → 썬더</code>와 같은 스킬트리는 불가능합니다.</p>

<p>선행 스킬 순서 skill과 유저들이 만든 스킬트리<sup id="fnref1"><a href="#fn1">1</a></sup>를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.</p>

<h5>제한 조건</h5>

<ul>
<li>스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.</li>
<li>스킬 순서와 스킬트리는 문자열로 표기합니다.

<ul>
<li>예를 들어, <code>C → B → D</code> 라면 "CBD"로 표기합니다</li>
</ul></li>
<li>선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.</li>
<li>skill_trees는 길이 1 이상 20 이하인 배열입니다.</li>
<li>skill_trees의 원소는 스킬을 나타내는 문자열입니다.

<ul>
<li>skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.</li>
</ul></li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>skill</th>
<th>skill_trees</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td><code>"CBD"</code></td>
<td><code>["BACDE", "CBADF", "AECB", "BDA"]</code></td>
<td>2</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<ul>
<li>"BACDE": B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.</li>
<li>"CBADF": 가능한 스킬트리입니다.</li>
<li>"AECB": 가능한 스킬트리입니다.</li>
<li>"BDA": B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.</li>
</ul>

<div class="footnotes">
<hr>
<ol>

<li id="fn1">
<p>스킬 트리: 유저가 스킬을 배울 순서&nbsp;<a href="#fnref1">↩</a></p>
</li>

</ol>
</div>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
