package br.com.mind5.business.refundPolicyOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.checker.RefupownCheckRefupowarch;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class NodeRefupownInsertL1 extends DeciTreeTemplateWriteV2<RefupownInfo> {
	
	public NodeRefupownInsertL1(DeciTreeOption<RefupownInfo> option) {
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
		checker = new RefupownCheckRefupowarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<RefupownInfo>> buildActionsOnPassedHook(DeciTreeOption<RefupownInfo> option) {
		List<ActionStdV1<RefupownInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<RefupownInfo> replace = new NodeRefupownReplace(option).toAction();	
		
		actions.add(replace);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<RefupownInfo>> buildActionsOnFailedHook(DeciTreeOption<RefupownInfo> option) {
		List<ActionStdV1<RefupownInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<RefupownInfo> nodeL2 = new NodeRefupownInsertL2(option).toAction();	
		
		actions.add(nodeL2);
		return actions;
	}
}
