package br.com.mind5.business.planingData.info;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.materialUnit.info.Matunit;

final class PlanataVisiMergeMatlis extends InfoMergerVisitorTemplate<PlanataInfo, MatlisInfo> {
	
	@Override public List<PlanataInfo> beforeMerge(List<PlanataInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PlanataInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	

	@Override public List<PlanataInfo> merge(PlanataInfo baseInfo, MatlisInfo selectedInfo) {
		List<PlanataInfo> results = new ArrayList<>();
		LocalTime maxEndTime = baseInfo.endTime;
		
		PlanataInfo eachResult = setEndTime(selectedInfo, baseInfo);
		
		if (shouldAdd(eachResult, maxEndTime))
			results.add(eachResult);
		
		
		while(shouldAdd(eachResult, maxEndTime)) {
			eachResult = shiftTime(selectedInfo, eachResult);
			
			if (shouldAdd(eachResult, maxEndTime))
				results.add(eachResult);
		}
		

		return results;
	}
	
	
	
	@Override public InfoUniquifier<PlanataInfo> getUniquifier() {
		return null;
	}

	
	
	private PlanataInfo setEndTime(MatlisInfo mat, PlanataInfo planata) {
		Matunit matUnit = Matunit.getMatUnit(mat.codUnit);		
		PlanataInfo resultInfo = makeClone(planata);
		
		if (Matunit.MINUTE == matUnit)
			resultInfo.endTime = resultInfo.beginTime.plusMinutes(mat.priceUnit);
		
		return resultInfo;
	}
	
	
	
	private PlanataInfo shiftTime(MatlisInfo selectedInfo, PlanataInfo baseInfo) {
		Matunit matUnit = Matunit.getMatUnit(selectedInfo.codUnit);		
		PlanataInfo resultInfo = makeClone(baseInfo);
		
		if (Matunit.MINUTE == matUnit) {
			resultInfo.beginTime = resultInfo.beginTime.plusMinutes(selectedInfo.priceUnit);
			resultInfo.endTime = resultInfo.endTime.plusMinutes(selectedInfo.priceUnit);
		}
		
		return resultInfo;
	}
	
	
	
	private boolean shouldAdd(PlanataInfo eachResult, LocalTime maxEndTime) {
		return eachResult.endTime.isBefore(maxEndTime) || eachResult.endTime.equals(maxEndTime);
	}
	
	
	
	private PlanataInfo makeClone(PlanataInfo recordInfo) {
		try {
			return (PlanataInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
