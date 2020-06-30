package br.com.mind5.geo.geoCode.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class GeodeSetterLocation extends InfoSetterTemplate<GeodeInfo> {
	
	@Override protected GeodeInfo setAttrHook(GeodeInfo recordInfo) {
		StringBuilder result = new StringBuilder();
		
		if (recordInfo.street != null) {
			result.append(recordInfo.street);
			result.append(" ");
		}
		
		
		if (recordInfo.streetNumber != null) {
			result.append(recordInfo.streetNumber);
			result.append(" ");
		}
		
		
		if (recordInfo.district != null) {
			result.append(recordInfo.district);
			result.append(" ");
		}
		
		
		if (recordInfo.city != null) {
			result.append(recordInfo.city);
			result.append(" ");
		}
		
		
		if (recordInfo.txtState != null) {
			result.append(recordInfo.txtState);
			result.append(" ");
		}

		
		if (recordInfo.txtCountry != null)
			result.append(recordInfo.txtCountry);
		
		
		recordInfo.location = result.toString();
		recordInfo.location = recordInfo.location.trim();
		recordInfo.location = recordInfo.location.replaceAll("\\s+","+");
		
		return recordInfo;
	}
}
