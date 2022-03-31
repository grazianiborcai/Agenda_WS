package br.com.mind5.business.scheduleDay.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDay.model.action.SchedayVisiRootSelect;
import br.com.mind5.business.scheduleDay.model.action.SchedayVisiMergeNow;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedayRootSelectNow extends DeciTreeTemplateWrite<SchedayInfo> {
	
	public SchedayRootSelectNow(DeciTreeOption<SchedayInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SchedayInfo> buildCheckerHook(DeciTreeOption<SchedayInfo> option) {
		List<ModelChecker<SchedayInfo>> queue = new ArrayList<>();		
		ModelChecker<SchedayInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SchedayInfo>> buildActionsOnPassedHook(DeciTreeOption<SchedayInfo> option) {
		List<ActionStd<SchedayInfo>> actions = new ArrayList<>();
		
		ActionStd<SchedayInfo> mergeNow = new ActionStdCommom<SchedayInfo>(option, SchedayVisiMergeNow.class);
		ActionLazy<SchedayInfo> select = new ActionLazyCommom<SchedayInfo>(option, SchedayVisiRootSelect.class);
		
		mergeNow.addPostAction(select);
		
		actions.add(mergeNow);
		return actions;
	}
}
