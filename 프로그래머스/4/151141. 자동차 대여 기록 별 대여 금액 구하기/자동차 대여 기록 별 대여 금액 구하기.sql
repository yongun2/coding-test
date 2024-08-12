# 13440

SELECT  
        h.HISTORY_ID AS HISTORY_ID,
        FLOOR((c.DAILY_FEE - (c.DAILY_FEE * IFNULL(p.DISCOUNT_RATE, 0) / 100)) * h.DIFF) AS FEE
FROM (
    SELECT  HISTORY_ID,
            CAR_ID,
            DATEDIFF(END_DATE, START_DATE) + 1 AS DIFF,
        (
            CASE
                WHEN DATEDIFF(END_DATE, START_DATE) + 1 < 7
                    THEN NULL
                WHEN DATEDIFF(END_DATE, START_DATE) + 1 < 30
                    THEN '7일 이상'
                WHEN DATEDIFF(END_DATE, START_DATE) + 1 < 90
                    THEN '30일 이상'
                ELSE
                    '90일 이상'
            END
        ) AS DURATION_TYPE
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
) h
INNER JOIN CAR_RENTAL_COMPANY_CAR c ON h.CAR_ID = c.CAR_ID
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN p ON c.CAR_TYPE = p.CAR_TYPE
    AND h.DURATION_TYPE = p.DURATION_TYPE
WHERE c.CAR_TYPE = '트럭'
ORDER 
    BY  
        FEE DESC,
        h.HISTORY_ID DESC