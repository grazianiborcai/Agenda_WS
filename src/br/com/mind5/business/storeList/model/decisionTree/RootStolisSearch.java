package br.com.mind5.business.storeList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.action.LazyStolisRootSelect;
import br.com.mind5.business.storeList.model.action.StdStolisMergeSotarch;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;


public final class RootStolisSearch extends DeciTreeTemplateWriteV2<StolisInfo> {
	
	public RootStolisSearch(DeciTreeOption<StolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StolisInfo> buildCheckerHook(DeciTreeOption<StolisInfo> option) {
		List<ModelCheckerV1<StolisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StolisInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StolisInfo>> buildActionsOnPassedHook(DeciTreeOption<StolisInfo> option) {
		List<ActionStdV1<StolisInfo>> actions = new ArrayList<>();

		ActionStdV1<StolisInfo> mergeSotarch = new StdStolisMergeSotarch(option);
		ActionLazyV1<StolisInfo> select = new LazyStolisRootSelect(option.conn, option.schemaName);
		
		mergeSotarch.addPostAction(select);
		
		actions.add(mergeSotarch);
		return actions;
	}
}
