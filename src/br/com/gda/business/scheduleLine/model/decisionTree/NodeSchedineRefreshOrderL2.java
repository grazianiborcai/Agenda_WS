package br.com.gda.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeSchedarch;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeToSelect;
import br.com.gda.business.scheduleLine.model.action.LazySchedineRootUpdate;
import br.com.gda.business.scheduleLine.model.action.StdSchedineEnforceOrderKey;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckOrder;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSchedineRefreshOrderL2 extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public NodeSchedineRefreshOrderL2(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new SchedineCheckOrder(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> enforceOrderKey = new StdSchedineEnforceOrderKey(option);
		ActionLazy<SchedineInfo> mergeSchedarch = new LazySchedineMergeSchedarch(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeToSelect = new LazySchedineMergeToSelect(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> update = new LazySchedineRootUpdate(option.conn, option.schemaName);
		
		enforceOrderKey.addPostAction(mergeSchedarch);
		mergeSchedarch.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(update);
		
		actions.add(enforceOrderKey);
		return actions;
	}
}
