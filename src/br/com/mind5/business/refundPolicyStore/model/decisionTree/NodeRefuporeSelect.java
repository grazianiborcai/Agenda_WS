package br.com.mind5.business.refundPolicyStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.action.LazyRefuporeMergeRefugroup;
import br.com.mind5.business.refundPolicyStore.model.action.StdRefuporeDaoSelect;
import br.com.mind5.business.refundPolicyStore.model.action.StdRefuporeMergeRefupown;
import br.com.mind5.business.refundPolicyStore.model.checker.RefuporeCheckExist;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class NodeRefuporeSelect extends DeciTreeTemplateReadV2<RefuporeInfo> {
	
	public NodeRefuporeSelect(DeciTreeOption<RefuporeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefuporeInfo> buildCheckerHook(DeciTreeOption<RefuporeInfo> option) {
		List<ModelCheckerV1<RefuporeInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefuporeInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefuporeCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefuporeInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuporeInfo> option) {
		List<ActionStdV1<RefuporeInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefuporeInfo> select = new StdRefuporeDaoSelect(option);
		ActionLazyV1<RefuporeInfo> mergeRefupown = new LazyRefuporeMergeRefugroup(option.conn, option.schemaName);
		
		select.addPostAction(mergeRefupown);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<RefuporeInfo>> buildActionsOnFailedHook(DeciTreeOption<RefuporeInfo> option) {
		List<ActionStdV1<RefuporeInfo>> actions = new ArrayList<>();
		
		ActionStdV1<RefuporeInfo> mergeRefupown = new StdRefuporeMergeRefupown(option);
		
		actions.add(mergeRefupown);
		return actions;
	}
}
