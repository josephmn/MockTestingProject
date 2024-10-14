package org.mock.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mock.DataProvider;
import org.mock.persistence.entity.Player;
import org.mock.persistence.entity.repository.PlayerRepositoryImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import java.util.List;

public class PlayerServiceImplTest {

    // 1ero las dependencias
    @Mock
    private PlayerRepositoryImpl playerRepository;

    // 2do clases a testear
    @InjectMocks
    private PlayerServiceImpl playerService;

    @BeforeEach
    void init() {
        /* 1er metodo como se puede encontrar
        this.playerRepository = mock(PlayerRepositoryImpl.class);
        this.playerService = new PlayerServiceImpl(playerRepository);
         */
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void testFindAll() {
        // Given
        // PlayerRepositoryImpl playerRepository = mock(PlayerRepositoryImpl.class); // simular con mockito
        // PlayerServiceImpl playerService = new PlayerServiceImpl(playerRepository);

        // When
        when(playerRepository.findAll()).thenReturn(DataProvider.playerListMock());
        List<Player> result = playerService.findAll();

        // Then
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals("Lionel Messi", result.get(0).getName());
        assertEquals("Inter Miami", result.get(0).getTeam());
        assertEquals("Delantero", result.get(0).getPosition());
    }
}
