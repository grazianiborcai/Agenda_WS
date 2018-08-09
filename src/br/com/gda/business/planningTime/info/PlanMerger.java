package br.com.gda.business.planningTime.info;

import java.util.List;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.info.InfoMergerTemplate;

public final class PlanMerger extends InfoMergerTemplate<PlanInfo> {	
	
	public PlanMerger() {
		super(new PlanUniquifier());
	}
	
	
	
	public PlanInfo merge(PlanInfo sourceOne, StoreWTimeInfo sourceTwo) {
		return new PlanMergerSWT().merge(sourceOne, sourceTwo);
	}
	
	
	
	public PlanInfo merge(PlanInfo sourceOne, StoreInfo sourceTwo) {
		return new PlanMergerStore().merge(sourceOne, sourceTwo);
	}
	
	
	
	public PlanInfo merge(PlanInfo sourceOne, EmpWTimeInfo sourceTwo) {
		return new PlanMergerEWT().merge(sourceOne, sourceTwo);
	}
	
	
	
	public PlanInfo merge(PlanInfo sourceOne, EmpInfo sourceTwo) {
		return new PlanMergerEmp().merge(sourceOne, sourceTwo);
	}
	
	
	
	public PlanInfo merge(PlanInfo sourceOne, MatEmpInfo sourceTwo) {
		return new PlanMergerME().merge(sourceOne, sourceTwo);
	}
	
	
	
	public PlanInfo merge(PlanInfo sourceOne, MatInfo sourceTwo) {
		return new PlanMergerMat().merge(sourceOne, sourceTwo);
	}
	
		
	
	@SuppressWarnings("unchecked")
	@Override protected List<PlanInfo> mergeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof StoreWTimeInfo		)
			return new PlanMergerSWT().merge((List<PlanInfo>) sourceOnes, (List<StoreWTimeInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof StoreInfo			)
			return new PlanMergerStore().merge((List<PlanInfo>) sourceOnes, (List<StoreInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof EmpWTimeInfo		)
			return new PlanMergerEWT().merge((List<PlanInfo>) sourceOnes, (List<EmpWTimeInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof EmpInfo			)
			return new PlanMergerEmp().merge((List<PlanInfo>) sourceOnes, (List<EmpInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof MatEmpInfo			)
			return new PlanMergerME().merge((List<PlanInfo>) sourceOnes, (List<MatEmpInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof MatInfo			)
			return new PlanMergerMat().merge((List<PlanInfo>) sourceOnes, (List<MatInfo>) sourceTwos);
		
		return null;
	} 
}
