package br.com.mind5.payment.storePartnerList.model.decisionTree;

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
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.model.action.StoplisVisiRootSelect;
import br.com.mind5.payment.storePartnerList.model.action.StoplisVisiMergeStoparch;

public final class StoplisRootSearch extends DeciTreeTemplateRead<StoplisInfo> {
	
	public StoplisRootSearch(DeciTreeOption<StoplisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoplisInfo> buildCheckerHook(DeciTreeOption<StoplisInfo> option) {
		List<ModelChecker<StoplisInfo>> queue = new ArrayList<>();		
		ModelChecker<StoplisInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoplisInfo>> buildActionsOnPassedHook(DeciTreeOption<StoplisInfo> option) {
		List<ActionStd<StoplisInfo>> actions = new ArrayList<>();
		
		ActionStd<StoplisInfo> mergeStoparch = new ActionStdCommom<StoplisInfo>(option, StoplisVisiMergeStoparch.class);
		ActionLazy<StoplisInfo> select = new ActionLazyCommom<StoplisInfo>(option, StoplisVisiRootSelect.class);
		
		mergeStoparch.addPostAction(select);
		
		actions.add(mergeStoparch);
		return actions;
	}
}
