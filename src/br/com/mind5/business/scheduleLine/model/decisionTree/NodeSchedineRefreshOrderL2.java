package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceStatus;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeOrdist;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeSchedarch;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeToSelect;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineNodeRefreshOrderL3;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineEnforceOrderKey;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckOrder;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSchedineRefreshOrderL2 extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public NodeSchedineRefreshOrderL2(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new SchedineCheckOrder(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> enforceOrderKey = new StdSchedineEnforceOrderKey(option);
		ActionLazy<SchedineInfo> mergeSchedarch = new LazySchedineMergeSchedarch(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeToSelect = new LazySchedineMergeToSelect(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeOrdist = new LazySchedineMergeOrdist(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceStatus = new LazySchedineEnforceStatus(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> nodeRefreshOrderL3 = new LazySchedineNodeRefreshOrderL3(option.conn, option.schemaName);
		
		enforceOrderKey.addPostAction(mergeSchedarch);
		mergeSchedarch.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(mergeOrdist);
		mergeOrdist.addPostAction(enforceStatus);
		enforceStatus.addPostAction(nodeRefreshOrderL3);
		
		actions.add(enforceOrderKey);
		return actions;
	}
}
