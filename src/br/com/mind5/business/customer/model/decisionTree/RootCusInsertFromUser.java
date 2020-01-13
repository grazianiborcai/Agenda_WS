package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusEnforceUserData;
import br.com.mind5.business.customer.model.action.LazyCusNodeInsert;
import br.com.mind5.business.customer.model.action.LazyCusNodeInsertPerson;
import br.com.mind5.business.customer.model.action.LazyCusNodeSnapshot;
import br.com.mind5.business.customer.model.action.LazyCusNodeUpsertAddress;
import br.com.mind5.business.customer.model.action.LazyCusNodeUpsertPhone;
import br.com.mind5.business.customer.model.action.LazyCusRootSelect;
import br.com.mind5.business.customer.model.action.StdCusMergeUser;
import br.com.mind5.business.customer.model.checker.CusCheckInsertFromUser;
import br.com.mind5.business.customer.model.checker.CusCheckLangu;
import br.com.mind5.business.customer.model.checker.CusCheckOwner;
import br.com.mind5.business.customer.model.checker.CusCheckUser;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCusInsertFromUser extends DeciTreeWriteTemplate<CusInfo> {

	public RootCusInsertFromUser(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildDecisionCheckerHook(DeciTreeOption<CusInfo> option) {		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;		
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusCheckInsertFromUser(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;		
		checker = new CusCheckUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();		
		
		ActionStd<CusInfo> mergeUser = new StdCusMergeUser(option);
		ActionLazy<CusInfo> insertCustomer = new LazyCusNodeInsert(option.conn, option.schemaName);
		ActionLazy<CusInfo> enforceUserData = new LazyCusEnforceUserData(option.conn, option.schemaName);		
		ActionLazy<CusInfo> insertPerson = new LazyCusNodeInsertPerson(option.conn, option.schemaName);
		ActionLazy<CusInfo> snapshot = new LazyCusNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<CusInfo> upsertAddress = new LazyCusNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<CusInfo> upsertPhone = new LazyCusNodeUpsertPhone(option.conn, option.schemaName);		
		ActionLazy<CusInfo> select = new LazyCusRootSelect(option.conn, option.schemaName);	
		
		mergeUser.addPostAction(insertCustomer);
		insertCustomer.addPostAction(enforceUserData);
		enforceUserData.addPostAction(insertPerson);
		insertPerson.addPostAction(snapshot);
		snapshot.addPostAction(upsertAddress);
		upsertAddress.addPostAction(upsertPhone);
		upsertPhone.addPostAction(select);
		
		actions.add(mergeUser);	
		return actions;
	}
}
