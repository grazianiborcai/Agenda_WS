package br.com.mind5.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.action.LazyCompDaoInsert;
import br.com.mind5.business.company.model.action.LazyCompEnforceCreatedBy;
import br.com.mind5.business.company.model.action.LazyCompEnforceCreatedOn;
import br.com.mind5.business.company.model.action.LazyCompEnforceNameSearch;
import br.com.mind5.business.company.model.action.LazyCompMergeUsername;
import br.com.mind5.business.company.model.action.StdCompEnforceLChanged;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeCompInsert extends DeciTreeTemplateWrite<CompInfo> {
	
	public NodeCompInsert(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CompInfo> buildCheckerHook(DeciTreeOption<CompInfo> option) {
		List<ModelChecker<CompInfo>> queue = new ArrayList<>();		
		ModelChecker<CompInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
			
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CompInfo>> buildActionsOnPassedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStd<CompInfo>> actions = new ArrayList<>();
		
		ActionStd<CompInfo> enforceLChanged = new StdCompEnforceLChanged(option);
		ActionLazy<CompInfo> enforceLChangedBy = new LazyCompMergeUsername(option.conn, option.schemaName);
		ActionLazy<CompInfo> enforceCreatedOn = new LazyCompEnforceCreatedOn(option.conn, option.schemaName);	
		ActionLazy<CompInfo> enforceCreatedBy = new LazyCompEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<CompInfo> enforceNameSearch = new LazyCompEnforceNameSearch(option.conn, option.schemaName);
		ActionLazy<CompInfo> insert = new LazyCompDaoInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceNameSearch);
		enforceNameSearch.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
