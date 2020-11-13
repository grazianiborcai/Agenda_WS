package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipNodeSetuparL2;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.StdCremoipEnforcePaypar;

public final class NodeCremoipSetuparL1 extends DeciTreeTemplateWriteV2<CremoipInfo> {
	
	public NodeCremoipSetuparL1(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CremoipInfo> buildCheckerHook(DeciTreeOption<CremoipInfo> option) {
		List<ModelCheckerV1<CremoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CremoipInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CremoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CremoipInfo> option) {
		List<ActionStdV1<CremoipInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CremoipInfo> enforcePaypar = new StdCremoipEnforcePaypar(option);
		ActionLazy<CremoipInfo> nodeL2 = new LazyCremoipNodeSetuparL2(option.conn, option.schemaName);
		
		enforcePaypar.addPostAction(nodeL2);
		
		actions.add(enforcePaypar);
		return actions;
	}
}
