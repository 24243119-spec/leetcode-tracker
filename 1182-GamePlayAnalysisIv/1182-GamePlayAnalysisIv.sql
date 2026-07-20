-- Last updated: 7/20/2026, 10:12:12 AM
WITH FirstLogins AS (
    SELECT 
        player_id, 
        MIN(event_date) AS first_login_date
    FROM 
        Activity
    GROUP BY 
        player_id
)
SELECT 
    ROUND(
        COUNT(a.player_id) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 
        2
    ) AS fraction
FROM 
    FirstLogins f
JOIN 
    Activity a 
ON 
    f.player_id = a.player_id 
    AND a.event_date = DATE_ADD(f.first_login_date, INTERVAL 1 DAY);