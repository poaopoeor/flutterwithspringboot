package com.example.flutterwithspringboot.items;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDataAccessService {

    private JdbcTemplate jdbcTemplate;

    public ItemDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Item> rowMapper = new RowMapper<Item>() {

        @Override
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            UUID itemId = UUID.fromString(rs.getString("medical_id"));
            String name = rs.getString("name");
            String price = rs.getString("price");
            String type = rs.getString("type");
            String country = rs.getString("country");
            String details = rs.getString("details");
            String photo = rs.getString("photo");
            String expiredDate = rs.getString("expired_date");
            return new Item(itemId, name, price, type, country, details, photo, expiredDate);
        }

    };

    public int insertItems(Item item) {
        String sql = "insert into medical_db (medical_id, name, price, type, country, details, photo, expired_date) values (uuid_to_bin(uuid()),?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, item.getName(), item.getPrice(), item.getType(), item.getCountry(),
                item.getDetails(), item.getPhoto(), item.getExpiredDate());
    }

    public void updateItems(String medical_id, Item item) {
        String sql = "update medical_db set name=?, price=?, type=?, country=?, details=?, photo=?, expired_date=? where bin_to_uuid(medical_id)=?";
        jdbcTemplate.update(sql, item.getName(), item.getPrice(), item.getType(), item.getCountry(), item.getDetails(), item.getPhoto(), item.getExpiredDate(),
                medical_id);
    }

    public void deleteItem(String medical_id) {
        String sql = "delete from medical_db where bin_to_uuid(medical_id)=?";
        jdbcTemplate.update(sql, medical_id);
    }

    public Optional<Item> getOneItem(String medical_id) {
        String sql = "select bin_to_uuid(medical_id) medical_id, name, price, type, country, details, photo, expired_date from medical_db where bin_to_uuid(medical_id)=?";
        Item item = jdbcTemplate.queryForObject(sql, new Object[] { medical_id }, rowMapper);
        return Optional.ofNullable(item);
    }

    public List<Item> selectAllItems() {
        String sql = "select bin_to_uuid(medical_id) medical_id, name, price, type, country, details, photo, expired_date from medical_db";
        return jdbcTemplate.query(sql, rowMapper);
    }

}
