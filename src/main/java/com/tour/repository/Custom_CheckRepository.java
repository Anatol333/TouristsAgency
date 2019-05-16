package com.tour.repository;

import com.tour.domain.Custom_Check;
import com.tour.domain.dto.AccountUserTour;
import com.tour.domain.embeddable.EmbCustom_Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Custom_CheckRepository extends JpaRepository<Custom_Check, EmbCustom_Check> {

    // Some custom methods....

    @Query("SELECT new com.tour.domain.dto.AccountUserTour(" +
            "   T.Header_Name, " +
            "   CH.Custom_Date_Start," +
            "   CH.Custom_Date_End," +
            "   CH.Custom_Price," +
            "   CH.ID_Tour) FROM Custom_Check CH, Tour T " +
            "WHERE CH.id = :id AND " +
            " CH.ID_Tour = T.ID_Tour")
    List<AccountUserTour> findByIdUser(final Integer id);
}
