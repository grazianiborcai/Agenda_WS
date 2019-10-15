package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateEnforceCreatedBy;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateEnforceCreatedOn;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateEnforceMonth;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateEnforceYear;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateMergeUsername;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateNodeUpsert;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateRootSelect;
import br.com.gda.business.storeLeaveDate.model.action.StdStolateEnforceLChanged;
import br.com.gda.business.storeLeaveDate.model.checker.StolateCheckExist;
import br.com.gda.business.storeLeaveDate.model.checker.StolateCheckLangu;
import br.com.gda.business.storeLeaveDate.model.checker.StolateCheckOwner;
import br.com.gda.business.storeLeaveDate.model.checker.StolateCheckSchedage;
import br.com.gda.business.storeLeaveDate.model.checker.StolateCheckStorauth;
import br.com.gda.business.storeLeaveDate.model.checker.StolateCheckStore;
import br.com.gda.business.storeLeaveDate.model.checker.StolateCheckTimeRange;
import br.com.gda.business.storeLeaveDate.model.checker.StolateCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootStolateInsert extends DeciTreeWriteTemplate<StolateInfo> {
	
	public RootStolateInsert(DeciTreeOption<StolateInfo> option) {
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
		checkerOption.expectedResult = ModelCheckerOption.NOT_FOUND;		
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
		
		ActionStd<StolateInfo> enforceLChanged = new StdStolateEnforceLChanged(option);
		ActionLazy<StolateInfo> enforceLChangedBy = new LazyStolateMergeUsername(option.conn, option.schemaName);
		ActionLazy<StolateInfo> enforceCreatedOn = new LazyStolateEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<StolateInfo> enforceCreatedBy = new LazyStolateEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<StolateInfo> enforceYear = new LazyStolateEnforceYear(option.conn, option.schemaName);
		ActionLazy<StolateInfo> enforceMonth= new LazyStolateEnforceMonth(option.conn, option.schemaName);
		ActionLazy<StolateInfo> nodeUpsert = new LazyStolateNodeUpsert(option.conn, option.schemaName);
		ActionLazy<StolateInfo> select = new LazyStolateRootSelect(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);		
		enforceCreatedBy.addPostAction(enforceYear);
		enforceYear.addPostAction(enforceMonth);
		enforceMonth.addPostAction(nodeUpsert);
		nodeUpsert.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
