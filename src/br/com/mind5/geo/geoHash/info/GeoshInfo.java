package br.com.mind5.geo.geoHash.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class GeoshInfo extends InfoRecord implements Cloneable {
	public String geoHash03;
	public String geoHash04;	
	public String geoHash05;
	public String geoHash12;
	public float longitude;
	public float latitude;
	public String username;
	
	
	public GeoshInfo() {
		super();
		
		longitude = DefaultValue.number();
		latitude = DefaultValue.number();
	}
	
	
	
	public static GeoshInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, GeoshInfo.class);
	}
	
	
	
	public static List<GeoshInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, GeoshInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (geoHash12 != null)
			result = result * 31 + geoHash12.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof GeoshInfo))
			return false;
		
		
		GeoshInfo obj = (GeoshInfo) o;		
		return (super.isStringEqual(geoHash12, obj.geoHash12));
	}
}
