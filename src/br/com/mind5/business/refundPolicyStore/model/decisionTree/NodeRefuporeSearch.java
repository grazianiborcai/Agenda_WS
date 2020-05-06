package br.com.mind5.business.refundPolicyStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.action.StdRefuporeMergeRefupown;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class NodeRefuporeSearch extends DeciTreeTemplateReadV2<RefuporeInfo> {
	
	public NodeRefuporeSearch(DeciTreeOption<RefuporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefuporeInfo> buildCheckerHook(DeciTreeOption<RefuporeInfo> option) {
		List<ModelCheckerV1<RefuporeInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefuporeInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefuporeInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuporeInfo> option) {
		List<ActionStdV1<RefuporeInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefuporeInfo> mergeRefupown = new StdRefuporeMergeRefupown(option);
		
		actions.add(mergeRefupown);
		return actions;
	}
}
