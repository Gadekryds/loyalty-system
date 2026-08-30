CREATE SCHEMA IF NOT EXISTS loyaltystore;

CREATE OR REPLACE FUNCTION update_modified_column()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.modified = (now() at time zone 'utc');
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
