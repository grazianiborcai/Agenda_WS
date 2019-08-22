package br.com.gda.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.action.LazySchedineEnforceLChanged;
import br.com.gda.business.scheduleLine.model.action.LazySchedineEnforceStatus;
import br.com.gda.business.scheduleLine.model.action.LazySchedineNodeTime;
import br.com.gda.business.scheduleLine.model.action.StdSchedineMergeToUpdate;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeCuslis;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeMat;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeUsername;
import br.com.gda.business.scheduleLine.model.action.LazySchedineNodeMat;
import br.com.gda.business.scheduleLine.model.action.LazySchedineNodeOrderL1;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckUpdate;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSchedineUpdate extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public NodeSchedineUpdate(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		
		checker = new SchedineCheckUpdate();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> mergeToUpdate = new StdSchedineMergeToUpdate(option);
		ActionLazy<SchedineInfo> nodeOrder = new LazySchedineNodeOrderL1(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceLChanged = new LazySchedineEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeMat = new LazySchedineMergeMat(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> nodeMat = new LazySchedineNodeMat(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeCuslis = new LazySchedineMergeCuslis(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeUsername = new LazySchedineMergeUsername(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> nodeTime = new LazySchedineNodeTime(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceStatus = new LazySchedineEnforceStatus(option.conn, option.schemaName);
		
		mergeToUpdate.addPostAction(nodeOrder);
		nodeOrder.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeMat);
		mergeMat.addPostAction(nodeMat);
		nodeMat.addPostAction(mergeCuslis);		
		mergeCuslis.addPostAction(mergeUsername);
		mergeUsername.addPostAction(nodeTime);
		nodeTime.addPostAction(enforceStatus);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
