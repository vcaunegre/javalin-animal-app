package org.example.animalapp.animal.repository;

import io.javalin.http.InternalServerErrorResponse;
import io.javalin.http.NotFoundResponse;
import jakarta.inject.Singleton;
import org.example.animalapp.Utils;
import org.example.animalapp.animal.dto.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class DefaultAnimalRepository implements AnimalRepository {
//    Logger logger = LoggerFactory.getLogger(App.class);

    @Override
    public List<AnimalResponseDTO> getAllAnimals(int page, int size) {
        List<AnimalResponseDTO> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("""
                    SELECT a.id,a.name,a.date_of_birth,ak.id as ak_id, ak.name as ak_name, ak.avglifeexpectancy,
                     ar.id as ar_id, ar.name as race, o.id as o_id, o.name as o_name
                    FROM ANIMALS a JOIN ANIMAL_KINDS ak ON ak.id=a.animal_kind_id
                    JOIN ANIMAL_RACES ar ON a.animal_race_id = ar.id
                    JOIN OWNERS o ON a.owner_id = o.id
                    LIMIT ? OFFSET ?
                    """);
            ps.setInt(1, size);
            ps.setInt(2, size * page);
            var r = ps.executeQuery();

            while (r.next()) {
                AnimalResponseDTO ar = new AnimalResponseDTO(r.getLong("id"), r.getString("name"), r.getDate("date_of_birth").toLocalDate(), new OwnerResponseDTO(r.getLong("o_id"), r.getString("o_name")), new AnimalKindResponseDTO(r.getLong("ak_id"), r.getString("ak_name"), r.getFloat("avglifeexpectancy")), new AnimalRaceResponseDTO(r.getLong("ar_id"), r.getString("race")));
                list.add(ar);
            }
        } catch (SQLException e) {
            throw new InternalServerErrorResponse(e.getMessage());
        }
        return list;
    }

    @Override
    public AnimalResponseDTO getAnimalById(Long id) {
        AnimalResponseDTO animalResponseDTO;
        try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("""
                    SELECT a.name,a.date_of_birth,ak.id as ak_id, ak.name as ak_name, ak.avglifeexpectancy,
                     ar.id as ar_id, ar.name as ar_name, o.id as o_id, o.name as o_name
                    FROM ANIMALS a JOIN ANIMAL_KINDS ak ON ak.id=a.animal_kind_id
                    JOIN ANIMAL_RACES ar ON a.animal_race_id = ar.id
                    JOIN OWNERS o ON a.owner_id = o.id
                    WHERE a.id = ?
                    """);
            ps.setLong(1, id);
            var r = ps.executeQuery();
            if (r.next()) {
                animalResponseDTO = new AnimalResponseDTO(id, r.getString("name"), r.getDate("date_of_birth").toLocalDate(), new OwnerResponseDTO(r.getLong("o_id"), r.getString("o_name")), new AnimalKindResponseDTO(r.getLong("ak_id"), r.getString("ak_name"), r.getFloat("avglifeexpectancy")), new AnimalRaceResponseDTO(r.getLong("ar_id"), r.getString("ar_name")));
            } else {
                throw new NotFoundResponse("NO Animal found for id " + id);
            }
        } catch (SQLException e) {
            throw new InternalServerErrorResponse(e.getMessage());
        }
        return animalResponseDTO;
    }

    public void createNewAnimal(CreateAnimalDto animal) {
        try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
            String[] generatedColumns = {"id"};
            PreparedStatement ps = con.prepareStatement("INSERT INTO OWNERS(name) VALUES(?)", generatedColumns);
            ps.setString(1, animal.ownerName());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            Long ownerId = null;
            while (rs.next()) {
                ownerId = rs.getLong(1);
            }

            ps = con.prepareStatement("INSERT INTO ANIMALS(name,date_of_Birth,animal_kind_id,animal_race_id,owner_id) VALUES(?,?,?,?,?)");
            ps.setString(1, animal.name());
            ps.setDate(2, Date.valueOf(animal.dateOfBirth()));
            ps.setLong(3, animal.animalKindId());
            ps.setLong(4, animal.animalRaceId());
            if (ownerId != null) {
                ps.setLong(5, ownerId);
            }
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new InternalServerErrorResponse(e.getMessage());

        }
    }

    @Override
    public void editAnimal(EditAnimalDto animal) {
        try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("SELECT id from ANIMALS WHERE id=:id");
            ps.setLong(1, animal.id());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ps = con.prepareStatement("""
                        UPDATE ANIMALS SET NAME=?,DATE_OF_BIRTH=?,ANIMAL_KIND_ID=?,ANIMAL_RACE_ID=?
                        WHERE ID = ?
                        """);
                ps.setString(1, animal.name());
                ps.setDate(2, Date.valueOf(animal.dateOfBirth()));
                ps.setLong(3, animal.kindId());
                ps.setLong(4, animal.raceId());
                ps.setLong(5, animal.id());
                ps.execute();
            } else {
                throw new NotFoundResponse("No animal found for this id " + animal.id());
            }
        } catch (SQLException e) {
            throw new InternalServerErrorResponse(e.getMessage());
        }
    }

    public void deleteById(long animalId) {
        Long ownerId = null;
        try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("SELECT owner_id FROM ANIMALS WHERE ID = ?");
            ps.setLong(1, animalId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    ownerId = rs.getLong("owner_id");
                }
            } else {
                throw new NotFoundResponse("No animal found for this id " + animalId);
            }
            ps = con.prepareStatement("DELETE FROM ANIMALS WHERE ID = ?");
            ps.setLong(1, animalId);
            ps.execute();
            if (ownerId != null) {
                ps = con.prepareStatement("DELETE FROM OWNERS WHERE ID = ?");
                ps.setLong(1, ownerId);
                ps.execute();
            }
        } catch (SQLException e) {
            throw new InternalServerErrorResponse(e.getMessage());
        }
    }

    public void deleteByName(String name) {
        Long ownerId = null;
        try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("SELECT owner_id FROM ANIMALS WHERE NAME LIKE ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    ownerId = rs.getLong("owner_id");
                }
            } else {
                throw new NotFoundResponse("No animal found for this name " + name);
            }
            ps = con.prepareStatement("DELETE FROM ANIMALS WHERE NAME LIKE ?");
            ps.setString(1, name);
            ps.execute();
            if (ownerId != null) {
                ps = con.prepareStatement("DELETE FROM OWNERS WHERE ID = ?");
                ps.setLong(1, ownerId);
                ps.execute();
            }
        } catch (SQLException e) {
            throw new InternalServerErrorResponse(e.getMessage());
        }
    }

}
