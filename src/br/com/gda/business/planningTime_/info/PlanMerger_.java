package br.com.gda.business.planningTime_.info;

import java.util.List;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoWritterFactory_;

public final class PlanMerger_ extends InfoWritterFactory_<PlanInfo> {	
	
	public PlanMerger_() {
		super(new PlanUniquifier());
	}
	
	
	
	public PlanInfo merge(PlanInfo sourceOne, StowotmInfo sourceTwo) {
		return new PlanMergerSWT_().merge(sourceOne, sourceTwo);
	}
	
	
	
	public PlanInfo merge(PlanInfo sourceOne, StoreInfo sourceTwo) {
		return new PlanMergerStore_().merge(sourceOne, sourceTwo);
	}
	
	
	
	public PlanInfo merge(PlanInfo sourceOne, EmpwotmInfo sourceTwo) {
		return new PlanMergerEWT_().merge(sourceOne, sourceTwo);
	}
	
	
	
	public PlanInfo merge(PlanInfo sourceOne, EmpInfo sourceTwo) {
		return new PlanMergerEmp_().merge(sourceOne, sourceTwo);
	}
	
	
	
	public PlanInfo merge(PlanInfo sourceOne, EmpmatInfo sourceTwo) {
		return new PlanMergerME_().merge(sourceOne, sourceTwo);
	}
	
	
	
	public PlanInfo merge(PlanInfo sourceOne, MatInfo sourceTwo) {
		return new PlanMergerMat_().merge(sourceOne, sourceTwo);
	}
	
	
	
	public PlanInfo merge(PlanInfo sourceOne, WeekdayInfo sourceTwo) {
		return new PlanMergerWeekday_().merge(sourceOne, sourceTwo);
	}
	
		
	
	@SuppressWarnings("unchecked")
	@Override protected List<PlanInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof StowotmInfo		)
			return new PlanMergerSWT_().merge((List<PlanInfo>) sourceOnes, (List<StowotmInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof StoreInfo			)
			return new PlanMergerStore_().merge((List<PlanInfo>) sourceOnes, (List<StoreInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof EmpwotmInfo		)
			return new PlanMergerEWT_().merge((List<PlanInfo>) sourceOnes, (List<EmpwotmInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof EmpInfo			)
			return new PlanMergerEmp_().merge((List<PlanInfo>) sourceOnes, (List<EmpInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof EmpmatInfo			)
			return new PlanMergerME_().merge((List<PlanInfo>) sourceOnes, (List<EmpmatInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof MatInfo			)
			return new PlanMergerMat_().merge((List<PlanInfo>) sourceOnes, (List<MatInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PlanInfo 	&&
			sourceTwos.get(0) instanceof WeekdayInfo			)
			return new PlanMergerWeekday_().merge((List<PlanInfo>) sourceOnes, (List<WeekdayInfo>) sourceTwos);
		
		return null;
	} 
}
