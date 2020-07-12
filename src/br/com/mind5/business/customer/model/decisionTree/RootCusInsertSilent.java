package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusNodeInsertAddress;
import br.com.mind5.business.customer.model.action.LazyCusNodeInsertPerson;
import br.com.mind5.business.customer.model.action.LazyCusNodeInsertPhone;
import br.com.mind5.business.customer.model.action.LazyCusNodeSnapshot;
import br.com.mind5.business.customer.model.action.LazyCusRootSelect;
import br.com.mind5.business.customer.model.checker.CusCheckInsert;
import br.com.mind5.business.customer.model.checker.CusCheckLangu;
import br.com.mind5.business.customer.model.checker.CusCheckOwner;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootCusInsertSilent extends DeciTreeTemplateWriteV2<CusInfo> {

	public RootCusInsertSilent(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusInfo> buildCheckerHook(DeciTreeOption<CusInfo> option) {		
		List<ModelCheckerV1<CusInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusInfo> checker;		
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusCheckInsert(checkerOption);
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStdV1<CusInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CusInfo> insertCustomer = new NodeCusInsert(option).toAction();
		ActionLazyV1<CusInfo> insertPerson = new LazyCusNodeInsertPerson(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> snapshot = new LazyCusNodeSnapshot(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> insertAddress = new LazyCusNodeInsertAddress(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> insertPhone = new LazyCusNodeInsertPhone(option.conn, option.schemaName);
		ActionLazyV1<CusInfo> select = new LazyCusRootSelect(option.conn, option.schemaName);	
		
		insertCustomer.addPostAction(insertPerson);
		insertPerson.addPostAction(snapshot);
		snapshot.addPostAction(insertAddress);
		insertAddress.addPostAction(insertPhone);
		insertPhone.addPostAction(select);
		
		actions.add(insertCustomer);	
		return actions;
	}
}