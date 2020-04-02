package br.com.mind5.business.planingData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.action.LazyPlanataNodeReserve;
import br.com.mind5.business.planingData.model.checker.PlanataCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public class RootPlanataSelect extends DeciTreeReadTemplate<PlanataInfo> {
	
	public RootPlanataSelect(DeciTreeOption<PlanataInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PlanataInfo> buildDecisionCheckerHook(DeciTreeOption<PlanataInfo> option) {
		List<ModelChecker<PlanataInfo>> queue = new ArrayList<>();		
		ModelChecker<PlanataInfo> checker;

		checker = new PlanataCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PlanataInfo>> buildActionsOnPassedHook(DeciTreeOption<PlanataInfo> option) {
		List<ActionStdV1<PlanataInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<PlanataInfo> select = new RootPlanataSelectNoReserve(option).toAction();	
		ActionLazyV1<PlanataInfo> nodeReserve = new LazyPlanataNodeReserve(option.conn, option.schemaName);
		
		select.addPostAction(nodeReserve);
		
		actions.add(select);
		return actions;
	}
}
