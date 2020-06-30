package br.com.mind5.geo.geoCode.info;

import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class GeodeInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public String codCountry;
	public String txtCountry;
	public String codState;
	public String txtState;
	public String city;
	public String district;
	public String street;
	public String streetNumber;
	public String location;
	public float longitude;
	public float latitude;
	public String username;
	
	
	public GeodeInfo() {
		super();
		
		codOwner = DefaultValue.number();
		longitude = DefaultValue.geo();
		latitude = DefaultValue.geo();
	}
	
	
	
	public static GeodeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, GeodeInfo.class);
	}
	
	
	
	public static List<GeodeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, GeodeInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (codCountry != null)
			result = result * 31 + codCountry.hashCode();
		
		if (codState != null)
			result = result * 31 + codState.hashCode();
		
		if (city != null)
			result = result * 31 + city.hashCode();
		
		if (street != null)
			result = result * 31 + street.hashCode();
		
		if (streetNumber != null)
			result = result * 31 + streetNumber.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof GeodeInfo))
			return false;
		
		
		GeodeInfo obj = (GeodeInfo) o;		
		return (super.isStringEqual(codCountry  , obj.codCountry  ) &&
				super.isStringEqual(codState    , obj.codState    ) &&
				super.isStringEqual(city        , obj.city        ) &&
				super.isStringEqual(street      , obj.street      ) &&
				super.isStringEqual(streetNumber, obj.streetNumber)		);
	}
}
