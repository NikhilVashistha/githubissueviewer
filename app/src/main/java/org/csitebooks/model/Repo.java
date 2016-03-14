package org.csitebooks.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abc on 01-12-2015.
 */
public class Repo {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    /**
     * No args constructor for use in serialization
     *
     */
    public Repo() {
    }

    /**
     *
     * @param title
     * @param updatedAt
     */
    public Repo(String title, String updatedAt) {
        this.title = title;
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setCreatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
