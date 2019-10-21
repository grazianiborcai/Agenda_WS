package br.com.mind5.business.planingData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.action.LazyPlanataPruneOrderve;
import br.com.mind5.business.planingData.model.action.StdPlanataPruneCarterve;
import br.com.mind5.business.planingData.model.checker.PlanataCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

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
