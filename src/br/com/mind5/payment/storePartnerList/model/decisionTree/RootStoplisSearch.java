package br.com.mind5.payment.storePartnerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.model.action.LazyStoplisRootSelect;
import br.com.mind5.payment.storePartnerList.model.action.StdStoplisMergeStoparch;

public final class RootStoplisSearch extends DeciTreeTemplateRead<StoplisInfo> {
	
	public RootStoplisSearch(DeciTreeOption<StoplisInfo> option) {
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
		
		ActionStd<StoplisInfo> mergeStoparch = new StdStoplisMergeStoparch(option);
		ActionLazy<StoplisInfo> select = new LazyStoplisRootSelect(option.conn, option.schemaName);
		
		mergeStoparch.addPostAction(select);
		
		actions.add(mergeStoparch);
		return actions;
	}
}
