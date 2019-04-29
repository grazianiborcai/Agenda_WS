package br.com.gda.business.planningTime_.info;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.masterData.info.common.MatCateg;
import br.com.gda.business.masterData.info.common.MatUnit;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class PlanVisiMergeEmpmat implements InfoMergerVisitorV2<PlanInfo, EmpmatInfo> {
	
	@Override public PlanInfo writeRecord(EmpmatInfo sourceOne, PlanInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceTwo.stores);
		resultInfo.employees.addAll(sourceTwo.employees);
		resultInfo.materials.addAll(sourceTwo.materials);
		resultInfo.weekdays.addAll(sourceTwo.weekdays);
		
		for (PlanDataInfo eachData : sourceTwo.datas) {
			if (shouldMerge(eachData, sourceOne)) {		
				List<PlanDataInfo> mergedResults = mergeMatEmp(eachData, sourceOne);
				resultInfo.datas.addAll(mergedResults);
			}
		}
		

		return resultInfo;
	}
	
	
	
	private void checkArgument(EmpmatInfo sourceOne, PlanInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private boolean shouldMerge(PlanDataInfo planData, EmpmatInfo matEmp) {
		if (planData.codEmployee == matEmp.codEmployee 	&&
			isMatService(matEmp)						&&
			isTimeUnit(matEmp))
			
			return true;
		
		
		return false;
	}
	
	
	
	private boolean isMatService(EmpmatInfo matEmp) {
		if (matEmp.codCategory == MatCateg.SERVICE.getCodMatCateg())
			return true;
		
		return false;
	}
	
	
	
	private boolean isTimeUnit(EmpmatInfo matEmp) {
		if (matEmp.codUnit.equals(MatUnit.MINUTE.getCodUnit()))
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
			logException(e);
			throw new IllegalStateException(e); 
		}
	}



	@Override public boolean shouldWrite(EmpmatInfo sourceOne, PlanInfo sourceTwo) {
		if (sourceOne.codMat <= 0)
			return false;
		
		if (sourceOne.codEmployee <= 0)
			return false;
		
		
		for (PlanDataInfo eachData : sourceTwo.datas) {
			if (eachData.codOwner <= 0)
				return false;
			
			if (eachData.codOwner != sourceOne.codOwner)
				return false;
			
			if (eachData.codStore <= 0)
				return false;
			
			if (eachData.codEmployee <= 0)
				return false;
		}
		
		
		return true;
	}
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
