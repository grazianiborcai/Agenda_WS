package br.com.gda.business.storeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmInsert;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmMergeUsername;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmRootSelect;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmUpdate;
import br.com.gda.business.storeWorkTime.model.action.StdStowotmEnforceLChanged;
import br.com.gda.business.storeWorkTime.model.checker.StowotmCheckSoftDelete;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

final class NodeStowotmInsert extends DeciTreeWriteTemplate<StowotmInfo> {
	
	public NodeStowotmInsert(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StowotmInfo> buildDecisionCheckerHook(DeciTreeOption<StowotmInfo> option) {
		final boolean NOT_DELETED = false;	
		
		List<ModelChecker<StowotmInfo>> queue = new ArrayList<>();		
		ModelChecker<StowotmInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new StowotmCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StowotmInfo>> buildActionsOnPassedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStd<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotmInfo> enforceLChanged = new StdStowotmEnforceLChanged(option);
		ActionLazy<StowotmInfo> enforceLChangedBy = new LazyStowotmMergeUsername(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> insert = new LazyStowotmInsert(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> select = new LazyStowotmRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(enforceLChanged);				
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StowotmInfo>> buildActionsOnFailedHook(DeciTreeOption<StowotmInfo> option) {
		List<ActionStd<StowotmInfo>> actions = new ArrayList<>();
		
		ActionStd<StowotmInfo> enforceLChanged = new StdStowotmEnforceLChanged(option);
		ActionLazy<StowotmInfo> enforceLChangedBy = new LazyStowotmMergeUsername(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> update = new LazyStowotmUpdate(option.conn, option.schemaName);
		ActionLazy<StowotmInfo> select = new LazyStowotmRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(select);
		
		actions.add(enforceLChanged);				
		return actions;
	}
}
