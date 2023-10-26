package org.example.animalapp.animal.repository;

import org.example.App;
import org.example.Utils;
import org.example.animalapp.animal.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultAnimalRepository implements AnimalRepository {
    Logger logger = LoggerFactory.getLogger(App.class);

    public List<AnimalResponseDTO> getAllAnimals() {
        List<AnimalResponseDTO> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("""
                    SELECT a.id,a.name,a.date_of_birth,ak.id as ak_id, ak.name as ak_name, ak.avglifeexpectancy,
                     ar.id as ar_id, ar.name as race, o.id as o_id, o.name as o_name
                    FROM ANIMALS a JOIN ANIMAL_KINDS ak ON ak.id=a.animal_kind_id 
                    JOIN ANIMAL_RACES ar ON a.animal_race_id = ar.id
                    JOIN OWNERS o ON a.owner_id = o.id
                    """);
            var r = ps.executeQuery();
            while (r.next()) {
                AnimalResponseDTO ar = new AnimalResponseDTO(r.getLong("id"), r.getString("name"), r.getDate("date_of_birth").toLocalDate(), new OwnerResponseDTO(r.getLong("o_id"), r.getString("o_name")), new AnimalKindResponseDTO(r.getLong("ak_id"), r.getString("ak_name"), r.getFloat("avglifeexpectancy")), new AnimalRaceResponseDTO(r.getLong("ar_id"), r.getString("race")));
                list.add(ar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void createNewAnimal(CreateAnimalDto animal) {
        try (Connection con = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASSWORD)) {
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
            } else {
            }
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editAnimal(EditAnimalDto animal) {
        try (Connection con = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASSWORD)) {
PreparedStatement ps=con.prepareStatement("""
UPDATE ANIMALS SET NAME=?,DATE_OF_BIRTH=?,ANIMAL_KIND_ID=?,ANIMAL_RACE_ID=?
WHERE ID = ?
""");
ps.setString(1,animal.name());
ps.setDate(2,Date.valueOf(animal.dateOfBirth()));
ps.setLong(3,animal.kindId());
ps.setLong(4,animal.raceId());
ps.setLong(5,animal.id());
ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        }

    public void deleteById(long animalId) {
        Long ownerId = null;
        try (Connection con = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("SELECT owner_id FROM ANIMALS WHERE ID = ?");
            ps.setLong(1, animalId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ownerId = rs.getLong("owner_id");
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
            e.printStackTrace();
        }
    }

    public void deleteByName(String name) {
        Long ownerId = null;
        try (Connection con = DriverManager.getConnection(Utils.URL, Utils.USER, Utils.PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("SELECT owner_id FROM ANIMALS WHERE NAME LIKE ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ownerId = rs.getLong("owner_id");
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
            e.printStackTrace();
        }
    }

}
