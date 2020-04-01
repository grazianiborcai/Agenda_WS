package br.com.mind5.business.planingData.info;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.planningTime.info.PlanimeInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.info.InfoCopierOneToManyTemplate;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;

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
		results = moonaseResult(source, results);
		
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
		if (recordInfo.stolises == null)
			return results;
		
		if (recordInfo.stolises.isEmpty())
			return results;
		
		
		List<PlanataInfo> storeResults = new ArrayList<>();
		
		
		for (PlanataInfo eachResult : results) {			
			for (StolisInfo eachStore : recordInfo.stolises) {
				PlanataInfo oneStoreResult = tryToClone(eachResult);
				oneStoreResult.codStore = eachStore.codStore;
				
				storeResults.add(oneStoreResult);
			}
		}
		
		return storeResults;
	}
	
	
	
	private List<PlanataInfo> employeeResult(PlanimeInfo recordInfo, List<PlanataInfo> results) {
		if (recordInfo.emplises == null)
			return results;
		
		if (recordInfo.emplises.isEmpty())
			return results;
		
		
		List<PlanataInfo> employeeResults = new ArrayList<>();
		
		
		for (PlanataInfo eachResult : results) {			
			for (EmplisInfo eachEmployee : recordInfo.emplises) {
				PlanataInfo oneEmployeeResult = tryToClone(eachResult);
				oneEmployeeResult.codEmployee = eachEmployee.codEmployee;
				
				employeeResults.add(oneEmployeeResult);
			}
		}
		
		return employeeResults;
	}
	
	
	
	private List<PlanataInfo> materialResult(PlanimeInfo recordInfo, List<PlanataInfo> results) {
		if (recordInfo.matlises == null)
			return results;
		
		if (recordInfo.matlises.isEmpty())
			return results;
		
		
		List<PlanataInfo> materialResults = new ArrayList<>();
		
		
		for (PlanataInfo eachResult : results) {			
			for (MatlisInfo eachMaterial : recordInfo.matlises) {
				PlanataInfo oneMaterialResult = tryToClone(eachResult);
				oneMaterialResult.codMat = eachMaterial.codMat;
				
				materialResults.add(oneMaterialResult);
			}
		}
		
		return materialResults;
	}
	
	
	
	private List<PlanataInfo> moonaseResult(PlanimeInfo recordInfo, List<PlanataInfo> results) {
		if (recordInfo.moonases == null)
			return results;
		
		if (recordInfo.moonases.isEmpty())
			return results;
		
		
		List<PlanataInfo> moonaselResults = new ArrayList<>();
		
		
		for (PlanataInfo eachResult : results) {			
			for (MoonaseInfo eachMoonase : recordInfo.moonases) {
				PlanataInfo oneMoonaseResult = tryToClone(eachResult);
				oneMoonaseResult.codMoonPhase = eachMoonase.codMoonPhase;
				
				moonaselResults.add(oneMoonaseResult);
			}
		}
		
		return moonaselResults;
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
		
		SystemLog.logError(this.getClass(), e);
	}		
}
