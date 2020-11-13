package br.com.mind5.business.storeProspect.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosRootSelect;
import br.com.mind5.business.storeProspect.model.action.StdStoprosMergeStoprarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class RootStoprosSearch extends DeciTreeTemplateRead<StoprosInfo> {
	
	public RootStoprosSearch(DeciTreeOption<StoprosInfo> option) {
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

		ActionStd<StoprosInfo> mergeStoprarch = new StdStoprosMergeStoprarch(option);
		ActionLazy<StoprosInfo> select = new LazyStoprosRootSelect(option.conn, option.schemaName);
		
		mergeStoprarch.addPostAction(select);
		
		actions.add(mergeStoprarch);
		return actions;
	}
}
