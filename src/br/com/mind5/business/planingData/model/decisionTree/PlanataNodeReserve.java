package br.com.mind5.business.planingData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.business.planingData.model.action.PlanataVisiPruneCarterve;
import br.com.mind5.business.planingData.model.action.PlanataVisiPruneOrderve;
import br.com.mind5.business.planingData.model.action.PlanataVisiPruneSchederve;
import br.com.mind5.business.planingData.model.checker.PlanataCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public class PlanataNodeReserve extends DeciTreeTemplateRead<PlanataInfo> {
	
	public PlanataNodeReserve(DeciTreeOption<PlanataInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PlanataInfo> buildCheckerHook(DeciTreeOption<PlanataInfo> option) {
		List<ModelChecker<PlanataInfo>> queue = new ArrayList<>();		
		ModelChecker<PlanataInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new PlanataCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PlanataInfo>> buildActionsOnPassedHook(DeciTreeOption<PlanataInfo> option) {
		List<ActionStd<PlanataInfo>> actions = new ArrayList<>();		
		
		ActionStd<PlanataInfo> pruneCarteve = new ActionStdCommom<PlanataInfo>(option, PlanataVisiPruneCarterve.class);
		ActionLazy<PlanataInfo> pruneOrderve = new ActionLazyCommom<PlanataInfo>(option, PlanataVisiPruneOrderve.class);
		ActionLazy<PlanataInfo> pruneSchederve = new ActionLazyCommom<PlanataInfo>(option, PlanataVisiPruneSchederve.class);
		
		pruneCarteve.addPostAction(pruneOrderve);
		pruneOrderve.addPostAction(pruneSchederve);
		
		actions.add(pruneCarteve);
		return actions;
	}
}
