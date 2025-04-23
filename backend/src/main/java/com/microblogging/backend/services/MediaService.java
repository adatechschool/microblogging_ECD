package com.microblogging.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microblogging.backend.models.Media;
import com.microblogging.backend.repositories.MediaRepository;

@Service
public class MediaService {
    
    private final MediaRepository mediaRepository;

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public Media getMediaById(Long id) {
        return mediaRepository.findById(id).orElseThrow(() -> new RuntimeException("Media not found"));
    }

    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }

    public Media createMedia(Media media) {
        return mediaRepository.save(media);
    }

    public void deleteMedia(Long id) {
        mediaRepository.deleteById(id);
    }

    public Media updateMedia(Long id, Media media) {
        Media existingMedia = getMediaById(id);
        existingMedia.setMediaUrl(media.getMediaUrl());
        existingMedia.setMediaType(media.getMediaType());
        return mediaRepository.save(existingMedia);
    }
}
