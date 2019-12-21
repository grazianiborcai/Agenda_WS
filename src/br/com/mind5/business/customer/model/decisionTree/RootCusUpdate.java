package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusNodeSnapshot;
import br.com.mind5.business.customer.model.action.LazyCusNodeUpdatePerson;
import br.com.mind5.business.customer.model.action.LazyCusNodeUpsertAddress;
import br.com.mind5.business.customer.model.action.LazyCusNodeUpsertPhone;
import br.com.mind5.business.customer.model.checker.CusCheckExist;
import br.com.mind5.business.customer.model.checker.CusCheckLangu;
import br.com.mind5.business.customer.model.checker.CusCheckOwner;
import br.com.mind5.business.customer.model.checker.CusCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCusUpdate extends DeciTreeWriteTemplate<CusInfo> {
	
	public RootCusUpdate(DeciTreeOption<CusInfo> option) {
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
		checker = new CusCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult =  ModelCheckerOption.EXIST_ON_DB;		
		checker = new CusCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();

		ActionStd<CusInfo> updateCustomer = new NodeCusUpdate(option).toAction();	
		ActionLazy<CusInfo> updatePerson = new LazyCusNodeUpdatePerson(option.conn, option.schemaName);		
		ActionLazy<CusInfo> snapshot = new LazyCusNodeSnapshot(option.conn, option.schemaName);	
		ActionLazy<CusInfo> upsertAddress = new LazyCusNodeUpsertAddress(option.conn, option.schemaName);	
		ActionLazy<CusInfo> upsertPhone = new LazyCusNodeUpsertPhone(option.conn, option.schemaName);		
		ActionStd<CusInfo> select = new RootCusSelect(option).toAction();	
		
		updateCustomer.addPostAction(updatePerson);	
		updatePerson.addPostAction(snapshot);
		snapshot.addPostAction(upsertAddress);
		snapshot.addPostAction(upsertPhone);
		
		actions.add(updateCustomer);
		actions.add(select);	
		return actions;
	}
}
