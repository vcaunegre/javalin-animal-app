package org.example.animalapp.owner.repository;

import io.javalin.http.InternalServerErrorResponse;
import jakarta.inject.Singleton;
import org.example.animalapp.Utils;
import org.example.animalapp.owner.dto.EditOwnerDto;
import org.example.animalapp.owner.dto.OwnerDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class DefaultOwnerRepository implements OwnerRepository {
    @Override
    public List<OwnerDto> getOwners() {
        List<OwnerDto> owners = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("SELECT o.id, o.name FROM OWNERS o");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                owners.add(new OwnerDto(rs.getLong("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            throw new InternalServerErrorResponse(e.getMessage());
        }
        return owners;
    }

    @Override
    public void editOwner(EditOwnerDto ownerName) {
        try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("UPDATE OWNERS SET name=? WHERE id = ?");
            ps.setString(1,ownerName.name());
            ps.setLong(2,ownerName.id());
            ps.execute();
        }catch (SQLException e){
            throw new InternalServerErrorResponse(e.getMessage());
        }
        }
}
