package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineBookiceValidate;
import br.com.mind5.business.scheduleLine.model.action.LazySchedineRootInsertForce;
import br.com.mind5.business.scheduleLine.model.action.StdSchedineEnforceRef;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeSchedineMoveL2 extends DeciTreeTemplateWrite<SchedineInfo> {
	
	public NodeSchedineMoveL2(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedineInfo> buildCheckerHook(DeciTreeOption<SchedineInfo> option) {
		List<ModelChecker<SchedineInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedineInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedineInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedineInfo> option) {
		List<ActionStd<SchedineInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedineInfo> enforceRef = new StdSchedineEnforceRef(option);
		ActionLazy<SchedineInfo> bookiceValidate = new LazySchedineBookiceValidate(option.conn, option.schemaName);
		ActionLazy<SchedineInfo> insert = new LazySchedineRootInsertForce(option.conn, option.schemaName);
		
		enforceRef.addPostAction(bookiceValidate);
		bookiceValidate.addPostAction(insert);
		
		actions.add(enforceRef);
		return actions;
	}
}
