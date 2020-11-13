package br.com.mind5.business.ownerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.action.LazyOwnelisRootSelect;
import br.com.mind5.business.ownerList.model.action.StdOwnelisMergeOwnarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootOwnelisSearch extends DeciTreeTemplateReadV2<OwnelisInfo> {

	public RootOwnelisSearch(DeciTreeOption<OwnelisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OwnelisInfo> buildCheckerHook(DeciTreeOption<OwnelisInfo> option) {
		List<ModelCheckerV1<OwnelisInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OwnelisInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OwnelisInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnelisInfo> option) {
		List<ActionStdV2<OwnelisInfo>> actions = new ArrayList<>();

		ActionStdV2<OwnelisInfo> mergeOwnarch = new StdOwnelisMergeOwnarch(option);
		ActionLazy<OwnelisInfo> select = new LazyOwnelisRootSelect(option.conn, option.schemaName);
		
		mergeOwnarch.addPostAction(select);
		
		actions.add(mergeOwnarch);
		return actions;
	}
}
	