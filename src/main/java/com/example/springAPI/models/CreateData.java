	package com.example.springAPI.models;
	
	import org.springframework.data.annotation.Id;
	import org.springframework.data.mongodb.core.mapping.Document;
	
	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;

	@Document(collection = "create_data" )
	public class CreateData {
		@Id
		private int id;
		private String name;
		private double latitude;
		private double longitude;
		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}
		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 * @return the latitude
		 */
		public double getLatitude() {
			return latitude;
		}
		/**
		 * @param latitude the latitude to set
		 */
		public void setLatitude(double latitude) {
			this.latitude = latitude;
		}
		/**
		 * @return the langitude
		 */
		public double getLongitude() {
			return longitude;
		}
		/**
		 * @param langitude the langitude to set
		 */
		public void setLongitude(double longitude) {
			this.longitude = longitude;
		}
		public CreateData(int id, String name, double latitude, double longitude) {
			super();
			this.id = id;
			this.name = name;
			this.latitude = latitude;
			this.longitude = longitude;
		}
		public CreateData() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
	
	}
