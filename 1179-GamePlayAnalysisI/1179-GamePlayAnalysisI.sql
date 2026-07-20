-- Last updated: 7/20/2026, 10:12:01 AM
SELECT 
    player_id, 
    MIN(event_date) AS first_login
FROM 
    Activity
GROUP BY 
    player_id;