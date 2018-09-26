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
		if (sourceTwo.codMat <= 0)
			throw new IllegalArgumentException("sourceTwo.codMat" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwo.codStore <= 0)
			throw new IllegalArgumentException("sourceTwo.codEmployee" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceTwo.codEmployee <= 0)
			throw new IllegalArgumentException("sourceTwo.codEmployee" + SystemMessage.NULL_ARGUMENT);
		
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner <= 0)
				throw new IllegalArgumentException("codOwner" + SystemMessage.MANDATORY_FIELD_EMPTY);
			
			if (eachData.codOwner != sourceTwo.codOwner)
				throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
			
			if (eachData.codStore <= 0)
				throw new IllegalArgumentException("codEmployee" + SystemMessage.NULL_ARGUMENT);
			
			if (eachData.codEmployee <= 0)
				throw new IllegalArgumentException("codEmployee" + SystemMessage.NULL_ARGUMENT);
		}
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
}
