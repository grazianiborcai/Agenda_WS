package br.com.mind5.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.action.LazyCompRootInsert;
import br.com.mind5.business.company.model.action.StdCompEnforceCategOwner;
import br.com.mind5.business.company.model.checker.CompCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootCompInsertOwner extends DeciTreeWriteTemplate<CompInfo> {
	
	public RootCompInsertOwner(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CompInfo> buildDecisionCheckerHook(DeciTreeOption<CompInfo> option) {
		List<ModelChecker<CompInfo>> queue = new ArrayList<>();		
		ModelChecker<CompInfo> checker;		
		
		checker = new CompCheckDummy();
		queue.add(checker);
			
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CompInfo>> buildActionsOnPassedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStd<CompInfo>> actions = new ArrayList<>();
		
		ActionStd<CompInfo> enforceCategOwner = new StdCompEnforceCategOwner(option);
		ActionLazy<CompInfo> insert = new LazyCompRootInsert(option.conn, option.schemaName);
		
		enforceCategOwner.addPostAction(insert);
		
		actions.add(enforceCategOwner);
		return actions;
	}
}
