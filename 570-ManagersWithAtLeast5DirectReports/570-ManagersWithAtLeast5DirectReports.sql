-- Last updated: 7/20/2026, 10:12:08 AM
SELECT 
    m.name
FROM 
    Employee e
JOIN 
    Employee m 
ON 
    e.managerId = m.id
GROUP BY 
    m.id, m.name
HAVING 
    COUNT(e.id) >= 5;