package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipNodeCusparL2;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.StdCremoipMergeCuspar;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker.CremoipCheckDummy;

public final class NodeCremoipCusparL1 extends DeciTreeWriteTemplate<CremoipInfo> {
	
	public NodeCremoipCusparL1(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CremoipInfo> buildDecisionCheckerHook(DeciTreeOption<CremoipInfo> option) {
		List<ModelChecker<CremoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CremoipInfo> checker;	

		checker = new CremoipCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CremoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CremoipInfo> option) {
		List<ActionStd<CremoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CremoipInfo> mergeCuspar = new StdCremoipMergeCuspar(option);
		ActionLazy<CremoipInfo> nodeL2 = new LazyCremoipNodeCusparL2(option.conn, option.schemaName);
		
		mergeCuspar.addPostAction(nodeL2);
		
		actions.add(mergeCuspar);
		return actions;
	}
}
