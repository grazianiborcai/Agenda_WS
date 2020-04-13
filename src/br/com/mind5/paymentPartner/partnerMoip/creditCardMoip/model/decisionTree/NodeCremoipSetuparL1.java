package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipNodeSetuparL2;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.StdCremoipEnforcePaypar;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker.CremoipCheckDummy;

public final class NodeCremoipSetuparL1 extends DeciTreeTemplateWriteV1<CremoipInfo> {
	
	public NodeCremoipSetuparL1(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CremoipInfo> buildCheckerHook(DeciTreeOption<CremoipInfo> option) {
		List<ModelCheckerV1<CremoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CremoipInfo> checker;	

		checker = new CremoipCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CremoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CremoipInfo> option) {
		List<ActionStdV1<CremoipInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CremoipInfo> enforcePaypar = new StdCremoipEnforcePaypar(option);
		ActionLazyV1<CremoipInfo> nodeL2 = new LazyCremoipNodeSetuparL2(option.conn, option.schemaName);
		
		enforcePaypar.addPostAction(nodeL2);
		
		actions.add(enforcePaypar);
		return actions;
	}
}
