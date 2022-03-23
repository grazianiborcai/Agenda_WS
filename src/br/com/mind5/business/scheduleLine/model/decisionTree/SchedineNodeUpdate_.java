package br.com.mind5.business.scheduleLine.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiEnforceLChanged;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiEnforceStatus;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiMergeCalate;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiMergeCuslis;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiMergeToUpdate;
import br.com.mind5.business.scheduleLine.model.action.SchedineVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class SchedineNodeUpdate_ extends DeciTreeTemplateWrite<SchedineInfo> {
	
	public SchedineNodeUpdate_(DeciTreeOption<SchedineInfo> option) {
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
		
		ActionStd<SchedineInfo> mergeToUpdate = new ActionStdCommom<SchedineInfo>(option, SchedineVisiMergeToUpdate.class);
		ActionLazy<SchedineInfo> enforceLChanged = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiEnforceLChanged.class);
		ActionLazy<SchedineInfo> mergeCuslis = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiMergeCuslis.class);
		ActionLazy<SchedineInfo> mergeUsername = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiMergeUsername.class);
		ActionLazy<SchedineInfo> mergeCalate = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiMergeCalate.class);
		ActionLazy<SchedineInfo> enforceStatus = new ActionLazyCommom<SchedineInfo>(option, SchedineVisiEnforceStatus.class);
		
		mergeToUpdate.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeCuslis);		
		mergeCuslis.addPostAction(mergeUsername);
		mergeUsername.addPostAction(mergeCalate);
		mergeCalate.addPostAction(enforceStatus);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
