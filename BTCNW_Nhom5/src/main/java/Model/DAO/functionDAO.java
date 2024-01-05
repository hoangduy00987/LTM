package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.BEAN.Bill;
import Model.BEAN.Booking;
import Model.BEAN.Comment;
import Model.BEAN.Tour;
import Model.BEAN.User;
import context.DBContext;

public class functionDAO {

	public boolean addTour(String location, String description, String number_day, String filepath, String video_link, String price, String detail_description) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean isExist = false;
		try {
			   conn = DBContext.getConnection();
			String sql = "INSERT INTO tour_detail(location, description, number_day, image, video_link, price, detail_description) VALUES (?, ?, ?, ?, ?, ?, ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, location);
			stmt.setString(2, description);
			stmt.setString(3, number_day);
			stmt.setString(4, filepath);
			stmt.setString(5, video_link);
			stmt.setString(6, price);
			stmt.setString(7, detail_description);
			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				isExist = true;
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("MySQL JDBC driver not found.");
			ex.printStackTrace();
		} catch (SQLException ex) {
			System.out.println("An error occurred while connecting to the database.");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("An unexpected error occurred.");
			ex.printStackTrace();
		}

		return isExist;
	}

	public ArrayList<Tour> getAllTours() {
		ArrayList<Tour> list = new ArrayList<Tour>();

		try {
			  Connection conn = DBContext.getConnection();
			Statement stm = conn.createStatement();
			String query = "select * from tour_detail";
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				Tour tour = new Tour();
				tour.setDetail_id(rs.getInt(1));
				tour.setLocation(rs.getString(2));
				tour.setDescription(rs.getString(3));
				tour.setNumber_day(rs.getString(4));
				tour.setImage(rs.getString(5));
				tour.setPrice(rs.getString(6));
				tour.setDetail_description(rs.getString(7));

				tour.setVideo_link(rs.getString(8));
				list.add(tour);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean bookingTour(int idTour, int idUser, String bookingDate, int numParticipants) {
		boolean success = false;
		try {
			  Connection conn = DBContext.getConnection();
			Statement stm = conn.createStatement();
			String query = "insert into booking (tour_detail_id, user_id, booking_date, num_participants) values ("
					+ idTour + ", " + idUser + ", '" + bookingDate + "', " + numParticipants + ")";
			
			int rowsAffected = stm.executeUpdate(query);
			
			if (rowsAffected > 0) {
				success = true;
			}
			stm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public int getIDTourByLocation(String location) {
		int id = 0;
		try {
			  Connection conn = DBContext.getConnection();
			Statement stm = conn.createStatement();
			String query = "select detail_id from tour_detail where location = '"+location+"'";
			ResultSet rs = stm.executeQuery(query);
			
			if (rs.next()) {
				id = rs.getInt("detail_id");
			}
			
			stm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public int getIDUserByUsername(String username) {
		int id = 0;
		try {
			  Connection conn = DBContext.getConnection();
			Statement stm = conn.createStatement();
			String query = "select user_id from user where username = '"+username+"'";
			ResultSet rs = stm.executeQuery(query);
			
			if (rs.next()) {
				id = rs.getInt("user_id");
			}
			
			stm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public ArrayList<Booking> getBookingTourOfUser(int idUser) {
		ArrayList<Booking> list = new ArrayList<Booking>();
		
		try {
			  Connection conn = DBContext.getConnection();
			Statement stm = conn.createStatement();
			String query = "select * from booking where user_id = "+idUser;
			ResultSet rs = stm.executeQuery(query);
			
			while (rs.next()) {
				Booking booking = new Booking();
				booking.setBooking_id(rs.getInt(1));
				booking.setTour_detail_id(rs.getInt(2));
				booking.setUser_id(rs.getInt(3));
				booking.setBooking_date(rs.getDate(4));
				booking.setNum_participants(rs.getInt(5));
				list.add(booking);
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public User getUserByUsername(String username) {
		User user = new User();
		
		try {
			  Connection conn = DBContext.getConnection();
			Statement stm = conn.createStatement();
			String query = "select * from user where username = '"+username+"'";
			ResultSet rs = stm.executeQuery(query);
			
			if (rs.next()) {
				user.setUser_id(rs.getInt(1));
				user.setFull_name(rs.getString(2));
				user.setAddress(rs.getString(3));
				user.setPhone_number(rs.getString(4));
				user.setUsername(rs.getString(5));
				user.setPassword(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setRole(rs.getString(8));
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

    public Tour getTourbyId(int tourId) {
    	
        Tour tour = null;
        
        try  {
        	Connection conn = DBContext.getConnection();
            String query = "SELECT * FROM tour_detail WHERE detail_id = ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setInt(1, tourId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        tour = new Tour();
                        tour.setDetail_id(tourId);
                        tour.setLocation(resultSet.getString("location"));
                        tour.setDescription(resultSet.getString("description"));
                        tour.setNumber_day(resultSet.getString("number_day"));
                        tour.setImage(resultSet.getString("image"));
                        tour.setPrice(resultSet.getString("Price"));
                        tour.setDetail_description(resultSet.getString("detail_description"));
    					tour.setVideo_link(resultSet.getString("video_link"));
                    }
                }
            }
        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return tour;
    }
	 
	
	public void cancelTour(int idBooking) {
		try {
			  Connection conn = DBContext.getConnection();
			Statement stm = conn.createStatement();
			String query = "delete from booking where booking_id = "+idBooking;
			int rowsAffected = stm.executeUpdate(query);
			
			if (rowsAffected > 0) {
				System.out.println("Cancel tour successfully");
			} else {
				System.out.println("Cancel tour failed");
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Booking getBookingById(int idBooking) {
		Booking booking = new Booking();
		
		try {
			  Connection conn = DBContext.getConnection();
			Statement stm = conn.createStatement();
			String query = "select * from booking where booking_id = "+idBooking;
			ResultSet rs = stm.executeQuery(query);
			
			if (rs.next()) {
				booking.setBooking_id(rs.getInt(1));
				booking.setTour_detail_id(rs.getInt(2));
				booking.setUser_id(rs.getInt(3));
				booking.setBooking_date(rs.getDate(4));
				booking.setNum_participants(rs.getInt(5));
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return booking;
	}
	
	public ArrayList<Tour> getToursBySearch(String search) {
		ArrayList<Tour> list = new ArrayList<Tour>();
		
		try {
			  Connection conn = DBContext.getConnection();
			Statement stm = conn.createStatement();
			String query = "select * from tour_detail where location like '%"+search+"%'";
			ResultSet rs = stm.executeQuery(query);

			while (rs.next()) {
				Tour tour = new Tour();
				tour.setDetail_id(rs.getInt(1));
				tour.setLocation(rs.getString(2));
				tour.setDescription(rs.getString(3));
				tour.setNumber_day(rs.getString(4));
				tour.setImage(rs.getString(5));
				
				tour.setPrice(rs.getString(6));
				tour.setDetail_description(rs.getString(7));
				tour.setVideo_link(rs.getString(8));
				list.add(tour);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Booking getLastBooking(int idUser) {
		Booking booking = new Booking();
		
		try {
			  Connection conn = DBContext.getConnection();
			Statement stm = conn.createStatement();
			String query = "SELECT * FROM booking WHERE user_id = "+idUser+" ORDER BY booking_date DESC LIMIT 1";
			ResultSet rs = stm.executeQuery(query);
			
			if (rs.next()) {
				booking.setBooking_id(rs.getInt(1));
				booking.setTour_detail_id(rs.getInt(2));
				booking.setUser_id(rs.getInt(3));
				booking.setBooking_date(rs.getDate(4));
				booking.setNum_participants(rs.getInt(5));
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return booking;
	}
	
	public boolean updateBooking(int bookingId, String bookingDate, int num_participants) {
		boolean success = false;
		
		try {
			  Connection conn = DBContext.getConnection();
			Statement stm = conn.createStatement();
			String query = "update booking set booking_date = '"+bookingDate+"', num_participants = "+num_participants+" where booking_id = "+bookingId;
			
			int rowsAffected = stm.executeUpdate(query);
			
			if (rowsAffected > 0) {
				success = true;
			}
			stm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean updateTourDAO(String location, String description, String number_day, String filepath, String video_link, String price, String detail_description, int id) {
		boolean success = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			 conn = DBContext.getConnection();
			String sql = "UPDATE tour_detail SET location = ?, description = ?, number_day = ?, image = ?, video_link = ?, price = ?, detail_description = ? WHERE detail_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, location);
			stmt.setString(2, description);
			stmt.setString(3, number_day);
			stmt.setString(4, filepath);
			stmt.setString(5, video_link);
			stmt.setString(6, price);
			stmt.setString(7, detail_description);
			stmt.setInt(8, id);
			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				success = true;
			}
		} catch (Exception e) {
			System.out.println("An unexpected error occurred.");
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean deleteDAO(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean success = false;
		
		try {
			  conn = DBContext.getConnection();
			String sql = "DELETE FROM tour_detail WHERE detail_id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				success = true;
			}
		} catch (Exception e) {
			System.out.println("An unexpected error occurred.");
			e.printStackTrace();
		}
		return success;
	}
	
	public ArrayList<Booking> getAllBookingDAO() {
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		Connection conn = null;

        try {
        	   conn = DBContext.getConnection();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM booking";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBooking_id(rs.getInt(1));
                booking.setTour_detail_id(rs.getInt(2));
                booking.setUser_id(rs.getInt(3));
                booking.setBooking_date(rs.getDate(4));
                booking.setNum_participants(rs.getInt(5));
                bookings.add(booking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookings;
	}
	
	public User getUserById(int idUser) {
		User user = new User();
		
		try {
			  Connection conn = DBContext.getConnection();
			Statement stm = conn.createStatement();
			String query = "select * from user where user_id = "+idUser;
			ResultSet rs = stm.executeQuery(query);
			
			if (rs.next()) {
				user.setUser_id(rs.getInt(1));
				user.setFull_name(rs.getString(2));
				user.setAddress(rs.getString(3));
				user.setPhone_number(rs.getString(4));
				user.setUsername(rs.getString(5));
				user.setPassword(rs.getString(6));
				user.setEmail(rs.getString(7));
				user.setRole(rs.getString(8));
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	
	 	
	    boolean isExist = false;
        private static PreparedStatement stmt = null;
        private static ResultSet rs = null;
	    
        public ArrayList<Comment> getAllComment_of_tour(int tour_id) {
            ArrayList<Comment> result = new ArrayList<Comment>();

            try {
            	  Connection conn = DBContext.getConnection();
                String query = "SELECT c.content, u.full_name " +
                               "FROM comment c " +
                               "INNER JOIN user u ON c.user_id = u.user_id " +
                               "WHERE c.tour_id = ?";
                stmt = conn.prepareStatement(query);
                stmt.setInt(1, tour_id);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    String name_user = rs.getString("full_name");
                    String content = rs.getString("content");
                    Comment comment = new Comment();
                    comment.set_nameuser(name_user);
                    comment.setComment(content);
                    result.add(comment);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
        public Bill getBill(int tour_id) {
           Bill result = new Bill();

            try {
                Connection conn = DBContext.getConnection();
                String query = "SELECT d.Price, b.num_participants, u.full_name, u.phone_number, u.address, d.location " +
                        "FROM booking b " +
                        "INNER JOIN user u ON b.user_id = u.user_id " +
                        "INNER JOIN tour_detail d ON b.tour_detail_id = d.detail_id " +
                        "WHERE b.booking_id = ?";
                stmt = conn.prepareStatement(query);
                stmt.setInt(1, tour_id);
                rs = stmt.executeQuery();

                while (rs.next()) {
                
                    String name_user = rs.getString("full_name");
                    String phone_number = rs.getString("phone_number");
                    String address = rs.getString("address");
                    String location = rs.getString("location");
                    int num_participants = rs.getInt("num_participants");
                    String priceString = rs.getString("Price");

                    
                    long price = Integer.parseInt(priceString.replace(".", ""));

                    long bill = price * num_participants;
                    String result_bill = String .valueOf(bill);
                 
                    result.setUserName(name_user);
                    result.setPhoneNumber(phone_number);
                    result.setAddress(address);
                    result.setLocation(location);
                    result.setNumParticipants(num_participants);
                    result.setBill(result_bill);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;
        }
	    public String getNameUser(int user_id) {
	    	String result = "";
			try {
				  Connection conn = DBContext.getConnection();
				String query = "select full_name from user where user_id = ?";
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, user_id);
				rs = stmt.executeQuery();
				if(rs.next()) {
					result = rs.getString("full_name");
				}
			} catch (Exception e) {}
			return result;
	    }
	    
	    public User getFull_name(String username) {
	    	User user = null;
			try {
				  Connection conn = DBContext.getConnection();
				Statement stm = conn.createStatement();
				String query = "select user_id from user where username = '"+username+"'";
				ResultSet rs = stm.executeQuery(query);
				
				if (rs.next()) {
					int id = rs.getInt("user_id");
					String full_name = getNameUser(id);
					System.out.println(full_name);
					user = new User();
					user.setFull_name(full_name);
					user.setRole(rs.getString(8));
				}
			} catch (Exception e) {}
			return user;
		}
        
        public void SendComment(int tour_id, int user_id, String content) {
           
            try {
            	  Connection conn = DBContext.getConnection();
                String insertQuery = "insert into comment(tour_id, user_id, content) values(?, ?, ?)";
                stmt = conn.prepareStatement(insertQuery);
                stmt.setInt(1, tour_id);
                stmt.setInt(2, user_id);
                stmt.setString(3, content);
    			stmt.executeUpdate();	
            } catch (Exception ex) {}
        }
        
	
	
}
