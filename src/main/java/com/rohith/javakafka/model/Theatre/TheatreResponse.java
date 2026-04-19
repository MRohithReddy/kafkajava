
@Getter
@Setter
@lombok
public class TheatreResponse {

  private Long screen_id, screen_size, regular_seats_available, sofa_seats_available, recliner_seats_available, total_seats_available;
  
  private String seat_type, movieName;
  
}
