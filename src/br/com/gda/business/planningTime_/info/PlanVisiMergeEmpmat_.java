package br.com.gda.business.planningTime_.info;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoMergerVisitor_;

final class PlanVisiMergeEmpmat_ implements InfoMergerVisitor_<PlanInfo, PlanInfo, EmpmatInfo> {
	
	@Override public PlanInfo writeRecord(PlanInfo sourceOne, EmpmatInfo sourceTwo) {
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
	
	
	
	private void checkArgument(PlanInfo sourceOne, EmpmatInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private boolean shouldMerge(PlanDataInfo planData, EmpmatInfo matEmp) {
		if (//planData.codStore    == matEmp.codStore 	&&
			planData.codEmployee == matEmp.codEmployee 	&&
			isMatService(matEmp)						&&
			isTimeUnit(matEmp))
			
			return true;
		
		
		return false;
	}
	
	
	
	private boolean isMatService(EmpmatInfo matEmp) {
		if (matEmp.codCategory == 2)
			return true;
		
		return false;
	}
	
	
	
	private boolean isTimeUnit(EmpmatInfo matEmp) {
		if (matEmp.codUnit.equals("MIN"))
			return true;
		
		return false;
	}
	
	
	
	private List<PlanDataInfo> mergeMatEmp(PlanDataInfo planData, EmpmatInfo matEmp) {
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



	@Override public boolean shouldWrite(PlanInfo sourceOne, EmpmatInfo sourceTwo) {
		if (sourceTwo.codMat <= 0)
			return false;
		
	//	if (sourceTwo.codStore <= 0)
	//		return false;
		
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
