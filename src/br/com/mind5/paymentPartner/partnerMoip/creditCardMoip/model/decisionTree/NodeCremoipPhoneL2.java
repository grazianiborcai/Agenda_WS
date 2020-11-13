package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.StdCremoipEnforcePhone;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker.CremoipCheckPhoneBR;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker.CremoipCheckPhoneData;

public final class NodeCremoipPhoneL2 extends DeciTreeTemplateWrite<CremoipInfo> {
	
	public NodeCremoipPhoneL2(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CremoipInfo> buildCheckerHook(DeciTreeOption<CremoipInfo> option) {
		List<ModelChecker<CremoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CremoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CremoipCheckPhoneBR(checkerOption);
		queue.add(checker);

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CremoipCheckPhoneData(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CremoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CremoipInfo> option) {
		List<ActionStd<CremoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CremoipInfo> enforcePhone = new StdCremoipEnforcePhone(option);
		
		actions.add(enforcePhone);
		return actions;
	}
}
