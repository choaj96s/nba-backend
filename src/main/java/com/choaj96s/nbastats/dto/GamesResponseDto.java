package com.choaj96s.nbastats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GamesResponseDto {
    private List<GameDto> data;
    private MetaDto meta;

    public List<GameDto> getData() {
        return data;
    }

    public void setData(List<GameDto> data) {
        this.data = data;
    }

    public MetaDto getMeta() {
        return meta;
    }

    public void setMeta(MetaDto meta) {
        this.meta = meta;
    }

    public static class MetaDto {
        @JsonProperty("next_cursor")
        private Integer nextCursor;

        @JsonProperty("per_page")
        private Integer perPage;

        public Integer getNextCursor() {
            return nextCursor;
        }

        public void setNextCursor(Integer nextCursor) {
            this.nextCursor = nextCursor;
        }

        public Integer getPerPage() {
            return perPage;
        }

        public void setPerPage(Integer perPage) {
            this.perPage = perPage;
        }
    }
}
