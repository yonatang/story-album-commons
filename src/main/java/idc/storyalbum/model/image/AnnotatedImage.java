package idc.storyalbum.model.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.collect.HashMultiset;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by yonatan on 18/4/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@JsonPropertyOrder({"imageFilename",
        "imageDate", "imageQuality", "locationId", "characterIds", "itemIds"})
public class AnnotatedImage {
    private String imageFilename;
    private HashMultiset<String> characterIds = HashMultiset.create();
    private String locationId;
    private HashMultiset<String> itemIds = HashMultiset.create();
    private DateTime imageDate;
    private ImageQuality imageQuality;
    private Set<Rectangle> facesLocations = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnotatedImage that = (AnnotatedImage) o;
        return Objects.equals(imageFilename, that.imageFilename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageFilename);
    }
}
