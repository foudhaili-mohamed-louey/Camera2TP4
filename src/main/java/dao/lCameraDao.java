package dao;

import java.util.List;

import PhotoShooting.entities.Camera;

public interface lCameraDao {
	public Camera save(Camera p);

	public List<Camera> CamerasParMC(String mc);

	public Camera getCamera(int id);

	public Camera updateCamera(Camera p);

	public void deleteCamera(int id);
}