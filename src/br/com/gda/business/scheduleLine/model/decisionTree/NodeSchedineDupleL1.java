package br.com.gda.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.action.LazySchedineEnforceStatus;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeDuple;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeOrdist;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeSchedarch;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeToSelect;
import br.com.gda.business.scheduleLine.model.action.LazySchedineNodeRefreshOrderL3;
import br.com.gda.business.scheduleLine.model.action.StdSchedineEnforceDupleKey;
import br.com.gda.business.scheduleLine.model.action.StdSchedineEnforceOrderKey;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckDuple;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckIsCancelled;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSchedineDupleL1 extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public NodeSchedineDupleL1(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		
		checker = new SchedineCheckDuple();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> enforceDupleKey = new StdSchedineEnforceDupleKey(option);
		ActionLazy<SchedineInfo> mergeDuple = new LazySchedineMergeDuple(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeToSelect = new LazySchedineMergeToSelect(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeOrdist = new LazySchedineMergeOrdist(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceStatus = new LazySchedineEnforceStatus(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> nodeRefreshOrderL3 = new LazySchedineNodeRefreshOrderL3(option.conn, option.schemaName);
		
		enforceDupleKey.addPostAction(mergeDuple);
		mergeDuple.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(mergeOrdist);
		mergeOrdist.addPostAction(enforceStatus);
		enforceStatus.addPostAction(nodeRefreshOrderL3);
		
		actions.add(enforceDupleKey);
		return actions;
	}
}
