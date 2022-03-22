package br.com.mind5.business.address.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.geo.geoCode.info.GeodeInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class AddressMergerVisiGeode extends InfoMergerVisitorTemplate<AddressInfo, GeodeInfo> {

	@Override public boolean shouldMerge(AddressInfo baseInfo, GeodeInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<AddressInfo> merge(AddressInfo baseInfo, GeodeInfo selectedInfo) {
		List<AddressInfo> results = new ArrayList<>();
		
		baseInfo.latitude = selectedInfo.latitude;
		baseInfo.longitude = selectedInfo.longitude;
		
		results.add(baseInfo);
		return results;
	}
}
