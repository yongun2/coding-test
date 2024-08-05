# Write your MySQL query statement below
SELECT m.name AS 'name'
FROM Employee e
INNER JOIN Employee m ON e.managerId = m.id
GROUP BY m.id
HAVING COUNT(*) >= 5