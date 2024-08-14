SELECT  ri.REST_ID,
        ri.REST_NAME,
        ri.FOOD_TYPE,
        ri.FAVORITES,
        ri.ADDRESS,
        ROUND(AVG(rr.REVIEW_SCORE), 2) AS SCORE
FROM REST_INFO ri
INNER JOIN REST_REVIEW rr ON ri.REST_ID = rr.REST_ID
WHERE ADDRESS LIKE '서울%'
GROUP BY ri.REST_NAME
ORDER BY SCORE DESC, ri.FAVORITES DESC