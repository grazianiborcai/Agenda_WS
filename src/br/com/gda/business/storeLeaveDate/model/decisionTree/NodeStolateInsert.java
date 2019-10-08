package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateInsert;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateMergeUsername;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateRootSelect;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateUpdate;
import br.com.gda.business.storeLeaveDate.model.action.StdStolateEnforceLChanged;
import br.com.gda.business.storeLeaveDate.model.checker.StolateCheckSoftDelete;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

final class NodeStolateInsert extends DeciTreeWriteTemplate<StolateInfo> {
	
	public NodeStolateInsert(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StolateInfo> buildDecisionCheckerHook(DeciTreeOption<StolateInfo> option) {
		final boolean NOT_DELETED = false;	
		
		List<ModelChecker<StolateInfo>> queue = new ArrayList<>();		
		ModelChecker<StolateInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new StolateCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolateInfo>> buildActionsOnPassedHook(DeciTreeOption<StolateInfo> option) {
		List<ActionStd<StolateInfo>> actions = new ArrayList<>();
		
		ActionStd<StolateInfo> enforceLChanged = new StdStolateEnforceLChanged(option);
		ActionLazy<StolateInfo> enforceLChangedBy = new LazyStolateMergeUsername(option.conn, option.schemaName);
		ActionLazy<StolateInfo> insert = new LazyStolateInsert(option.conn, option.schemaName);
		ActionLazy<StolateInfo> select = new LazyStolateRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(enforceLChanged);				
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StolateInfo>> buildActionsOnFailedHook(DeciTreeOption<StolateInfo> option) {
		List<ActionStd<StolateInfo>> actions = new ArrayList<>();
		
		ActionStd<StolateInfo> enforceLChanged = new StdStolateEnforceLChanged(option);
		ActionLazy<StolateInfo> enforceLChangedBy = new LazyStolateMergeUsername(option.conn, option.schemaName);
		ActionLazy<StolateInfo> update = new LazyStolateUpdate(option.conn, option.schemaName);
		ActionLazy<StolateInfo> select = new LazyStolateRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(select);
		
		actions.add(enforceLChanged);				
		return actions;
	}
}
