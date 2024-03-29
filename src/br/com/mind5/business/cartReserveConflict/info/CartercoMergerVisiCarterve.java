package br.com.mind5.business.cartReserveConflict.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CartercoMergerVisiCarterve extends InfoMergerVisitorTemplate<CartercoInfo, CarterveInfo> {

	@Override public boolean shouldMerge(CartercoInfo baseInfo, CarterveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CartercoInfo> merge(CartercoInfo baseInfo, CarterveInfo selectedInfo) {
		List<CartercoInfo> results = new ArrayList<>();
		
		CartercoInfo result = CartercoInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
