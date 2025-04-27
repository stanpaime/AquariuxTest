INSERT INTO User_Details (id, name, usdt_balance, btc_balance, eth_balance) 
VALUES (1, 'Alice', 50000.00, 0, 0);

INSERT INTO User_Details (id, name, usdt_balance, btc_balance, eth_balance) 
VALUES (2, 'John', 50000.00, 0, 0);

INSERT INTO User_Details (id, name, usdt_balance, btc_balance, eth_balance) 
VALUES (3, 'Lotus', 50000.00, 0, 0);

INSERT INTO Crypto_Details (crypto_pair, bid_price, ask_price, last_updated) 
VALUES ('BTCUSDT', 94000.00, 93900.00, CURRENT_TIMESTAMP());

INSERT INTO Crypto_Details (crypto_pair, bid_price, ask_price, last_updated) 
VALUES ('ETHUSDT', 1806.00, 1806.00, CURRENT_TIMESTAMP());