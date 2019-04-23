package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.action.LazyCusInsert;
import br.com.gda.business.customer.model.action.LazyCusMergeUsername;
import br.com.gda.business.customer.model.action.LazyCusNodeInsertPerson;
import br.com.gda.business.customer.model.action.LazyCusNodeUpsertAddress;
import br.com.gda.business.customer.model.action.LazyCusNodeUpsertPhone;
import br.com.gda.business.customer.model.action.LazyCusRootSelect;
import br.com.gda.business.customer.model.action.LazyCusUpdate;
import br.com.gda.business.customer.model.action.StdCusEnforceLChanged;
import br.com.gda.business.customer.model.checker.CusCheckTechField;
import br.com.gda.business.customer.model.checker.CusCheckOwner;
import br.com.gda.business.customer.model.checker.CusCheckLangu;
import br.com.gda.business.customer.model.checker.CusCheckNodeInsert;
import br.com.gda.business.customer.model.checker.CusCheckWriteAddress;
import br.com.gda.business.customer.model.checker.CusCheckWritePhone;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCusInsert extends DeciTreeWriteTemplate<CusInfo> {

	public NodeCusInsert(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildDecisionCheckerHook(DeciTreeOption<CusInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CusCheckNodeInsert();
		queue.add(checker);
		
		checker = new CusCheckTechField();
		queue.add(checker);
		
		checker = new CusCheckWritePhone();
		queue.add(checker);
		
		checker = new CusCheckWriteAddress();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CusCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CusCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();

		ActionStd<CusInfo> enforceLChanged = new StdCusEnforceLChanged(option);
		ActionLazy<CusInfo> mergeLChangedBy = new LazyCusMergeUsername(option.conn, option.schemaName);	
		ActionLazy<CusInfo> insertCustomer = new LazyCusInsert(option.conn, option.schemaName);
		ActionLazy<CusInfo> insertPerson = new LazyCusNodeInsertPerson(option.conn, option.schemaName);
		ActionLazy<CusInfo> updateCustomer = new LazyCusUpdate(option.conn, option.schemaName);
		ActionLazy<CusInfo> upsertAddress = new LazyCusNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<CusInfo> upsertPhone = new LazyCusNodeUpsertPhone(option.conn, option.schemaName);		
		ActionLazy<CusInfo> selectCustomer = new LazyCusRootSelect(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(mergeLChangedBy);
		mergeLChangedBy.addPostAction(insertCustomer);
		insertCustomer.addPostAction(insertPerson);
		insertPerson.addPostAction(updateCustomer);	
		updateCustomer.addPostAction(upsertAddress);		
		updateCustomer.addPostAction(upsertPhone);			
		updateCustomer.addPostAction(selectCustomer);
		
		actions.add(enforceLChanged);	
		return actions;
	}
}
