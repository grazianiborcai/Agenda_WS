package br.com.mind5.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiNodeUpsert;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiRootSelect;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiEnforceCreatedBy;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiEnforceCreatedOn;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiEnforceLChanged;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiEnforceMonth;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiEnforceValidFrom;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiEnforceValidTo;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiEnforceYear;
import br.com.mind5.business.storeLeaveDate.model.action.StolateVisiMergeUsername;
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
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StolateRootInsert extends DeciTreeTemplateWrite<StolateInfo> {
	
	public StolateRootInsert(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StolateInfo> buildCheckerHook(DeciTreeOption<StolateInfo> option) {
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StolateInfo>> buildActionsOnPassedHook(DeciTreeOption<StolateInfo> option) {
		List<ActionStd<StolateInfo>> actions = new ArrayList<>();	
		
		ActionStd<StolateInfo> enforceLChanged = new ActionStdCommom<StolateInfo>(option, StolateVisiEnforceLChanged.class);
		ActionLazy<StolateInfo> enforceLChangedBy = new ActionLazyCommom<StolateInfo>(option, StolateVisiMergeUsername.class);
		ActionLazy<StolateInfo> enforceCreatedOn = new ActionLazyCommom<StolateInfo>(option, StolateVisiEnforceCreatedOn.class);
		ActionLazy<StolateInfo> enforceCreatedBy = new ActionLazyCommom<StolateInfo>(option, StolateVisiEnforceCreatedBy.class);		
		ActionLazy<StolateInfo> enforceValidFrom = new ActionLazyCommom<StolateInfo>(option, StolateVisiEnforceValidFrom.class);
		ActionLazy<StolateInfo> enforceValidTo = new ActionLazyCommom<StolateInfo>(option, StolateVisiEnforceValidTo.class);		
		ActionLazy<StolateInfo> enforceYear = new ActionLazyCommom<StolateInfo>(option, StolateVisiEnforceYear.class);
		ActionLazy<StolateInfo> enforceMonth= new ActionLazyCommom<StolateInfo>(option, StolateVisiEnforceMonth.class);
		ActionLazy<StolateInfo> nodeUpsert = new ActionLazyCommom<StolateInfo>(option, StolateVisiNodeUpsert.class);
		ActionLazy<StolateInfo> select = new ActionLazyCommom<StolateInfo>(option, StolateVisiRootSelect.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);		
		enforceCreatedBy.addPostAction(enforceValidFrom);
		enforceValidFrom.addPostAction(enforceValidTo);
		enforceValidTo.addPostAction(enforceYear);
		enforceYear.addPostAction(enforceMonth);
		enforceMonth.addPostAction(nodeUpsert);
		nodeUpsert.addPostAction(select);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
