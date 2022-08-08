package org.voghbum.youprojectspring.dto;

import java.math.BigDecimal;

public class MovieDTO {
    private String      m_name;
    private String m_sceneTimeStr;
    private long        m_rating;
    private BigDecimal m_cost;



    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        m_name = name;
    }

    public String getSceneTimeStr() {
        return m_sceneTimeStr;
    }

    public void setSceneTimeStr(String sceneTimeStr) {
        m_sceneTimeStr = sceneTimeStr;
    }

    public long getRating() {
        return m_rating;
    }

    public void setRating(long rating) {
        m_rating = rating;
    }

    public BigDecimal getCost() {
        return m_cost;
    }

    public void setCost(BigDecimal cost) {
        m_cost = cost;
    }
}
