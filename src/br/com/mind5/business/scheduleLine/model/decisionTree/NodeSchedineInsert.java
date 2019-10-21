package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceCreatedBy;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceCreatedOn;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineEnforceStatus;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineInsert;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeCuslis;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeMat;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineMergeUsername;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineNodeMat;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineNodeTime;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineEnforceLChanged;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckInsert;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSchedineInsert extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public NodeSchedineInsert(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		
		checker = new SchedineCheckInsert();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> enforceLChanged = new StdSchedineEnforceLChanged(option);
		ActionLazy<SchedineInfo> mergeMat = new LazySchedineMergeMat(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> nodeMat = new LazySchedineNodeMat(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeCuslis = new LazySchedineMergeCuslis(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeUsername = new LazySchedineMergeUsername(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> nodeTime = new LazySchedineNodeTime(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceCreatedOn = new LazySchedineEnforceCreatedOn(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceCreatedBy = new LazySchedineEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceStatus = new LazySchedineEnforceStatus(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> insert = new LazySchedineInsert(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(mergeMat);
		mergeMat.addPostAction(nodeMat);
		nodeMat.addPostAction(mergeCuslis);		
		mergeCuslis.addPostAction(mergeUsername);
		mergeUsername.addPostAction(nodeTime);
		nodeTime.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceStatus);
		enforceStatus.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
