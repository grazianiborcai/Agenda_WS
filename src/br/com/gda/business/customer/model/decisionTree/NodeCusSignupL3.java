package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.action.LazyCusMergeToUpdateUser;
import br.com.gda.business.customer.model.action.LazyCusRootUpdate;
import br.com.gda.business.customer.model.checker.CusCheckHasUser;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCusSignupL3 extends DeciTreeWriteTemplate<CusInfo> {
	
	public NodeCusSignupL3(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildDecisionCheckerHook(DeciTreeOption<CusInfo> option) {
		final boolean DONT_HAVE_USER = false;
		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_HAVE_USER;	
		checker = new CusCheckHasUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> insertUser = new NodeCusInsertUser(option).toAction();
		ActionLazy<CusInfo> mergeToUpdateUser = new LazyCusMergeToUpdateUser(option.conn, option.schemaName);
		ActionLazy<CusInfo> updateCustomer = new LazyCusRootUpdate(option.conn, option.schemaName);
		
		insertUser.addPostAction(mergeToUpdateUser);
		mergeToUpdateUser.addPostAction(updateCustomer);
		
		actions.add(insertUser);	
		return actions;
	}
}
