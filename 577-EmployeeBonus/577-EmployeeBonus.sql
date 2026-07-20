-- Last updated: 7/20/2026, 10:12:06 AM
SELECT 
    e.name, 
    b.bonus
FROM 
    Employee e
LEFT JOIN 
    Bonus b 
ON 
    e.empId = b.empId
WHERE 
    b.bonus < 1000 
    OR b.bonus IS NULL;