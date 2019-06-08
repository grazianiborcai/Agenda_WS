package br.com.gda.business.planingData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.business.planingData.model.action.LazyPlanataPruneOrderve;
import br.com.gda.business.planingData.model.action.StdPlanataPruneCarterve;
import br.com.gda.business.planingData.model.checker.PlanataCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public class NodePlanataReserve extends DeciTreeReadTemplate<PlanataInfo> {
	
	public NodePlanataReserve(DeciTreeOption<PlanataInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PlanataInfo> buildDecisionCheckerHook(DeciTreeOption<PlanataInfo> option) {
		List<ModelChecker<PlanataInfo>> queue = new ArrayList<>();		
		ModelChecker<PlanataInfo> checker;
		
		checker = new PlanataCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PlanataInfo>> buildActionsOnPassedHook(DeciTreeOption<PlanataInfo> option) {
		List<ActionStd<PlanataInfo>> actions = new ArrayList<>();		
		
		ActionStd<PlanataInfo> pruneCarteve = new StdPlanataPruneCarterve(option);
		ActionLazy<PlanataInfo> pruneOrderve = new LazyPlanataPruneOrderve(option.conn, option.schemaName);
		
		pruneCarteve.addPostAction(pruneOrderve);
		
		actions.add(pruneCarteve);
		return actions;
	}
}
