package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action.SowusVisiMergeStolis;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action.SowusVisiNodeUpsertL2;


public final class SowusNodeUpsertL1 extends DeciTreeTemplateWrite<SowusInfo> {
	
	public SowusNodeUpsertL1(DeciTreeOption<SowusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowusInfo> buildCheckerHook(DeciTreeOption<SowusInfo> option) {
		List<ModelChecker<SowusInfo>> queue = new ArrayList<>();
		ModelChecker<SowusInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowusInfo>> buildActionsOnPassedHook(DeciTreeOption<SowusInfo> option) {
		List<ActionStd<SowusInfo>> actions = new ArrayList<>();

		ActionStd<SowusInfo> mergeStolis = new ActionStdCommom<SowusInfo>(option, SowusVisiMergeStolis.class);
		ActionLazy<SowusInfo> nodeL1 = new ActionLazyCommom<SowusInfo>(option, SowusVisiNodeUpsertL2.class);
		
		mergeStolis.addPostAction(nodeL1);
		
		actions.add(mergeStolis);
		return actions;
	}
}
