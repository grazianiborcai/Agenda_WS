package br.com.mind5.business.storeProspect.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.business.storeProspect.model.action.LazyStoprosRootSelect;
import br.com.mind5.business.storeProspect.model.action.StdStoprosMergeStoprarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;


public final class RootStoprosSearch extends DeciTreeTemplateReadV2<StoprosInfo> {
	
	public RootStoprosSearch(DeciTreeOption<StoprosInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoprosInfo> buildCheckerHook(DeciTreeOption<StoprosInfo> option) {
		List<ModelCheckerV1<StoprosInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoprosInfo> checker;
	
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoprosInfo>> buildActionsOnPassedHook(DeciTreeOption<StoprosInfo> option) {
		List<ActionStdV1<StoprosInfo>> actions = new ArrayList<>();

		ActionStdV1<StoprosInfo> mergeStoprarch = new StdStoprosMergeStoprarch(option);
		ActionLazy<StoprosInfo> select = new LazyStoprosRootSelect(option.conn, option.schemaName);
		
		mergeStoprarch.addPostAction(select);
		
		actions.add(mergeStoprarch);
		return actions;
	}
}
