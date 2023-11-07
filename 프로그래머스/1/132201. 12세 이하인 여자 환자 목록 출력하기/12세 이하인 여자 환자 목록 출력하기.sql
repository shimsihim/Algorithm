-- 코드를 입력하세요
SELECT PT_NAME,PT_NO,GEND_CD,AGE, IFNULL(TLNO, "NONE") from PATIENT  where AGE<=12 and age>=0 and GEND_CD = 'W' order by age desc, PT_NAME asc;
