package br.com.mind5.business.address.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.geo.geoHash.info.GeoshInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class AddressVisiMergeGeosh implements InfoMergerVisitorV3<AddressInfo, GeoshInfo> {
	
	@Override public List<AddressInfo> beforeMerge(List<AddressInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(AddressInfo baseInfo, GeoshInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<AddressInfo> merge(AddressInfo baseInfo, GeoshInfo selectedInfo) {
		List<AddressInfo> results = new ArrayList<>();
		
		baseInfo.geoHash01 = selectedInfo.geoHash01;
		baseInfo.geoHash02 = selectedInfo.geoHash02;
		baseInfo.geoHash03 = selectedInfo.geoHash03;
		baseInfo.geoHash04 = selectedInfo.geoHash04;
		baseInfo.geoHash05 = selectedInfo.geoHash05;
		baseInfo.geoHash12 = selectedInfo.geoHash12;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<AddressInfo> getUniquifier() {
		return null;
	}
}