package br.com.mind5.business.storeProspect.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.action.StoprosVisiMergeStoprarchCreated;
import br.com.mind5.business.storeProspect.model.action.StoprosVisiRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class StoprosRootSearchCreated extends DeciTreeTemplateRead<StoprosInfo> {
	
	public StoprosRootSearchCreated(DeciTreeOption<StoprosInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoprosInfo> buildCheckerHook(DeciTreeOption<StoprosInfo> option) {
		List<ModelChecker<StoprosInfo>> queue = new ArrayList<>();		
		ModelChecker<StoprosInfo> checker;
	
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoprosInfo>> buildActionsOnPassedHook(DeciTreeOption<StoprosInfo> option) {
		List<ActionStd<StoprosInfo>> actions = new ArrayList<>();

		ActionStd<StoprosInfo> mergeStoprarchCreated = new ActionStdCommom<StoprosInfo>(option, StoprosVisiMergeStoprarchCreated.class);
		ActionLazy<StoprosInfo> select = new ActionLazyCommom<StoprosInfo>(option, StoprosVisiRootSelect.class);
		
		mergeStoprarchCreated.addPostAction(select);
		
		actions.add(mergeStoprarchCreated);
		return actions;
	}
}
