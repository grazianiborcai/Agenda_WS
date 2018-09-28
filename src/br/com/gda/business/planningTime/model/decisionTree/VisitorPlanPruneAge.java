package br.com.gda.business.planningTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.age.info.AgeInfo;
import br.com.gda.business.planningTime.info.PlanInfo;
import br.com.gda.business.planningTime.info.PlanPruner;
import br.com.gda.model.decisionTree.DeciActionTransVisitor;

final class VisitorPlanPruneAge implements DeciActionTransVisitor<PlanInfo> {
	
	@Override public List<PlanInfo> executeTransformation(List<PlanInfo> recordInfos) {		
		return prune(recordInfos);
	}	
	
	
	
	private List<PlanInfo> prune(List<PlanInfo> recordInfos) {
		List<AgeInfo> ages = new ArrayList<>();
		AgeInfo ageDefault = new AgeInfo();
		ages.add(ageDefault);		
		
		return new PlanPruner().prune(recordInfos, ages);
	}
}
