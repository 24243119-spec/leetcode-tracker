-- Last updated: 7/20/2026, 10:12:02 AM
SELECT 
    customer_number
FROM 
    Orders
GROUP BY 
    customer_number
ORDER BY 
    COUNT(order_number) DESC
LIMIT 1;