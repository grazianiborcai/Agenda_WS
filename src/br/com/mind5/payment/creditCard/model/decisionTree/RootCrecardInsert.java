package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeAddress;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeCuspar;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeInsert;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodePhone;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardRootSelect;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckAddress;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckExpiration;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckLangu;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckOwner;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckPhone;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckUsername;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckWrite;

public final class RootCrecardInsert extends DeciTreeTemplateWrite<CrecardInfo> {
	
	public RootCrecardInsert(DeciTreeOption<CrecardInfo> option) {
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

		ActionStd<CrecardInfo> nodeUser = new NodeCrecardUser(option).toAction();
		ActionLazy<CrecardInfo> nodeAddress = new LazyCrecardNodeAddress(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> nodePhone = new LazyCrecardNodePhone(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> nodeCuspar = new LazyCrecardNodeCuspar(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> nodeInsert = new LazyCrecardNodeInsert(option.conn, option.schemaName);
		ActionLazy<CrecardInfo> select = new LazyCrecardRootSelect(option.conn, option.schemaName);		
		
		nodeUser.addPostAction(nodeAddress);
		nodeAddress.addPostAction(nodePhone);
		nodePhone.addPostAction(nodeCuspar);
		nodeCuspar.addPostAction(nodeInsert);
		nodeInsert.addPostAction(select);
		
		actions.add(nodeUser);		
		return actions;
	}
}
