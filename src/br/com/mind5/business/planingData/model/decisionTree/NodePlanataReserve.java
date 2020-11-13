package br.com.mind5.business.planingData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.action.LazyPlanataPruneOrderve;
import br.com.mind5.business.planingData.model.action.LazyPlanataPruneSchederve;
import br.com.mind5.business.planingData.model.action.StdPlanataPruneCarterve;
import br.com.mind5.business.planingData.model.checker.PlanataCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public class NodePlanataReserve extends DeciTreeTemplateReadV2<PlanataInfo> {
	
	public NodePlanataReserve(DeciTreeOption<PlanataInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PlanataInfo> buildCheckerHook(DeciTreeOption<PlanataInfo> option) {
		List<ModelCheckerV1<PlanataInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PlanataInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new PlanataCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PlanataInfo>> buildActionsOnPassedHook(DeciTreeOption<PlanataInfo> option) {
		List<ActionStdV2<PlanataInfo>> actions = new ArrayList<>();		
		
		ActionStdV2<PlanataInfo> pruneCarteve = new StdPlanataPruneCarterve(option);
		ActionLazy<PlanataInfo> pruneOrderve = new LazyPlanataPruneOrderve(option.conn, option.schemaName);
		ActionLazy<PlanataInfo> pruneSchederve = new LazyPlanataPruneSchederve(option.conn, option.schemaName);
		
		pruneCarteve.addPostAction(pruneOrderve);
		pruneOrderve.addPostAction(pruneSchederve);
		
		actions.add(pruneCarteve);
		return actions;
	}
}
