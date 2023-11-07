-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER,substr(DATE_OF_BIRTH,1,10) as DATE_OF_BIRTH from MEMBER_PROFILE 
where TLNO is not null and gender = 'W' and substr(DATE_OF_BIRTH,6,2) = '03' order by MEMBER_ID