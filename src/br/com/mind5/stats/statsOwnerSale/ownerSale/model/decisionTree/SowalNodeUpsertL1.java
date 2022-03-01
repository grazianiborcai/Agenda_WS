package br.com.mind5.stats.statsOwnerSale.ownerSale.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.action.SowalVisiMergeStolis;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.action.SowalVisiNodeUpsertL2;


public final class SowalNodeUpsertL1 extends DeciTreeTemplateWrite<SowalInfo> {
	
	public SowalNodeUpsertL1(DeciTreeOption<SowalInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowalInfo> buildCheckerHook(DeciTreeOption<SowalInfo> option) {
		List<ModelChecker<SowalInfo>> queue = new ArrayList<>();
		ModelChecker<SowalInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowalInfo>> buildActionsOnPassedHook(DeciTreeOption<SowalInfo> option) {
		List<ActionStd<SowalInfo>> actions = new ArrayList<>();

		ActionStd<SowalInfo> mergeStolis = new ActionStdCommom<SowalInfo>(option, SowalVisiMergeStolis.class);
		ActionLazy<SowalInfo> nodeL2 = new ActionLazyCommom<SowalInfo>(option.conn, option.schemaName, SowalVisiNodeUpsertL2.class);
		
		mergeStolis.addPostAction(nodeL2);
		
		actions.add(mergeStolis);
		return actions;
	}
}
