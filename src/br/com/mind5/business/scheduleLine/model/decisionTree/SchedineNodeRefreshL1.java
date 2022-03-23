package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiNodeRefreshL2;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiEnforceStatus;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiMergeOrdemist;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiMergeSchedarch;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiMergeToSelect;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckSchedarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedineNodeRefreshL1 extends DeciTreeTemplateWrite<SchedineInfo> {
	
	public SchedineNodeRefreshL1(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckSchedarch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> mergeSchedarch = new ActionStdCommom<SchedineInfo>(option, SchedineVisiMergeSchedarch.class);
		ActionLazy<SchedineInfo> mergeToSelect = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiMergeToSelect.class);
		ActionLazy<SchedineInfo> mergeOrdemist = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiMergeOrdemist.class);
		ActionLazy<SchedineInfo> enforceStatus = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiEnforceStatus.class);
		ActionLazy<SchedineInfo> nodeL2 = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiNodeRefreshL2.class);
		
		mergeSchedarch.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(mergeOrdemist);
		mergeOrdemist.addPostAction(enforceStatus);
		enforceStatus.addPostAction(nodeL2);
		
		actions.add(mergeSchedarch);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnFailedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> success = new ActionStdSuccessCommom<SchedineInfo>(option);
		
		actions.add(success);
		return actions;
	}
}
