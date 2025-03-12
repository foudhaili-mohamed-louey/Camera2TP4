package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import PhotoShooting.entities.Camera;
import util.JPAutil;

public class CameraDaolmpl implements lCameraDao {
    private EntityManager entityManager = JPAutil.getEntityManager("PhotoShooting");

    @Override
    public Camera save(Camera p) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(p);
        tx.commit();
        return p;
    }

    @Override
    public List<Camera> CamerasParMC(String mc) {
        return entityManager.createQuery("SELECT c FROM Camera c WHERE c.name LIKE :mc", Camera.class)
                .setParameter("mc", "%" + mc + "%")
                .getResultList();
    }

    @Override
    public Camera getCamera(int id) { // Ensure this matches the interface method signature
        return entityManager.find(Camera.class, id);
    }

    @Override
    public Camera updateCamera(Camera p) { // Renamed from updateCamera1 to updateCamera
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Camera updatedCamera = entityManager.merge(p);
        tx.commit();
        return updatedCamera;
    }

    @Override
    public void deleteCamera(int id) {
        Camera camera = entityManager.find(Camera.class, id);
        if (camera != null) {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(camera);
            tx.commit();
        }
    }
}