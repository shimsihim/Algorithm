-- 코드를 입력하세요
select PT_NAME,PT_NO,GEND_CD,AGE, IFNULL(TLNO,'NONE') AS TLNO from PATIENT  where AGE<=12 AND GEND_CD = 'W' order by AGE desc , PT_NAME