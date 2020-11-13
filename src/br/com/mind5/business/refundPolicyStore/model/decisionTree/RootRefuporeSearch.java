package br.com.mind5.business.refundPolicyStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.action.LazyRefuporeRootSelect;
import br.com.mind5.business.refundPolicyStore.model.action.StdRefuporeMergeRefuporarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootRefuporeSearch extends DeciTreeTemplateReadV2<RefuporeInfo> {
	
	public RootRefuporeSearch(DeciTreeOption<RefuporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefuporeInfo> buildCheckerHook(DeciTreeOption<RefuporeInfo> option) {
		List<ModelCheckerV1<RefuporeInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefuporeInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<RefuporeInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuporeInfo> option) {
		List<ActionStdV2<RefuporeInfo>> actions = new ArrayList<>();
		
		ActionStdV2<RefuporeInfo> mergeRefuporarch = new StdRefuporeMergeRefuporarch(option);
		ActionLazy<RefuporeInfo> select = new LazyRefuporeRootSelect(option.conn, option.schemaName);
		
		mergeRefuporarch.addPostAction(select);
		
		actions.add(mergeRefuporarch);
		return actions;
	}
}
