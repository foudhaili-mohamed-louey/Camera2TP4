package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import PhotoShooting.entities.Camera;

public class CameraDaolmpl implements lCameraDao {
	@Override
	public Camera save(Camera p) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Camera(id,type,name,resolution) VALUES(?,?,?,?)");
			ps.setInt(1, p.getId());
			ps.setString(2, p.getType());
			ps.setString(3, p.getName());
			ps.setDouble(4, p.getResolution());
			ps.executeUpdate();

			PreparedStatement ps2 = conn.prepareStatement("SELECT MAX(id) as MAX_ID FROM Camera");
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				p.setId(rs.getInt("MAX_ID"));
			}
			ps.close();
			ps2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Camera> CamerasParMC(String mc) {
		List<Camera> Cams = new ArrayList<Camera>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from camera where name LIKE ?");
			ps.setString(1, "%" + mc + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Camera p = new Camera();
				p.setId(rs.getInt("id"));
				p.setType(rs.getString("type"));
				p.setName(rs.getString("name"));
				p.setResolution(rs.getDouble("resolution"));
				Cams.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Cams;

	}

	@Override
	public Camera getCamera(Long id) {
		Connection conn = SingletonConnection.getConnection();
		Camera p = new Camera();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from camera where id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p.setId(rs.getInt("id"));
				p.setType(rs.getString("type"));
				p.setName(rs.getString("name"));
				p.setResolution(rs.getDouble("resolution"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public Camera updateCamera(Camera p) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE camera SET type=?,name=?,resolution=? WHERE id=?");
			ps.setString(1, p.getType());
			ps.setString(2, p.getName());
			ps.setDouble(3, p.getResolution());
			ps.setInt(4, p.getId());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return p;

	}

	@Override
	public void deleteCamera(int id) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM camera WHERE id = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}