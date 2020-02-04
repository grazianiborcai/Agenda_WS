package br.com.mind5.business.planingData.info;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.common.MatUnit;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.temp.InfoMergerVisitorV3;

final class PlanataVisiMergeMatlis implements InfoMergerVisitorV3<PlanataInfo, MatlisInfo> {
	
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
		MatUnit matUnit = MatUnit.getMatUnit(mat.codUnit);		
		PlanataInfo resultInfo = makeClone(planata);
		
		if (MatUnit.MINUTE == matUnit)
			resultInfo.endTime = resultInfo.beginTime.plusMinutes(mat.priceUnit);
		
		return resultInfo;
	}
	
	
	
	private PlanataInfo shiftTime(MatlisInfo selectedInfo, PlanataInfo baseInfo) {
		MatUnit matUnit = MatUnit.getMatUnit(selectedInfo.codUnit);		
		PlanataInfo resultInfo = makeClone(baseInfo);
		
		if (MatUnit.MINUTE == matUnit) {
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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
