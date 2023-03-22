package br.com.mind5.payment.creditCard.model.decisionTree;

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
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiDaoInsert;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiDaoUpdate;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiEnforceUpperCase;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiNodeAddressL1;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiNodeCuspar;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiNodeInsertL1;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiNodePayPartnerL1;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiNodePhoneL1;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiRootSelect;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckExpiration;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckLangu;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckOwner;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckUsername;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckWrite;

public final class CrecardRootInsert extends DeciTreeTemplateWrite<CrecardInfo> {
	
	public CrecardRootInsert(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;	
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CrecardCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CrecardCheckExpiration(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CrecardCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CrecardCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CrecardCheckUsername(checkerOption);
		queue.add(checker);
		
		//TODO: Inserir limite ? Maximo de 10 cartoes ?
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();

		ActionStd<CrecardInfo>  nodeUser         = new CrecardNodeUser(option).toAction();
		ActionLazy<CrecardInfo> nodePayPartner   = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiNodePayPartnerL1.class);
		ActionLazy<CrecardInfo> nodeAddress      = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiNodeAddressL1.class);
		ActionLazy<CrecardInfo> nodePhone        = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiNodePhoneL1.class);		
		ActionLazy<CrecardInfo> nodeCuspar       = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiNodeCuspar.class);
		ActionLazy<CrecardInfo> enforceUpperCase = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiEnforceUpperCase.class);
		ActionLazy<CrecardInfo> insertCrecard    = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiDaoInsert.class);
		ActionLazy<CrecardInfo> nodeL1           = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiNodeInsertL1.class);
		ActionLazy<CrecardInfo> updateCrecard    = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiDaoUpdate.class);
		ActionLazy<CrecardInfo> select           = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiRootSelect.class);
		
		nodeUser.addPostAction(nodePayPartner);
		nodePayPartner.addPostAction(nodeAddress);
		nodeAddress.addPostAction(nodePhone);
		nodePhone.addPostAction(nodeCuspar);
		nodeCuspar.addPostAction(enforceUpperCase);
		enforceUpperCase.addPostAction(insertCrecard);
		insertCrecard.addPostAction(nodeL1);
		nodeL1.addPostAction(updateCrecard);
		updateCrecard.addPostAction(select);
		
		actions.add(nodeUser);
		return actions;
	}
}
