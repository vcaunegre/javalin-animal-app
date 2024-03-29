package org.example.animalapp.animal_kind.repository;

import io.javalin.http.InternalServerErrorResponse;
import jakarta.inject.Singleton;
import org.example.animalapp.Utils;
import org.example.animalapp.animal_kind.dto.CreateKind;
import org.example.animalapp.animal_kind.dto.EditKind;
import org.example.animalapp.animal_kind.dto.KindResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class DefaultAnimalKindRepository implements AnimalKindRepository {


    @Override
    public List<KindResponse> getAllKinds() {
        List<KindResponse> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("""
                    SELECT ak.id,ak.name,ak.avgLifeExpectancy FROM ANIMAL_KINDS ak
                    """);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KindResponse kr = new KindResponse(rs.getLong("id"), rs.getString("name"), rs.getFloat("avgLifeExpectancy"));
                list.add(kr);
            }
        } catch (SQLException e) {
            throw new InternalServerErrorResponse(e.getMessage());
        }
        return list;
    }

    @Override
    public void deleteById(long kindId) {
        try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM ANIMAL_KINDS WHERE ID = ?");
            ps.setLong(1, kindId);
            ps.execute();
        } catch (SQLException e) {
            throw new InternalServerErrorResponse(e.getMessage());
        }
    }

    @Override
    public void createNewKind(CreateKind cKind) {
        try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO ANIMAL_KINDS(name,avgLifeExpectancy) VALUES(?,?)");
            ps.setString(1, cKind.kindName());
            ps.setFloat(2, cKind.avgLifeExpectancy());
            ps.execute();
        } catch (SQLException e) {
            throw new InternalServerErrorResponse(e.getMessage());
        }
    }

    @Override
    public void editKind(EditKind editKind) {
        try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("""
                    UPDATE ANIMAL_KINDS SET NAME=?,avgLifeExpectancy=?
                    WHERE ID = ?
                    """);
            ps.setString(1, editKind.kindName());
            ps.setFloat(2, editKind.avgLifeExpectancy());
            ps.setLong(3, editKind.id());
            ps.execute();
        } catch (SQLException e) {
            throw new InternalServerErrorResponse(e.getMessage());
        }
    }
}
