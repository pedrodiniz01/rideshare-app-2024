INSERT INTO DRIVERS (id, name, email) VALUES (1,'John Doe', 'john@example.com');
INSERT INTO DRIVERS (id, name, email) VALUES (2, 'Jane Smith', 'jane@example.com');

INSERT INTO DRIVERS_LOCATION (driver_id, latitude, longitude) VALUES (1, 37.7749, -122.4194);
INSERT INTO DRIVERS_LOCATION (driver_id, latitude, longitude) VALUES (2, 40.7128, -74.0060);

INSERT INTO RIDE_REQUEST_ACCEPTED (id, message) VALUES (1, 'Driver ID 1 will pick up User Id 2');
INSERT INTO RIDE_REQUEST_ACCEPTED (id, message) VALUES (2, 'Driver ID 2 will pick up User Id 1');

INSERT INTO RIDERS (id, name, email) VALUES (1, 'Alice', 'alice@example.com');
INSERT INTO RIDERS (id, name, email) VALUES (2, 'Bob', 'bob@example.com');

INSERT INTO RIDERS_REQUEST (rider_id, latitude_pick_up, longitude_pick_up, latitude_drop_off, longitude_drop_off, ride_id) VALUES (1, 37.7749, -122.4194, 37.3352, -122.0326, 1);
INSERT INTO RIDERS_REQUEST (rider_id, latitude_pick_up, longitude_pick_up, latitude_drop_off, longitude_drop_off, ride_id) VALUES (2, 40.7128, -74.0060, 34.0522, -118.2437, 2);


