package br.com.mind5.business.planingData.info;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class PlanataCopyPlanime extends InfoCopierOneToManyTemplate<PlanataInfo, PlanimeInfo>{
	
	public PlanataCopyPlanime() {
		super();
	}
	
	
	
	@Override protected List<PlanataInfo> makeCopyHook(PlanimeInfo source) {
		List<PlanataInfo> results;
		
		results = dateResult(source);
		results = storeResult(source, results);
		results = employeeResult(source, results);
		results = materialResult(source, results);
		
		return results;
	}
	
	
	
	private List<PlanataInfo> dateResult(PlanimeInfo recordInfo) {
		List<PlanataInfo> dateResults = new ArrayList<>();
		
		for (LocalDate eachDate : recordInfo.dates) {
			PlanataInfo oneDateResult = new PlanataInfo();
			
			oneDateResult.codOwner = recordInfo.codOwner;
			oneDateResult.codLanguage = recordInfo.codLanguage;
			oneDateResult.username = recordInfo.username;
			oneDateResult.date = eachDate;
			
			dateResults.add(oneDateResult);
		}
		
		return dateResults;
	}
	
	
	
	private List<PlanataInfo> storeResult(PlanimeInfo recordInfo, List<PlanataInfo> results) {
		if (recordInfo.stores == null)
			return results;
		
		if (recordInfo.stores.isEmpty())
			return results;
		
		
		List<PlanataInfo> storeResults = new ArrayList<>();
		
		
		for (PlanataInfo eachResult : results) {			
			for (StolisInfo eachStore : recordInfo.stores) {
				PlanataInfo oneStoreResult = tryToClone(eachResult);
				oneStoreResult.codStore = eachStore.codStore;
				
				storeResults.add(oneStoreResult);
			}
		}
		
		return storeResults;
	}
	
	
	
	private List<PlanataInfo> employeeResult(PlanimeInfo recordInfo, List<PlanataInfo> results) {
		if (recordInfo.employees == null)
			return results;
		
		if (recordInfo.employees.isEmpty())
			return results;
		
		
		List<PlanataInfo> employeeResults = new ArrayList<>();
		
		
		for (PlanataInfo eachResult : results) {			
			for (EmplisInfo eachEmployee : recordInfo.employees) {
				PlanataInfo oneEmployeeResult = tryToClone(eachResult);
				oneEmployeeResult.codEmployee = eachEmployee.codEmployee;
				
				employeeResults.add(oneEmployeeResult);
			}
		}
		
		return employeeResults;
	}
	
	
	
	private List<PlanataInfo> materialResult(PlanimeInfo recordInfo, List<PlanataInfo> results) {
		if (recordInfo.materials == null)
			return results;
		
		if (recordInfo.materials.isEmpty())
			return results;
		
		
		List<PlanataInfo> materialResults = new ArrayList<>();
		
		
		for (PlanataInfo eachResult : results) {			
			for (MatlisInfo eachMaterial : recordInfo.materials) {
				PlanataInfo oneMaterialResult = tryToClone(eachResult);
				oneMaterialResult.codMat = eachMaterial.codMat;
				
				materialResults.add(oneMaterialResult);
			}
		}
		
		return materialResults;
	}
	
	
	
	private PlanataInfo tryToClone(PlanataInfo recordInfo) {
		try {
			return (PlanataInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e);
		}
	}
		
		
		
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
		
}
