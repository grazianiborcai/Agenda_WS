package br.com.mind5.business.calendarCatalogueData.info;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.info.InfoPrunerListVisitor;

final class CalguataVisiPrunePlanata implements InfoPrunerListVisitor<CalguataInfo, PlanataInfo> {
	
	@Override public List<CalguataInfo> pruneRecord(List<CalguataInfo> baseInfos, List<PlanataInfo> selectedInfos) {
		Set<CalguataInfo> results = new HashSet<>();
		
		for (CalguataInfo eachBase : baseInfos) {
			for (PlanataInfo eachSelected : selectedInfos) {
				if (eachSelected.codOwner == eachBase.codOwner 	&&
					eachSelected.codStore == eachBase.codStore 	&&
					eachSelected.codMat   == eachBase.codMat 	&&
					eachSelected.date.isEqual(eachBase.date)		)
					
				results.add(eachBase);
			}				
		}
		
		
		return new ArrayList<>(results);
	}
}
