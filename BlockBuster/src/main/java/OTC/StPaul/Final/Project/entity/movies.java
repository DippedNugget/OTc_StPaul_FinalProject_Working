package OTC.StPaul.Final.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class movies {
  private int movie_id;
  private String title;
  private String director;
  private String genre;
  private String rating;
  private Boolean in_stock;
  private int store_location;

}
