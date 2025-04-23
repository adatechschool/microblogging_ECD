package com.microblogging.backend;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.microblogging.backend.models.Media;
import com.microblogging.backend.repositories.MediaRepository;
import com.microblogging.backend.services.MediaService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MediaServiceTest {
    @Mock
    private MediaRepository mediaRepository;

    @InjectMocks
    private MediaService mediaService;

    @Test
    void testGetMediaById() {
        Long mediaId = 1L;
        Media fakeMedia = new Media(mediaId, "Fake media URL", "image/jpeg", null); // Assuming User and LocalDateTime are handled elsewhere
        // Mocking the behavior of the repository to return the fake media when findById is called
        Mockito.when(mediaRepository.findById(mediaId)).thenReturn(Optional.of(fakeMedia));

        Media result = mediaService.getMediaById(mediaId);

        Assertions.assertThat(result).isEqualTo(fakeMedia);
    }

    @Test
    void testGetAllMedia() {
        // Assuming you have a method to create a list of fake media
        List<Media> fakeMediaList = List.of(new Media(1L, "Fake media URL 1", "image/jpeg", null),
                                             new Media(2L, "Fake media URL 2", "image/png", null));
        Mockito.when(mediaRepository.findAll()).thenReturn(fakeMediaList);

        List<Media> result = mediaService.getAllMedia();

        Assertions.assertThat(result).isEqualTo(fakeMediaList);
    }

    @Test
    void testCreateMedia() {
        Media newMedia = new Media(null, "New media URL", "image/jpeg", null); // Assuming User and LocalDateTime are handled elsewhere
        Media savedMedia = new Media(1L, "New media URL", "image/jpeg", null); // Mocked saved media with ID
        Mockito.when(mediaRepository.save(newMedia)).thenReturn(savedMedia);

        Media result = mediaService.createMedia(newMedia);

        Assertions.assertThat(result).isEqualTo(savedMedia);
    }

    @Test
    void testDeleteMedia() {
        Long mediaId = 1L;
        // Mocking the behavior of the repository to do nothing when deleteById is called
        Mockito.doNothing().when(mediaRepository).deleteById(mediaId);

        mediaService.deleteMedia(mediaId);

        // Verifying that the deleteById method was called with the correct ID
        Mockito.verify(mediaRepository, Mockito.times(1)).deleteById(mediaId);
    }
}
