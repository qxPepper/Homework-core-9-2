package ru.netology;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class Nasa {
    private final String copyright;
    private final Date date;
    private final String explanation;
    private final String hdurl;
    private final String media_type;
    private final String service_version;
    private final String title;
    private final String url;

    public Nasa(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") Date date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("media_type") String media_type,
            @JsonProperty("service_version") String service_version,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url
    ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public Date getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMedia_type() {
        return media_type;
    }

    public String getService_version() {
        return service_version;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Nasa" +
                "\n\t copyright='" + copyright +
                "\n\t date=" + date +
                "\n\t explanation='" + explanation +
                "\n\t hdurl='" + hdurl +
                "\n\t media_type='" + media_type +
                "\n\t service_version='" + service_version +
                "\n\t title='" + title +
                "\n\t url='" + url;
    }
}
