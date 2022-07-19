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
import br.com.mind5.payment.creditCard.model.action.CrecardVisiNodeAddress;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiNodeCuspar;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiNodeInsert;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiNodePhone;
import br.com.mind5.payment.creditCard.model.action.CrecardVisiRootSelect;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckAddress;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckExpiration;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckLangu;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckOwner;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckPhone;
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
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CrecardCheckAddress(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CrecardCheckPhone(checkerOption);
		queue.add(checker);
		//TODO: Inserir limite ? Maximo de 10 cartoes ?
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStd<CrecardInfo>> actions = new ArrayList<>();		

		ActionStd<CrecardInfo> nodeUser = new CrecardNodeUser(option).toAction();
		ActionLazy<CrecardInfo> nodeAddress = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiNodeAddress.class);
		ActionLazy<CrecardInfo> nodePhone = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiNodePhone.class);
		ActionLazy<CrecardInfo> nodeCuspar = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiNodeCuspar.class);
		ActionLazy<CrecardInfo> nodeInsert = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiNodeInsert.class);
		ActionLazy<CrecardInfo> select = new ActionLazyCommom<CrecardInfo>(option, CrecardVisiRootSelect.class);		
		
		nodeUser.addPostAction(nodeAddress);
		nodeAddress.addPostAction(nodePhone);
		nodePhone.addPostAction(nodeCuspar);
		nodeCuspar.addPostAction(nodeInsert);
		nodeInsert.addPostAction(select);
		
		actions.add(nodeUser);		
		return actions;
	}
}
