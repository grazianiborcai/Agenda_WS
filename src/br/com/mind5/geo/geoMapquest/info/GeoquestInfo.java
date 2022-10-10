package br.com.mind5.geo.geoMapquest.info;

import java.util.List;

import br.com.mind5.geo.geoMapquest.info.extra.GeoquestOption;
import br.com.mind5.geo.geoMapquest.info.extra.GeoquestResult;
import br.com.mind5.geo.geoMapquest.info.extra.GeoquestStatus;
import br.com.mind5.info.InfoRecord;

public final class GeoquestInfo extends InfoRecord implements Cloneable{
	public String location;
	public GeoquestStatus info;
	public GeoquestOption options;
	public List<GeoquestResult> results;
	
	
	public GeoquestInfo() {
		super();
	}
	
	
	public static GeoquestInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, GeoquestInfo.class);
	}
	
	
	
	public static List<GeoquestInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, GeoquestInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
