package br.com.mind5.business.refundPolicyStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.model.action.StdRefuporeDaoInsert;
import br.com.mind5.business.refundPolicyStore.model.action.StdRefuporeDaoUpdate;
import br.com.mind5.business.refundPolicyStore.model.checker.RefuporeCheckSoftDelete;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeRefuporeInsert extends DeciTreeTemplateWriteV2<RefuporeInfo> {
	
	public NodeRefuporeInsert(DeciTreeOption<RefuporeInfo> option) {
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
		checker = new RefuporeCheckSoftDelete(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefuporeInfo>> buildActionsOnPassedHook(DeciTreeOption<RefuporeInfo> option) {
		List<ActionStdV1<RefuporeInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<RefuporeInfo> update = new StdRefuporeDaoUpdate(option);	
		
		actions.add(update);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<RefuporeInfo>> buildActionsOnFailedHook(DeciTreeOption<RefuporeInfo> option) {
		List<ActionStdV1<RefuporeInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<RefuporeInfo> insert = new StdRefuporeDaoInsert(option);	
		
		actions.add(insert);
		return actions;
	}
}
