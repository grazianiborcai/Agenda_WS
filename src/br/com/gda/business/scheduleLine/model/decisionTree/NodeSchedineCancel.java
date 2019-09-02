package br.com.gda.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.action.LazySchedineDelete;
import br.com.gda.business.scheduleLine.model.action.LazySchedineEnforceCancelled;
import br.com.gda.business.scheduleLine.model.action.LazySchedineEnforceLChanged;
import br.com.gda.business.scheduleLine.model.action.StdSchedineMergeToSelect;
import br.com.gda.business.scheduleLine.model.action.LazySchedineMergeUsername;
import br.com.gda.business.scheduleLine.model.action.LazySchedineNodeSnapshot;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckCancel;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeSchedineCancel extends DeciTreeWriteTemplate<SchedineInfo> {
	
	public NodeSchedineCancel(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildDecisionCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		
		checker = new SchedineCheckCancel();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		//TODO: send email ?
		ActionStd<SchedineInfo> mergeToSelect = new StdSchedineMergeToSelect(option);
		ActionLazy<SchedineInfo> enforceLChanged = new LazySchedineEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> mergeUsername = new LazySchedineMergeUsername(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> enforceStatus = new LazySchedineEnforceCancelled(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> nodeSnapshot = new LazySchedineNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> delete = new LazySchedineDelete(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeUsername);
		mergeUsername.addPostAction(enforceStatus);
		enforceStatus.addPostAction(nodeSnapshot);
		nodeSnapshot.addPostAction(delete);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
