package PhotoShooting.entities;

import java.io.Serializable;

public class Camera implements Serializable{
	
	private int id;
	private String type;
	private String name;
	private double resolution;
	
	// Constructeurs
	public Camera()
	{
		super();
	}
	public Camera(int id, String type, String name, double resolution) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.resolution = resolution;
	}
	public Camera(String type, String name, double resolution) {
		super();
		this.type = type;
		this.name = name;
		this.resolution = resolution;
	}
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int l) {
		this.id = l;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getResolution() {
		return resolution;
	}

	public void setResolution(double resolution) {
		this.resolution = resolution;
	}
	

}
