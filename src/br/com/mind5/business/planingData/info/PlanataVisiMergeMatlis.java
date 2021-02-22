package br.com.mind5.business.planingData.info;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.materialUnit.info.Matunit;

final class PlanataVisiMergeMatlis extends InfoMergerVisitorTemplate<PlanataInfo, MatlisInfo> {

	@Override public boolean shouldMerge(PlanataInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	

	@Override public List<PlanataInfo> merge(PlanataInfo baseInfo, MatlisInfo selectedInfo) {
		List<PlanataInfo> results = new ArrayList<>();
		LocalTime maxEndTime = baseInfo.endTime;
		
		PlanataInfo eachResult = setEndTime(baseInfo, selectedInfo);
		
		if (shouldAdd(eachResult, maxEndTime))
			results.add(eachResult);
		
		
		while(shouldAdd(eachResult, maxEndTime)) {
			eachResult = shiftTime(eachResult, selectedInfo);
			
			if (shouldAdd(eachResult, maxEndTime))
				results.add(eachResult);
		}
		

		return results;
	}

	
	
	private PlanataInfo setEndTime(PlanataInfo baseInfo, MatlisInfo selectedInfo) {
		Matunit matUnit = Matunit.getMatUnit(selectedInfo.codUnit);		
		
		if (Matunit.MINUTE == matUnit)
			baseInfo.endTime = baseInfo.beginTime.plusMinutes(selectedInfo.priceUnit);
		
		return baseInfo;
	}
	
	
	
	private PlanataInfo shiftTime(PlanataInfo baseInfo, MatlisInfo selectedInfo) {
		Matunit matUnit = Matunit.getMatUnit(selectedInfo.codUnit);		
		
		if (Matunit.MINUTE == matUnit) {
			baseInfo.beginTime = baseInfo.beginTime.plusMinutes(selectedInfo.priceUnit);
			baseInfo.endTime = baseInfo.endTime.plusMinutes(selectedInfo.priceUnit);
		}
		
		return baseInfo;
	}
	
	
	
	private boolean shouldAdd(PlanataInfo eachResult, LocalTime maxEndTime) {
		return eachResult.endTime.isBefore(maxEndTime) || eachResult.endTime.equals(maxEndTime);
	}
}
