package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.checker.RefumoipCheckSysparch;

public final class NodeRefumoipRefundL2 extends DeciTreeTemplateWrite<RefumoipInfo> {
	
	public NodeRefumoipRefundL2(DeciTreeOption<RefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<RefumoipInfo> buildCheckerHook(DeciTreeOption<RefumoipInfo> option) {				
		List<ModelCheckerV1<RefumoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<RefumoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new RefumoipCheckSysparch(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	

	@Override protected List<ActionStdV1<RefumoipInfo>> buildActionsOnPassedHook(DeciTreeOption<RefumoipInfo> option) {
		List<ActionStdV1<RefumoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<RefumoipInfo> nodeSystem = new NodeRefumoipSystem(option).toAction();
		
		actions.add(nodeSystem);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<RefumoipInfo>> buildActionsOnFailedHook(DeciTreeOption<RefumoipInfo> option) {
		List<ActionStdV1<RefumoipInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<RefumoipInfo> nodeNonSystem = new NodeRefumoipNonSystem(option).toAction();
		
		actions.add(nodeNonSystem);		
		return actions;
	}
}
