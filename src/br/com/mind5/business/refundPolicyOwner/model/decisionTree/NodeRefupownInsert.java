package br.com.mind5.business.refundPolicyOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.action.StdRefupownDaoInsert;
import br.com.mind5.business.refundPolicyOwner.model.action.StdRefupownDaoUpdate;
import br.com.mind5.business.refundPolicyOwner.model.checker.RefupownCheckSoftDelete;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeRefupownInsert extends DeciTreeTemplateWriteV2<RefupownInfo> {
	
	public NodeRefupownInsert(DeciTreeOption<RefupownInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefupownInfo> buildCheckerHook(DeciTreeOption<RefupownInfo> option) {
		List<ModelCheckerV1<RefupownInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefupownInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new RefupownCheckSoftDelete(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefupownInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupownInfo> option) {
		List<ActionStdV1<RefupownInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<RefupownInfo> update = new StdRefupownDaoUpdate(option);	
		
		actions.add(update);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<RefupownInfo>> buildActionsOnFailedHook(DeciTreeOption<RefupownInfo> option) {
		List<ActionStdV1<RefupownInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<RefupownInfo> insert = new StdRefupownDaoInsert(option);	
		
		actions.add(insert);
		return actions;
	}
}