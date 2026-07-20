-- Last updated: 7/20/2026, 10:12:05 AM
SELECT 
    name
FROM 
    Customer
WHERE 
    referee_id <> 2 
    OR referee_id IS NULL;
    