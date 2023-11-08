package org.example.animalapp.animal_race.repository;

import org.example.App;
import org.example.Utils;
import org.example.animalapp.animal_race.dto.GetRaceDTO;
import org.example.animalapp.animal_race.dto.RaceDTO;
import org.example.animalapp.animal_race.dto.RaceEditDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DefaultAnimalRaceRepository implements AnimalRaceRepository {
    static final Logger logger = LoggerFactory.getLogger(App.class);

    @Override
    public List<GetRaceDTO> getAllRacesForAKind(Long kindId) {
        List<GetRaceDTO> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
            PreparedStatement ps = con.prepareStatement("SELECT id, name FROM ANIMAL_RACES WHERE ANIMAL_KIND_ID = ?");
            ps.setLong(1, kindId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new GetRaceDTO(rs.getLong("id"),rs.getString("name")));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return list;
    }

        @Override
        public void deleteById ( long raceId){
            try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
                PreparedStatement ps = con.prepareStatement("DELETE FROM ANIMAL_RACES WHERE ID = ?");
                ps.setLong(1, raceId);
                ps.executeQuery();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }

        @Override
        public void createNewRace (RaceDTO nRace){
            try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO ANIMAL_RACES(name,animal_kind_id) VALUES(?,?)");
                ps.setString(1, nRace.name());
                ps.setLong(2,nRace.kindId());
                ps.execute();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }

        @Override
        public void editRace(RaceEditDTO eRace){
            try (Connection con = DriverManager.getConnection(Utils.PG_URL, Utils.PG_USER, Utils.PG_PASSWORD)) {
                PreparedStatement ps = con.prepareStatement("UPDATE ANIMAL_RACES SET NAME = ?, ANIMAL_KIND_ID = ? WHERE ID = ?");
                ps.setString(1,eRace.name());
                ps.setLong(2, eRace.kindId());
                ps.setLong(3,eRace.id());
                ps.execute();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }
