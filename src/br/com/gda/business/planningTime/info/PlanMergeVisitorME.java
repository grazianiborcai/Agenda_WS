package br.com.gda.business.planningTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class PlanMergeVisitorME implements InfoMergerVisitor<PlanInfo, PlanInfo, MatEmpInfo> {
	
	@Override public PlanInfo writeRecord(PlanInfo sourceOne, MatEmpInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceOne.stores);
		resultInfo.employees.addAll(sourceOne.employees);
		resultInfo.materials.addAll(sourceOne.materials);
		resultInfo.weekdays.addAll(sourceOne.weekdays);
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (shouldMerge(eachData, sourceTwo)) {		
				List<PlanDataInfo> mergedResults = mergeMatEmp(eachData, sourceTwo);
				resultInfo.datas.addAll(mergedResults);
			}
		}
		

		return resultInfo;
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, MatEmpInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private boolean shouldMerge(PlanDataInfo planData, MatEmpInfo matEmp) {
		if (planData.codStore    == matEmp.codStore 	&&
			planData.codEmployee == matEmp.codEmployee 	&&
			isMatService(matEmp)						&&
			isTimeUnit(matEmp))
			
			return true;
		
		
		return false;
	}
	
	
	
	private boolean isMatService(MatEmpInfo matEmp) {
		if (matEmp.codCategory == 2)
			return true;
		
		return false;
	}
	
	
	
	private boolean isTimeUnit(MatEmpInfo matEmp) {
		if (matEmp.codUnit.equals("MIN"))
			return true;
		
		return false;
	}
	
	
	
	private List<PlanDataInfo> mergeMatEmp(PlanDataInfo planData, MatEmpInfo matEmp) {
		PlanDataInfo dataResult = makeClone(planData);
		
		dataResult.codMat = matEmp.codMat;	
		
		List<PlanDataInfo> dataResults = new ArrayList<>();
		dataResults.add(dataResult);
		
		return dataResults;
	}
	
	
	
	private PlanDataInfo makeClone(PlanDataInfo planData) {
		try {
			return (PlanDataInfo) planData.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalArgumentException(e);
		}
	}



	@Override public boolean shouldWrite(PlanInfo sourceOne, MatEmpInfo sourceTwo) {
		if (sourceTwo.codMat <= 0)
			return false;
		
		if (sourceTwo.codStore <= 0)
			return false;
		
		if (sourceTwo.codEmployee <= 0)
			return false;
		
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner <= 0)
				return false;
			
			if (eachData.codOwner != sourceTwo.codOwner)
				return false;
			
			if (eachData.codStore <= 0)
				return false;
			
			if (eachData.codEmployee <= 0)
				return false;
		}
		
		
		return true;
	}
}
