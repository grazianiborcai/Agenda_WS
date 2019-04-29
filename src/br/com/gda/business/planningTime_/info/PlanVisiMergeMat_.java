package br.com.gda.business.planningTime_.info;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor_;

final class PlanVisiMergeMat_ implements InfoMergerVisitor_<PlanInfo, PlanInfo, MatInfo> {

	@Override public PlanInfo writeRecord(PlanInfo sourceOne, MatInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
				
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceOne.stores);
		resultInfo.employees.addAll(sourceOne.employees);
		resultInfo.materials.addAll(sourceOne.materials);
		resultInfo.weekdays.addAll(sourceOne.weekdays);		
		
		//TODO: substituir por lambda
		for (PlanDataInfo eachPlanData : sourceOne.datas) {
			if (shouldMerge(eachPlanData, sourceTwo)) {		
				MatInfo copyMat = makeCopy(sourceTwo);
				resultInfo.materials.add(copyMat);
				break;
			}
		}
		
		resultInfo.materials.add(sourceTwo);
		
		
		for (PlanDataInfo eachPlanData : sourceOne.datas) {
			if (shouldMerge(eachPlanData, sourceTwo)) {				
				List<PlanDataInfo> mergedResults = mergeMat(eachPlanData, sourceTwo);
				resultInfo.datas.addAll(mergedResults);
			}
		}
		
		
		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, MatInfo sourceTwo) {	
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private boolean shouldMerge(PlanDataInfo planData, MatInfo mat) {
		if (planData.codMat == mat.codMat)
			return true;
		
		return false;
	}
	
	
	
	private MatInfo makeCopy(MatInfo mat) {
		MatInfo copyMat = new MatInfo();
		
		copyMat.codOwner = mat.codOwner;
		copyMat.codMat = mat.codMat;
		copyMat.txtMat = mat.txtMat;
		copyMat.description = mat.description;
		copyMat.codType = mat.codType;
		copyMat.txtType = mat.txtType;
		copyMat.codMatCateg = mat.codMatCateg;
		copyMat.txtMatCateg = mat.txtMatCateg;
		copyMat.price = mat.price;
		copyMat.priceUnit = mat.priceUnit;
		copyMat.codCurr = mat.codCurr;
		copyMat.txtCurr = mat.txtCurr;
		copyMat.codUnit = mat.codUnit;
		copyMat.txtUnit = mat.txtUnit;
		copyMat.codGroup = mat.codGroup;
		copyMat.txtGroup = mat.txtGroup; 
		copyMat.codBusiness = mat.codBusiness;
		copyMat.txtBusiness = mat.txtBusiness; 
		copyMat.codLanguage = mat.codLanguage;
		
		return copyMat;
	}
	
	
	
	private List<PlanDataInfo> mergeMat(PlanDataInfo planData, MatInfo mat) {
		List<PlanDataInfo> results = new ArrayList<>();
		
		LocalTime minTime = LocalTime.of(planData.beginTime.getHour(), planData.beginTime.getMinute());
		LocalTime maxTime = LocalTime.of(planData.endTime.getHour(), planData.endTime.getMinute());
		
		LocalTime newBeginTime = LocalTime.of(minTime.getHour(), minTime.getMinute());
		LocalTime newEndTime = LocalTime.of(minTime.getHour(), minTime.getMinute());
		
		
		while (maxTime.isAfter(newEndTime)) {
			PlanDataInfo eachResult = makeClone(planData);
			eachResult.codMat = mat.codMat;
			
			newEndTime = newBeginTime.plusMinutes(mat.priceUnit);
			
			eachResult.beginTime = LocalTime.of(newBeginTime.getHour(), newBeginTime.getMinute());
			eachResult.endTime = LocalTime.of(newEndTime.getHour(), newEndTime.getMinute());
			
			newBeginTime = LocalTime.of(newEndTime.getHour(), newEndTime.getMinute());
			
			
			if (isRangeValid(newEndTime, maxTime))
				results.add(eachResult);
		}
		
		return results;
	}
	
	
	
	private PlanDataInfo makeClone(PlanDataInfo planData) {
		try {
			return (PlanDataInfo) planData.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private boolean isRangeValid(LocalTime endTime, LocalTime maxTime) {
		return (maxTime.isAfter(endTime) || maxTime.equals(endTime));
	}



	@Override public boolean shouldWrite(PlanInfo sourceOne, MatInfo sourceTwo) {
		if (sourceTwo.codMat <= 0)
			return false;
		
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner <= 0)
				return false;
			
			if (eachData.codOwner != sourceTwo.codOwner)
				return false;
			
			if (eachData.codMat <= 0)
				return false;
		}
		
		
		return true;
	}
}
