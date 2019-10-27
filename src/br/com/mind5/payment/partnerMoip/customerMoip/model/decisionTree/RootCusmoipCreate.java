package br.com.mind5.payment.partnerMoip.customerMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
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
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;			
		checker = new CusmoipCheckSetuparData(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusmoipCheckUserapData(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusmoipCheckPhonapData(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusmoipCheckAddresnapData(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusmoipCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusmoipCheckAddressBR(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusmoipCheckPhoneBR(checkerOption);
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
