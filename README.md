- Bookmyshow app

-- Step1: Theatre Service - CRUD seats (regular, sofa, recliner) - price changes

Screen id, screen size, seat type, std_price, regular_seat available, sofa_seat available, recliner_seat available, total_seats available, movie name

-- Step2: Reservation Service - CRUD users

user_id, user_name, looks for movie_name (show screen_ids)

Create dto and dao structured project - refactor (helps in having a dedicated request and response and have response depend on other services and request has fields only necessary for requestbody)

Next session: Do the refactoring from on 11

- Learned:
  -- 1)Use DTOs for requests and responses. This helps to request users for only required fields and only return response with only required fields
  -- 2)Use getters, setters annotation on entity class even though not using them directly as jpa/hibernate uses them internally to make database lazy loading etc. entity's role is a database state and dto is api data shape.
  -- 3)Use entity class only when talking to repository class. For controller, use DTO. For that to happen, do all the assignments accordingly in service class (for saving to repo - do entity.setName(entityDTO.getName()) and then save(entity) and for findAll() vice verca).
