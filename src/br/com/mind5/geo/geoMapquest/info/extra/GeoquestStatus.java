package br.com.mind5.geo.geoMapquest.info.extra;

import java.util.ArrayList;
import java.util.List;

public final class GeoquestStatus {
	public String statuscode;
	public GeoquestCopyright copyright;
	public List<GeoquestMessage> messages;
	
		
	public GeoquestStatus() {
		super();
		
		messages = new ArrayList<>();
	}
};
