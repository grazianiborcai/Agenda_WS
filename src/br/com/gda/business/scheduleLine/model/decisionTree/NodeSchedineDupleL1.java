package br.com.gda.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeDuple;
import br.com.gda.business.scheduleLine.model.action.LazySchedineNodeDupleL2;
import br.com.gda.business.scheduleLine.model.action.StdSchedineEnforceDupleKey;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckDuple;
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
		ActionLazy<SchedineInfo> nodeDupleL2 = new LazySchedineNodeDupleL2(option.conn, option.schemaName);
		
		enforceDupleKey.addPostAction(mergeDuple);
		mergeDuple.addPostAction(nodeDupleL2);
		
		actions.add(enforceDupleKey);
		return actions;
	}
}
