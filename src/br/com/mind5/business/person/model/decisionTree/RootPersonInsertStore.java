package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.LazyPersonRootInsert;
import br.com.mind5.business.person.model.action.StdPersonEnforceCategStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootPersonInsertStore extends DeciTreeTemplateWrite<PersonInfo> {
	
	public RootPersonInsertStore(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonInfo> buildCheckerHook(DeciTreeOption<PersonInfo> option) {
		List<ModelChecker<PersonInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
			
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> enforceCateg = new StdPersonEnforceCategStore(option);	
		ActionLazy<PersonInfo> insert = new LazyPersonRootInsert(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(insert);
		
		actions.add(enforceCateg);
		return actions;
	}
}
