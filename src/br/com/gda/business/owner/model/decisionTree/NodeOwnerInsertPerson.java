package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.action.LazyOwnerEnforcePersonKey;
import br.com.gda.business.owner.model.action.LazyOwnerInsertPerson;
import br.com.gda.business.owner.model.action.StdOwnerEnforceEntityCateg;
import br.com.gda.business.owner.model.checker.OwnerCheckHasPerson;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeOwnerInsertPerson extends DeciTreeWriteTemplate<OwnerInfo> {
	
	public NodeOwnerInsertPerson(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerInfo> buildDecisionCheckerHook(DeciTreeOption<OwnerInfo> option) {
		final boolean HAS_PERSON = true;
		
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = HAS_PERSON;		
		checker = new OwnerCheckHasPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> enforceEntityCateg = new StdOwnerEnforceEntityCateg(option);
		ActionLazy<OwnerInfo> enforcePersonKey = new LazyOwnerEnforcePersonKey(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> insertPerson = new LazyOwnerInsertPerson(option.conn, option.schemaName);		
		
		enforceEntityCateg.addPostAction(enforcePersonKey);
		enforcePersonKey.addPostAction(insertPerson);
		
		actions.add(enforceEntityCateg);	
		return actions;
	}
}
