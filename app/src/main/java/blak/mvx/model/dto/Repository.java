package blak.mvx.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repository {
    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("full_name")
    @Expose
    public String fulName;

    @SerializedName("owner")
    @Expose
    public Owner owner;

    @SerializedName("private")
    @Expose
    public boolean isPrivate;

    @SerializedName("description")
    @Expose
    public String description;
}
