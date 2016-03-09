package blak.mvx.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("login")
    @Expose
    public String login;

    @SerializedName("avatar_url")
    @Expose
    public String avatarUrl;
}
