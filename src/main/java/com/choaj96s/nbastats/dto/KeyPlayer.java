package com.choaj96s.nbastats.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KeyPlayer {
    private String name;
    private String statLine; // "27 PTS, 8 REB, 5 AST"
}