package br.com.mind5.business.refundPolicyStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.action.LazyRefuporeRootSelect;
import br.com.mind5.business.refundPolicyStore.model.action.StdRefuporeMergeRefuporarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootRefuporeSearch extends DeciTreeTemplateRead<RefuporeInfo> {
	
	public RootRefuporeSearch(DeciTreeOption<RefuporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<RefuporeInfo> buildCheckerHook(DeciTreeOption<RefuporeInfo> option) {
		List<ModelChecker<RefuporeInfo>> queue = new ArrayList<>();		
		ModelChecker<RefuporeInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<RefuporeInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuporeInfo> option) {
		List<ActionStd<RefuporeInfo>> actions = new ArrayList<>();
		
		ActionStd<RefuporeInfo> mergeRefuporarch = new StdRefuporeMergeRefuporarch(option);
		ActionLazy<RefuporeInfo> select = new LazyRefuporeRootSelect(option.conn, option.schemaName);
		
		mergeRefuporarch.addPostAction(select);
		
		actions.add(mergeRefuporarch);
		return actions;
	}
}
