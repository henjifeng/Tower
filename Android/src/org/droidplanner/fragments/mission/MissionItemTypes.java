package org.droidplanner.fragments.mission;

import java.security.InvalidParameterException;

import org.droidplanner.drone.variables.mission.MissionItem;
import org.droidplanner.drone.variables.missionD.MissionItemD;
import org.droidplanner.extra.Land;
import org.droidplanner.extra.LoiterTime;
import org.droidplanner.extra.LoiterTurns;
import org.droidplanner.extra.RegionOfInterest;
import org.droidplanner.extra.ReturnToHome;
import org.droidplanner.extra.Takeoff;
import org.droidplanner.extra.Waypoint;


public enum MissionItemTypes {
		WAYPOINT("Waypoint"),
		TAKEOFF("Takeoff"),
		RTL("Return to Launch"),
		LAND("Land"),
		LOITERN("Circle"),
		LOITERT("Loiter"),
		//LOITER("Loiter indefinitly"),
		ROI("Region of Interest"),
		SURVEY("Survey");

	private final String name;

	private MissionItemTypes(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public MissionItem getNewItem(MissionItemD item) throws InvalidItemException {
		switch (this) {
		case LAND:
			return new Land(item);
		//case LOITER:
		//	return new LoiterInfinite(item);
		case LOITERN:
			return new LoiterTurns(item);
		case LOITERT:
			return new LoiterTime(item);
		case ROI:
			return new RegionOfInterest(item);
		case RTL:
			return new ReturnToHome(item);
		case TAKEOFF:
			return new Takeoff(item);
		case WAYPOINT:
			return new Waypoint(item);
		case SURVEY:
			throw new InvalidItemException();
		}
		throw new InvalidParameterException();
	}

	class InvalidItemException extends Exception{
		private static final long serialVersionUID = 1L;

	}
}