package br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV1;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipCreate;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipEnforceRequest;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipNodeAddressL1;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipNodePhoneL1;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.action.LazyCusmoipNodeUserL1;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker.CusmoipCheckAddresnap;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker.CusmoipCheckPhonap;
import br.com.mind5.paymentPartner.partnerMoip.customerMoip.model.checker.CusmoipCheckWrite;

public final class RootCusmoipCreate extends DeciTreeTemplateWriteV1<CusmoipInfo> {
	
	public RootCusmoipCreate(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusmoipInfo> buildCheckerHook(DeciTreeOption<CusmoipInfo> option) {
		List<ModelCheckerV1<CusmoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusmoipInfo> checker;	
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CusmoipInfo> option) {
		List<ActionStdV1<CusmoipInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusmoipInfo> nodeSetupar = new NodeCusmoipSetuparL1(option).toAction();
		ActionLazyV1<CusmoipInfo> nodeAddress = new LazyCusmoipNodeAddressL1(option.conn, option.schemaName);
		ActionLazyV1<CusmoipInfo> nodePhone = new LazyCusmoipNodePhoneL1(option.conn, option.schemaName);
		ActionLazyV1<CusmoipInfo> nodeUser = new LazyCusmoipNodeUserL1(option.conn, option.schemaName);		
		ActionLazyV1<CusmoipInfo> enforcerequest = new LazyCusmoipEnforceRequest(option.conn, option.schemaName);
		ActionLazyV1<CusmoipInfo> create = new LazyCusmoipCreate(option.conn, option.schemaName);
		
		nodeSetupar.addPostAction(nodeAddress);
		nodeAddress.addPostAction(nodeUser);
		nodeUser.addPostAction(nodePhone);
		nodePhone.addPostAction(enforcerequest);
		enforcerequest.addPostAction(create);
		
		actions.add(nodeSetupar);
		return actions;
	}
}
