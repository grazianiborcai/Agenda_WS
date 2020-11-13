package br.com.mind5.business.cartReserveConflict.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CartercoVisiMergeCarterve implements InfoMergerVisitor<CartercoInfo, CarterveInfo> {
	
	@Override public List<CartercoInfo> beforeMerge(List<CartercoInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CartercoInfo baseInfo, CarterveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CartercoInfo> merge(CartercoInfo baseInfo, CarterveInfo selectedInfo) {
		List<CartercoInfo> results = new ArrayList<>();
		
		CartercoInfo result = CartercoInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CartercoInfo> getUniquifier() {
		return null;
	}
}
