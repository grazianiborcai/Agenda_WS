package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipCreate;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipEnforceRequest;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipNodeAddressL1;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipNodePhoneL1;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipNodeSetupar;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipNodeUserL1;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.StdCusmoipMergeSysEnviron;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker.CusmoipCheckAddress;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker.CusmoipCheckPhone;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker.CusmoipCheckUserData;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker.CusmoipCheckWrite;

public final class RootCusmoipCreate extends DeciTreeWriteTemplate<CusmoipInfo> {
	
	public RootCusmoipCreate(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusmoipInfo> buildDecisionCheckerHook(DeciTreeOption<CusmoipInfo> option) {
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
		checker = new CusmoipCheckUserData(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CusmoipCheckAddress(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CusmoipCheckPhone(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CusmoipInfo> option) {
		List<ActionStd<CusmoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CusmoipInfo> mergeSysEnviron = new StdCusmoipMergeSysEnviron(option);
		ActionLazy<CusmoipInfo> nodeSetupar = new LazyCusmoipNodeSetupar(option.conn, option.schemaName);
		ActionLazy<CusmoipInfo> nodeAddress = new LazyCusmoipNodeAddressL1(option.conn, option.schemaName);
		ActionLazy<CusmoipInfo> enforcePhone = new LazyCusmoipNodePhoneL1(option.conn, option.schemaName);
		ActionLazy<CusmoipInfo> nodeUser = new LazyCusmoipNodeUserL1(option.conn, option.schemaName);		
		ActionLazy<CusmoipInfo> enforcerequest = new LazyCusmoipEnforceRequest(option.conn, option.schemaName);
		ActionLazy<CusmoipInfo> create = new LazyCusmoipCreate(option.conn, option.schemaName);
		
		mergeSysEnviron.addPostAction(nodeSetupar);
		nodeSetupar.addPostAction(nodeAddress);
		nodeAddress.addPostAction(nodeUser);
		nodeUser.addPostAction(enforcePhone);
		enforcePhone.addPostAction(enforcerequest);
		enforcerequest.addPostAction(create);
		
		actions.add(mergeSysEnviron);
		return actions;
	}
}
