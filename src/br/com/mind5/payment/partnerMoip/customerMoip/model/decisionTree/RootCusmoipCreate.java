package br.com.mind5.payment.partnerMoip.customerMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.partnerMoip.customerMoip.info.CusmoipInfo;
import br.com.mind5.payment.partnerMoip.customerMoip.model.action.LazyCusmoipCreate;
import br.com.mind5.payment.partnerMoip.customerMoip.model.action.LazyCusmoipEnforceAddress;
import br.com.mind5.payment.partnerMoip.customerMoip.model.action.LazyCusmoipEnforceDocument;
import br.com.mind5.payment.partnerMoip.customerMoip.model.action.LazyCusmoipEnforcePhone;
import br.com.mind5.payment.partnerMoip.customerMoip.model.action.LazyCusmoipEnforceRequest;
import br.com.mind5.payment.partnerMoip.customerMoip.model.action.LazyCusmoipEnforceSetup;
import br.com.mind5.payment.partnerMoip.customerMoip.model.action.StdCusmoipMergeSysEnviron;
import br.com.mind5.payment.partnerMoip.customerMoip.model.checker.CusmoipCheckAddresnapData;
import br.com.mind5.payment.partnerMoip.customerMoip.model.checker.CusmoipCheckAddressBR;
import br.com.mind5.payment.partnerMoip.customerMoip.model.checker.CusmoipCheckPhonapData;
import br.com.mind5.payment.partnerMoip.customerMoip.model.checker.CusmoipCheckPhoneBR;
import br.com.mind5.payment.partnerMoip.customerMoip.model.checker.CusmoipCheckSetuparData;
import br.com.mind5.payment.partnerMoip.customerMoip.model.checker.CusmoipCheckUserapData;
import br.com.mind5.payment.partnerMoip.customerMoip.model.checker.CusmoipCheckWrite;

public final class RootCusmoipCreate extends DeciTreeWriteTemplate<CusmoipInfo> {
	
	public RootCusmoipCreate(DeciTreeOption<CusmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusmoipInfo> buildDecisionCheckerHook(DeciTreeOption<CusmoipInfo> option) {
		List<ModelChecker<CusmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CusmoipInfo> checker;	
		
		checker = new CusmoipCheckSetuparData();
		queue.add(checker);
		
		checker = new CusmoipCheckUserapData();
		queue.add(checker);
		
		checker = new CusmoipCheckPhonapData();
		queue.add(checker);
		
		checker = new CusmoipCheckAddresnapData();
		queue.add(checker);
		
		checker = new CusmoipCheckWrite();
		queue.add(checker);
		
		checker = new CusmoipCheckAddressBR();
		queue.add(checker);
		
		checker = new CusmoipCheckPhoneBR();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CusmoipInfo> option) {
		List<ActionStd<CusmoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CusmoipInfo> mergeSysEnviron = new StdCusmoipMergeSysEnviron(option);
		ActionLazy<CusmoipInfo> enforceSetup = new LazyCusmoipEnforceSetup(option.conn, option.schemaName);
		ActionLazy<CusmoipInfo> enforceAddress = new LazyCusmoipEnforceAddress(option.conn, option.schemaName);
		ActionLazy<CusmoipInfo> enforceDocument = new LazyCusmoipEnforceDocument(option.conn, option.schemaName);
		ActionLazy<CusmoipInfo> enforcePhone = new LazyCusmoipEnforcePhone(option.conn, option.schemaName);
		ActionLazy<CusmoipInfo> enforcerequest = new LazyCusmoipEnforceRequest(option.conn, option.schemaName);
		ActionLazy<CusmoipInfo> create = new LazyCusmoipCreate(option.conn, option.schemaName);
		
		mergeSysEnviron.addPostAction(enforceSetup);
		enforceSetup.addPostAction(enforceAddress);
		enforceAddress.addPostAction(enforceDocument);
		enforceDocument.addPostAction(enforcePhone);
		enforcePhone.addPostAction(enforcerequest);
		enforcerequest.addPostAction(create);
		
		actions.add(mergeSysEnviron);
		return actions;
	}
}
