package br.com.gda.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.model.action.LazyCompRootInsert;
import br.com.gda.business.company.model.action.StdCompEnforceCategStore;
import br.com.gda.business.company.model.checker.CompCheckDummy;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootCompInsertStore extends DeciTreeWriteTemplate<CompInfo> {
	
	public RootCompInsertStore(DeciTreeOption<CompInfo> option) {
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
		
		ActionStd<CompInfo> enforceCategStore = new StdCompEnforceCategStore(option);
		ActionLazy<CompInfo> insert = new LazyCompRootInsert(option.conn, option.schemaName);
		
		enforceCategStore.addPostAction(insert);
		
		actions.add(enforceCategStore);
		return actions;
	}
}
