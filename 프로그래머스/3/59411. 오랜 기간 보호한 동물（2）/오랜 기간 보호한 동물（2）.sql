SELECT  o.ANIMAL_ID,
        o.NAME
FROM ANIMAL_INS i
INNER JOIN ANIMAL_OUTS o ON i.ANIMAL_ID = o.ANIMAL_ID
ORDER BY DATEDIFF(o.DATETIME, i.DATETIME) DESC
LIMIT 2