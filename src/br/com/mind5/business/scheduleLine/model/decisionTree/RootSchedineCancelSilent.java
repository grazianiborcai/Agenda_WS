package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineDaoDelete;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceCancelled;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineInsertSchedovm;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeUsername;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineNodeSnapshot;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineEnforceLChanged;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckCancel;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckExist;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckLangu;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootSchedineCancelSilent extends DeciTreeTemplateWrite<SchedineInfo> {
	
	public RootSchedineCancelSilent(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		ModelCheckerOption checkerOption;

		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SchedineCheckCancel(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();

		ActionStd<SchedineInfo> enforceLChanged = new StdSchedineEnforceLChanged(option);
		ActionLazy<SchedineInfo> mergeUsername = new LazySchedineMergeUsername(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceStatus = new LazySchedineEnforceCancelled(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> nodeSnapshot = new LazySchedineNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> insertSchedovm = new LazySchedineInsertSchedovm(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> delete = new LazySchedineDaoDelete(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(mergeUsername);
		mergeUsername.addPostAction(enforceStatus);
		enforceStatus.addPostAction(nodeSnapshot);
		nodeSnapshot.addPostAction(insertSchedovm);
		insertSchedovm.addPostAction(delete);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
