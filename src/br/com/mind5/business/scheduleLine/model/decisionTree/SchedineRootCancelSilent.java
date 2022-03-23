package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiNodeSnapshot;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiDaoDelete;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiEnforceCancelled;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiEnforceLChanged;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiInsertSchedovm;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiMergeUsername;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckCancel;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckExist;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckLangu;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedineRootCancelSilent extends DeciTreeTemplateWrite<SchedineInfo> {
	
	public SchedineRootCancelSilent(DeciTreeOption<SchedineInfo> option) {
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

		ActionStd<SchedineInfo> enforceLChanged = new ActionStdCommom<SchedineInfo>(option, SchedineVisiEnforceLChanged.class);
		ActionLazy<SchedineInfo> mergeUsername = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiMergeUsername.class);
		ActionLazy<SchedineInfo> enforceStatus = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiEnforceCancelled.class);
		ActionLazy<SchedineInfo> nodeSnapshot = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiNodeSnapshot.class);
		ActionLazy<SchedineInfo> insertSchedovm = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiInsertSchedovm.class);
		ActionLazy<SchedineInfo> delete = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiDaoDelete.class);
		
		enforceLChanged.addPostAction(mergeUsername);
		mergeUsername.addPostAction(enforceStatus);
		enforceStatus.addPostAction(nodeSnapshot);
		nodeSnapshot.addPostAction(insertSchedovm);
		insertSchedovm.addPostAction(delete);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
