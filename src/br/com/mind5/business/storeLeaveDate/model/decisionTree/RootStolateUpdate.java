package br.com.mind5.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateEnforceLChanged;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateMergeUsername;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateRootSelect;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateUpdate;
import br.com.mind5.business.storeLeaveDate.model.action.StdStolateMergeToUpdate;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckExist;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckLangu;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckOwner;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckSchedage;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckStorauth;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckStore;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckTimeRange;
import br.com.mind5.business.storeLeaveDate.model.checker.StolateCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootStolateUpdate extends DeciTreeWriteTemplate<StolateInfo> {
	
	public RootStolateUpdate(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StolateInfo> buildDecisionCheckerHook(DeciTreeOption<StolateInfo> option) {
		List<ModelChecker<StolateInfo>> queue = new ArrayList<>();		
		ModelChecker<StolateInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StolateCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StolateCheckTimeRange(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolateCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolateCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolateCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolateCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StolateCheckStorauth(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
		checker = new StolateCheckSchedage(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolateInfo>> buildActionsOnPassedHook(DeciTreeOption<StolateInfo> option) {
		List<ActionStd<StolateInfo>> actions = new ArrayList<>();
		
		ActionStd<StolateInfo> mergeToUpdate = new StdStolateMergeToUpdate(option);
		ActionLazy<StolateInfo> enforceLChanged = new LazyStolateEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<StolateInfo> enforceLChangedBy = new LazyStolateMergeUsername(option.conn, option.schemaName);
		ActionLazy<StolateInfo> update = new LazyStolateUpdate(option.conn, option.schemaName);
		ActionLazy<StolateInfo> select = new LazyStolateRootSelect(option.conn, option.schemaName);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(update);
		update.addPostAction(select);
		
		actions.add(mergeToUpdate);				
		return actions;
	}
}
