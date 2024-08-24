WITH RECURSIVE DAY AS (
    SELECT 
        0 AS HOUR,
        0 AS COUNT    
    UNION ALL
    SELECT 
        HOUR + 1,
        0 AS COUNT
    FROM DAY
    WHERE HOUR < 23
)
SELECT
    d.HOUR,
    COALESCE(ADEPT.COUNT, 0) AS COUNT
FROM DAY d
LEFT JOIN 
    (
        SELECT 
            HOUR(DATETIME) AS HOUR,
            COUNT(*) AS COUNT
        FROM ANIMAL_OUTS
        GROUP BY 
            HOUR
        ORDER BY 
            NAME 
    ) AS ADEPT ON ADEPT.HOUR = d.HOUR
ORDER BY d.HOUR