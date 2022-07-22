package com.amigoscode.fraud.repository;

import com.amigoscode.fraud.domain.FraudCheckHistory;
import com.amigoscode.fraud.utils.FraudCheckCreator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Tests for FraudCheckHistory Repository")
public class FraudCheckHistoryRepositoryTest {

    @Autowired
    private FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Test
    @DisplayName("SaveAndFlush persists FraudCheckHistory when Sucessful")
    void save_PersistFraudCheckHistoryr_WhenSucessful(){
        FraudCheckHistory fraudCheckHistoryToBeSaved = FraudCheckCreator.fraudCheckCreator();

        FraudCheckHistory fraudCheckHistorySaved = this.fraudCheckHistoryRepository.saveAndFlush(fraudCheckHistoryToBeSaved);

        Assertions.assertNotNull(fraudCheckHistorySaved);

        Assertions.assertNotNull(fraudCheckHistorySaved.getId());

        Assertions.assertFalse(fraudCheckHistorySaved.getIsFraudster());

        Assertions.assertEquals(fraudCheckHistorySaved.getCustomerId(), fraudCheckHistoryToBeSaved.getCustomerId());
    }
}
