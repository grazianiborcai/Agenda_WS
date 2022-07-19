package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.CremoipVisiNodeAdd;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.CremoipVisiNodeAddressL1;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.CremoipVisiNodeCusparL1;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.CremoipVisiNodePhoneL1;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker.CremoipCheckAdd;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker.CremoipCheckAddresnap;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker.CremoipCheckBirthdate;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker.CremoipCheckCuspar;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker.CremoipCheckPhonap;

public final class CremoipRootAdd extends DeciTreeTemplateWrite<CremoipInfo> {
	
	public CremoipRootAdd(DeciTreeOption<CremoipInfo> option) {
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
		checker = new CremoipCheckAdd(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CremoipCheckBirthdate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CremoipCheckCuspar(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CremoipCheckPhonap(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CremoipCheckAddresnap(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CremoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CremoipInfo> option) {
		List<ActionStd<CremoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CremoipInfo> mergeSetupar = new CremoipNodeSetuparL1(option).toAction();
		ActionLazy<CremoipInfo> nodeAddress = new ActionLazyCommom<CremoipInfo>(option, CremoipVisiNodeAddressL1.class);
		ActionLazy<CremoipInfo> nodePhone = new ActionLazyCommom<CremoipInfo>(option, CremoipVisiNodePhoneL1.class);
		ActionLazy<CremoipInfo> nodeCuspar = new ActionLazyCommom<CremoipInfo>(option, CremoipVisiNodeCusparL1.class);		
		ActionLazy<CremoipInfo> nodeAdd = new ActionLazyCommom<CremoipInfo>(option, CremoipVisiNodeAdd.class);	
		
		mergeSetupar.addPostAction(nodeAddress);
		nodeAddress.addPostAction(nodePhone);
		nodePhone.addPostAction(nodeCuspar);
		nodeCuspar.addPostAction(nodeAdd);
		
		actions.add(mergeSetupar);
		return actions;
	}
}
