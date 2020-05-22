package com.s4n.delivery.service;

import java.util.List;

import com.s4n.delivery.constant.DroneStatus;
import com.s4n.delivery.dto.Drone;
import com.s4n.delivery.dto.Location;
import com.s4n.delivery.util.JsonUtil;

public class DroneService {

	private static final String FILE = "src/main/resources/drones_config.json";
	private List<Drone> drones;
	private static DroneService droneService = null;

	private DroneService() {
		load();
	}

	public Drone getAvailable() {
		Drone freeDrone = drones.stream().filter(drone -> drone.getStatus().equals(DroneStatus.FREE)).findFirst().get();
		if(freeDrone != null) {
			freeDrone.setStatus(DroneStatus.BUSY);
			System.out.println("["+freeDrone.getId()+"] Drone selected");
		}else {
			freeDrone = new Drone();
			System.out.println("No drones availables");
		}
		return freeDrone;
	}

	public void free(Drone drone) {
		drone.setStatus(DroneStatus.FREE);
		drone.setLocation(new Location());
		System.out.println("["+drone.getId()+"] Drone free");
	}

	private void load() {
		drones = JsonUtil.getInstance().convertJsonToList(FILE, Drone.class);
	}
	
	public static DroneService getInstance() {
		if (droneService == null) {
			synchronized (DroneService.class) {
				if (droneService == null) {
					droneService = new DroneService();
				}
			}
		}
		return droneService;
	}
}
