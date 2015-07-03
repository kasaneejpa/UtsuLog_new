package com.example.tashino_akihiro.utsulog;

/**
 * Created by akihiro on 2015/05/30.
 */
public class ItemBean {
    private  long id;
    private String judge;
    private String comment;
    private String date;
    private int level;

    public ItemBean(long id,String judge, String comment,String date,int level) {
        this.id = id;
        this.judge = judge;
        this.comment = comment;
        this.date = date;
        this.level = level;
    }

    public ItemBean() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;

    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "ID='" + id + '\'' +
                "date='" + date + '\'' +
                "judge='" + judge + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
