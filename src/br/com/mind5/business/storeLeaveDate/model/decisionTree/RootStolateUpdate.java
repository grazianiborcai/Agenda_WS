package br.com.mind5.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateEnforceLChanged;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateEnforceValidFrom;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateEnforceValidTo;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateMergeUsername;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateRootSelect;
import br.com.mind5.business.storeLeaveDate.model.action.LazyStolateDaoUpdate;
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
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootStolateUpdate extends DeciTreeTemplateWriteV2<StolateInfo> {
	
	public RootStolateUpdate(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StolateInfo> buildCheckerHook(DeciTreeOption<StolateInfo> option) {
		List<ModelCheckerV1<StolateInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StolateInfo> checker;
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StolateInfo>> buildActionsOnPassedHook(DeciTreeOption<StolateInfo> option) {
		List<ActionStdV1<StolateInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StolateInfo> mergeToUpdate = new StdStolateMergeToUpdate(option);
		ActionLazy<StolateInfo> enforceLChanged = new LazyStolateEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<StolateInfo> enforceLChangedBy = new LazyStolateMergeUsername(option.conn, option.schemaName);
		ActionLazy<StolateInfo> enforceValidFrom = new LazyStolateEnforceValidFrom(option.conn, option.schemaName);
		ActionLazy<StolateInfo> enforceValidTo = new LazyStolateEnforceValidTo(option.conn, option.schemaName);	
		ActionLazy<StolateInfo> update = new LazyStolateDaoUpdate(option.conn, option.schemaName);
		ActionLazy<StolateInfo> select = new LazyStolateRootSelect(option.conn, option.schemaName);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceValidFrom);
		enforceValidFrom.addPostAction(enforceValidTo);
		enforceValidTo.addPostAction(update);
		update.addPostAction(select);
		
		actions.add(mergeToUpdate);				
		return actions;
	}
}
