package br.com.mind5.payment.storePartner.model.decisionTree;

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
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.model.action.StoparVisiMergeStoparchStore;
import br.com.mind5.payment.storePartner.model.action.StoparVisiRootSelect;

public final class StoparRootSearchStore extends DeciTreeTemplateRead<StoparInfo> {
	
	public StoparRootSearchStore(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoparInfo> buildCheckerHook(DeciTreeOption<StoparInfo> option) {
		List<ModelChecker<StoparInfo>> queue = new ArrayList<>();		
		ModelChecker<StoparInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoparInfo>> buildActionsOnPassedHook(DeciTreeOption<StoparInfo> option) {
		List<ActionStd<StoparInfo>> actions = new ArrayList<>();
		
		ActionStd <StoparInfo> mergeStoparchStore = new ActionStdCommom <StoparInfo>(option, StoparVisiMergeStoparchStore.class);
		ActionLazy<StoparInfo> select             = new ActionLazyCommom<StoparInfo>(option, StoparVisiRootSelect.class);
		
		mergeStoparchStore.addPostAction(select);
		
		actions.add(mergeStoparchStore);
		return actions;
	}
}
