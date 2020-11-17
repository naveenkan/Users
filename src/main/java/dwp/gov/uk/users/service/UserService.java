package dwp.gov.uk.users.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dwp.gov.uk.users.model.User;
import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;

@Service
public class UserService {

	private RestTemplate restemplate = new RestTemplate();

	public List<User> getLondonUsers() {
		User[] users = restemplate.getForObject("https://bpdts-test-app.herokuapp.com/users", User[].class);
		return Arrays.stream(users).filter(u ->

		{
			double londonLatitude = 51.5345740;
			double londonLongitude = -0.1141045;

			// Using net.sf.geographiclib.Geodesic inverse method to calculate the distance
			// by latitude&longitude
			GeodesicData result = Geodesic.WGS84.Inverse(londonLatitude, londonLongitude, u.getLatitude(),
					u.getLongitude());
			double distanceInMeters = result.s12;
			double distanceInMiles = distanceInMeters / 1609.34;
			return distanceInMiles <= 50;
		}).collect(Collectors.toList());

	}

}
