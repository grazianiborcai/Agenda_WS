package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.decisionTree;

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
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.CusmoipVisiNodeAddressL1;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.CusmoipVisiNodePhoneL1;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.CusmoipVisiNodeUserL1;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.CusmoipVisiCreate;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.CusmoipVisiEnforceRequest;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker.CusmoipCheckAddresnap;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker.CusmoipCheckPhonap;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker.CusmoipCheckWrite;

public final class CusmoipRootCreate extends DeciTreeTemplateWrite<CusmoipInfo> {
	
	public CusmoipRootCreate(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusmoipInfo> buildCheckerHook(DeciTreeOption<CusmoipInfo> option) {
		List<ModelChecker<CusmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CusmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusmoipCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CusmoipCheckAddresnap(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CusmoipCheckPhonap(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CusmoipInfo> option) {
		List<ActionStd<CusmoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CusmoipInfo> nodeSetupar = new CusmoipNodeSetuparL1(option).toAction();
		ActionLazy<CusmoipInfo> nodeAddress = new ActionLazyCommom<CusmoipInfo>(option, CusmoipVisiNodeAddressL1.class);
		ActionLazy<CusmoipInfo> nodePhone = new ActionLazyCommom<CusmoipInfo>(option, CusmoipVisiNodePhoneL1.class);
		ActionLazy<CusmoipInfo> nodeUser = new ActionLazyCommom<CusmoipInfo>(option, CusmoipVisiNodeUserL1.class);		
		ActionLazy<CusmoipInfo> enforcerequest = new ActionLazyCommom<CusmoipInfo>(option, CusmoipVisiEnforceRequest.class);
		ActionLazy<CusmoipInfo> create = new ActionLazyCommom<CusmoipInfo>(option, CusmoipVisiCreate.class);
		
		nodeSetupar.addPostAction(nodeAddress);
		nodeAddress.addPostAction(nodeUser);
		nodeUser.addPostAction(nodePhone);
		nodePhone.addPostAction(enforcerequest);
		enforcerequest.addPostAction(create);
		
		actions.add(nodeSetupar);
		return actions;
	}
}
