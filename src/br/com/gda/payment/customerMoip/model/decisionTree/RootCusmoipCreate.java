package br.com.gda.payment.customerMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.payment.customerMoip.info.CusmoipInfo;
import br.com.gda.payment.customerMoip.model.action.LazyCusmoipCreate;
import br.com.gda.payment.customerMoip.model.action.LazyCusmoipEnforceAddress;
import br.com.gda.payment.customerMoip.model.action.LazyCusmoipEnforceDocument;
import br.com.gda.payment.customerMoip.model.action.LazyCusmoipEnforcePhone;
import br.com.gda.payment.customerMoip.model.action.LazyCusmoipEnforceRequest;
import br.com.gda.payment.customerMoip.model.action.StdCusmoipEnforceSetup;
import br.com.gda.payment.customerMoip.model.checker.CusmoipCheckAddresnapData;
import br.com.gda.payment.customerMoip.model.checker.CusmoipCheckPhonapData;
import br.com.gda.payment.customerMoip.model.checker.CusmoipCheckSetuparData;
import br.com.gda.payment.customerMoip.model.checker.CusmoipCheckUserapData;
import br.com.gda.payment.customerMoip.model.checker.CusmoipCheckWrite;

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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CusmoipInfo> option) {
		List<ActionStd<CusmoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CusmoipInfo> enforceSetup = new StdCusmoipEnforceSetup(option);
		ActionLazy<CusmoipInfo> enforceAddress = new LazyCusmoipEnforceAddress(option.conn, option.schemaName);
		ActionLazy<CusmoipInfo> enforceDocument = new LazyCusmoipEnforceDocument(option.conn, option.schemaName);
		ActionLazy<CusmoipInfo> enforcePhone = new LazyCusmoipEnforcePhone(option.conn, option.schemaName);
		ActionLazy<CusmoipInfo> enforcerequest = new LazyCusmoipEnforceRequest(option.conn, option.schemaName);
		ActionLazy<CusmoipInfo> create = new LazyCusmoipCreate(option.conn, option.schemaName);
		
		enforceSetup.addPostAction(enforceAddress);
		enforceAddress.addPostAction(enforceDocument);
		enforceDocument.addPostAction(enforcePhone);
		enforcePhone.addPostAction(enforcerequest);
		enforcerequest.addPostAction(create);
		
		actions.add(enforceSetup);
		return actions;
	}
}
