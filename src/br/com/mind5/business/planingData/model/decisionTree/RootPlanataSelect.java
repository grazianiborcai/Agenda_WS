package br.com.mind5.business.planingData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.action.LazyPlanataNodeReserve;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public class RootPlanataSelect extends DeciTreeTemplateRead<PlanataInfo> {
	
	public RootPlanataSelect(DeciTreeOption<PlanataInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PlanataInfo> buildCheckerHook(DeciTreeOption<PlanataInfo> option) {
		List<ModelChecker<PlanataInfo>> queue = new ArrayList<>();		
		ModelChecker<PlanataInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PlanataInfo>> buildActionsOnPassedHook(DeciTreeOption<PlanataInfo> option) {
		List<ActionStd<PlanataInfo>> actions = new ArrayList<>();		
		
		ActionStd<PlanataInfo> select = new RootPlanataSelectNoReserve(option).toAction();	
		ActionLazy<PlanataInfo> nodeReserve = new LazyPlanataNodeReserve(option.conn, option.schemaName);
		
		select.addPostAction(nodeReserve);
		
		actions.add(select);
		return actions;
	}
}
