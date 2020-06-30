package br.com.mind5.geo.geoCode.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class GeodeSetterLocation extends InfoSetterTemplate<GeodeInfo> {
	
	@Override protected GeodeInfo setAttrHook(GeodeInfo recordInfo) {
		StringBuilder result = new StringBuilder();
		
		if (recordInfo.street != null)
			result.append(recordInfo.street);
		
		if (recordInfo.streetNumber != null)
			result.append(recordInfo.streetNumber);
		
		if (recordInfo.district != null)
			result.append(recordInfo.district);
		
		if (recordInfo.city != null)
			result.append(recordInfo.city);
		
		if (recordInfo.txtState != null)
			result.append(recordInfo.txtState);
		
		if (recordInfo.txtCountry != null)
			result.append(recordInfo.txtCountry);
		
		
		recordInfo.location = result.toString();
		return recordInfo;
	}
}
