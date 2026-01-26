package com.choaj96s.nbastats.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HighlightVideo {
    private String title;
    private String youtubeUrl;
    private String thumbnail;
}