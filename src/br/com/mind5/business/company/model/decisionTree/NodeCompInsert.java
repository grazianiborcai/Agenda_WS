package br.com.mind5.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.action.LazyCompEnforceCreatedBy;
import br.com.mind5.business.company.model.action.LazyCompEnforceCreatedOn;
import br.com.mind5.business.company.model.action.LazyCompInsert;
import br.com.mind5.business.company.model.action.LazyCompMergeUsername;
import br.com.mind5.business.company.model.action.StdCompEnforceLChanged;
import br.com.mind5.business.company.model.checker.CompCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCompInsert extends DeciTreeWriteTemplate<CompInfo> {
	
	public NodeCompInsert(DeciTreeOption<CompInfo> option) {
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
		
		ActionStd<CompInfo> enforceLChanged = new StdCompEnforceLChanged(option);
		ActionLazy<CompInfo> enforceLChangedBy = new LazyCompMergeUsername(option.conn, option.schemaName);
		ActionLazy<CompInfo> enforceCreatedOn = new LazyCompEnforceCreatedOn(option.conn, option.schemaName);	
		ActionLazy<CompInfo> enforceCreatedBy = new LazyCompEnforceCreatedBy(option.conn, option.schemaName);	
		ActionLazy<CompInfo> insert = new LazyCompInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
