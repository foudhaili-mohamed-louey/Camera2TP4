package web;

import java.util.ArrayList;
import java.util.List;

import PhotoShooting.entities.Camera;

public class CameraModele {
	private String motCle;
	List<Camera> cameras = new ArrayList<>();
	public String getMotCle() {
	return motCle;
	}
	public void setMotCle(String motCle) {
	this.motCle = motCle;
	}
	public List<Camera> getCameras() {
	return cameras;
	}
	public void setCameras(List<Camera> c) {
	this.cameras = c;
	}

}
