package br.com.mind5.masterData.refundPolicyGroup.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.model.action.LazyRefugroupRootSelect;
import br.com.mind5.masterData.refundPolicyGroup.model.action.StdRefugroupMergeRefugrarch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootRefugroupSearch extends DeciTreeTemplateReadV2<RefugroupInfo> {
	
	public RootRefugroupSearch(DeciTreeOption<RefugroupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefugroupInfo> buildCheckerHook(DeciTreeOption<RefugroupInfo> option) {
		List<ModelCheckerV1<RefugroupInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefugroupInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefugroupInfo>> buildActionsOnPassedHook(DeciTreeOption<RefugroupInfo> option) {
		List<ActionStdV1<RefugroupInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefugroupInfo> mergeRefugrarch = new StdRefugroupMergeRefugrarch(option);
		ActionLazyV1<RefugroupInfo> select = new LazyRefugroupRootSelect(option.conn, option.schemaName);
		
		mergeRefugrarch.addPostAction(select);
		
		actions.add(mergeRefugrarch);
		return actions;
	}
}
