package br.com.mind5.payment.storePartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.action.LazyStoparRootSelect;
import br.com.mind5.payment.storePartner.model.action.StdStoparMergeStoparch;
import br.com.mind5.payment.storePartner.model.checker.StoparCheckDummy;

public final class RootStoparSearch extends DeciTreeReadTemplate<StoparInfo> {
	
	public RootStoparSearch(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparInfo> buildDecisionCheckerHook(DeciTreeOption<StoparInfo> option) {
		List<ModelChecker<StoparInfo>> queue = new ArrayList<>();		
		ModelChecker<StoparInfo> checker;

		checker = new StoparCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoparInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStd<StoparInfo>> actions = new ArrayList<>();
		
		ActionStd<StoparInfo> mergeStoparch = new StdStoparMergeStoparch(option);
		ActionLazy<StoparInfo> select = new LazyStoparRootSelect(option.conn, option.schemaName);
		
		mergeStoparch.addPostAction(select);
		
		actions.add(mergeStoparch);
		return actions;
	}
}
