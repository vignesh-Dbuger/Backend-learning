
fetchquery=SELECT * FROM product WHERE product_id=:id;

updatequery=UPDATE product set stock_count=:count-1 WHERE product_id=:id AND stock_count > 0;

ordercreate=INSERT INTO ordersdetail (customer_email,product_id) VALUES(:email,:id);

fetchorder=SELECT * FROM ordersdetail WHERE order_id=:id;