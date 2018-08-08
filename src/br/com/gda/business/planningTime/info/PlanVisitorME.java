package br.com.gda.business.planningTime.info;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.VisitorMerger;

final class PlanVisitorME implements VisitorMerger<PlanInfo, PlanInfo, MatEmpInfo> {
	private final boolean DONT_SKIP = false;
	private final boolean SKIP = true;
	
	
	@Override public PlanInfo mergeRecord(PlanInfo sourceOne, MatEmpInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		PlanInfo resultInfo = new PlanInfo();	
		resultInfo.stores.addAll(sourceOne.stores);
		resultInfo.employees.addAll(sourceOne.employees);
		resultInfo.materials.addAll(sourceOne.materials);
		resultInfo.weekdays.addAll(sourceOne.weekdays);
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (shouldSkip(eachData, sourceTwo))
				continue;			
			
			PlanDataInfo dataInfo = makeClone(eachData);
			
			dataInfo.codMat = sourceTwo.codMat;		
			dataInfo.codEmployee = eachData.codEmployee;
			resultInfo.datas.add(dataInfo);
		}
		

		return resultInfo;
	}
	
	
	
	private boolean shouldSkip(PlanDataInfo planData, MatEmpInfo matEmp) {
		if (planData.codOwner    == matEmp.codOwner &&
			planData.codStore    == matEmp.codStore &&
			planData.codEmployee == matEmp.codEmployee)
			
			return DONT_SKIP;
		
		
		return SKIP;
	}
	
	
	
	private PlanDataInfo makeClone(PlanDataInfo planData) {
		try {
			return (PlanDataInfo) planData.clone();
			
		} catch (CloneNotSupportedException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	
	
	private void checkArgument(PlanInfo sourceOne, MatEmpInfo sourceTwo) {
		if (sourceOne.datas == null)
			throw new NullPointerException("sourceOne.datas" + SystemMessage.NULL_ARGUMENT);
		
		if (sourceOne.datas.isEmpty())
			throw new IllegalArgumentException("sourceOne.datas" + SystemMessage.EMPTY_ARGUMENT);
		
		
		for (PlanDataInfo eachData : sourceOne.datas) {
			if (eachData.codOwner != sourceTwo.codOwner)
				throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
			
			if (eachData.codStore != sourceTwo.codStore)
				throw new IllegalArgumentException("codStore" + SystemMessage.ARGUMENT_DONT_MATCH);
			
			if (eachData.codEmployee != sourceTwo.codEmployee)
				throw new IllegalArgumentException("codEmployee" + SystemMessage.ARGUMENT_DONT_MATCH);
		}
	}
}
