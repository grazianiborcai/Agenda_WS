package br.com.mind5.business.customer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.action.LazyCusEnforcePersonKey;
import br.com.mind5.business.customer.model.action.LazyCusInsertPerson;
import br.com.mind5.business.customer.model.action.StdCusEnforceEntityCateg;
import br.com.mind5.business.customer.model.checker.CusCheckHasPerson;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCusInsertPerson extends DeciTreeWriteTemplate<CusInfo> {
	
	public NodeCusInsertPerson(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CusInfo> buildDecisionCheckerHook(DeciTreeOption<CusInfo> option) {
		final boolean HAS_PERSON = true;
		
		List<ModelChecker<CusInfo>> queue = new ArrayList<>();		
		ModelChecker<CusInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_PERSON;		
		checker = new CusCheckHasPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CusInfo>> buildActionsOnPassedHook(DeciTreeOption<CusInfo> option) {
		List<ActionStd<CusInfo>> actions = new ArrayList<>();
		
		ActionStd<CusInfo> enforceEntityCateg = new StdCusEnforceEntityCateg(option);
		ActionLazy<CusInfo> enforcePersonKey = new LazyCusEnforcePersonKey(option.conn, option.schemaName);
		ActionLazy<CusInfo> insertPerson = new LazyCusInsertPerson(option.conn, option.schemaName);		
		
		enforceEntityCateg.addPostAction(enforcePersonKey);
		enforcePersonKey.addPostAction(insertPerson);
		
		actions.add(enforceEntityCateg);	
		return actions;
	}
}
