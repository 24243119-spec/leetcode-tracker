-- Last updated: 7/9/2026, 10:07:43 AM
SELECT
    e.name AS Employee
FROM Employee e
JOIN Employee m
ON e.managerId = m.id
WHERE e.salary > m.salary;