package br.com.gda.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.action.LazyPersonRootInsert;
import br.com.gda.business.person.model.action.StdPersonEnforceCategOwner;
import br.com.gda.business.person.model.checker.PersonCheckDummy;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootPersonInsertOwner extends DeciTreeWriteTemplate<PersonInfo> {
	
	public RootPersonInsertOwner(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonInfo> buildDecisionCheckerHook(DeciTreeOption<PersonInfo> option) {
		List<ModelChecker<PersonInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonInfo> checker;	
		
		checker = new PersonCheckDummy();
		queue.add(checker);
			
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> enforceCategOwner = new StdPersonEnforceCategOwner(option);	
		ActionLazy<PersonInfo> insert = new LazyPersonRootInsert(option.conn, option.schemaName);
		
		enforceCategOwner.addPostAction(insert);
		
		actions.add(enforceCategOwner);
		return actions;
	}
}
