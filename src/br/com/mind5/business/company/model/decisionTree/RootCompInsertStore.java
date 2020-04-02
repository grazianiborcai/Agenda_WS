package br.com.mind5.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.action.LazyCompRootInsert;
import br.com.mind5.business.company.model.action.StdCompEnforceCategStore;
import br.com.mind5.business.company.model.checker.CompCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

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
	
	
	
	@Override protected List<ActionStdV1<CompInfo>> buildActionsOnPassedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStdV1<CompInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CompInfo> enforceCategStore = new StdCompEnforceCategStore(option);
		ActionLazyV1<CompInfo> insert = new LazyCompRootInsert(option.conn, option.schemaName);
		
		enforceCategStore.addPostAction(insert);
		
		actions.add(enforceCategStore);
		return actions;
	}
}
