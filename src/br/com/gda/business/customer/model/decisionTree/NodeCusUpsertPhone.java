package br.com.gda.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.action.LazyCusUpsertPhone;
import br.com.gda.business.customer.model.action.StdCusEnforcePhoneKey;
import br.com.gda.business.customer.model.action.StdCusSuccess;
import br.com.gda.business.customer.model.checker.CusCheckHasPhone;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCusUpsertPhone extends DeciTreeWriteTemplate<CusInfo> {
	
	public NodeCusUpsertPhone(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildDecisionCheckerHook(DeciTreeOption<CusInfo> option) {
		final boolean HAS_ADDRESS = true;
		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_ADDRESS;		
		checker = new CusCheckHasPhone(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> enforcePhoneKey = new StdCusEnforcePhoneKey(option);
		ActionLazy<CusInfo> upsertPhone = new LazyCusUpsertPhone(option.conn, option.schemaName);	
		
		enforcePhoneKey.addPostAction(upsertPhone);
		
		actions.add(enforcePhoneKey);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnFailedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		actions.add(new StdCusSuccess(option));		
		return actions;
	}
}
