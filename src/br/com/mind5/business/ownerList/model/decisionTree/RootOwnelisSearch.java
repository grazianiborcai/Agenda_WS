package br.com.mind5.business.ownerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.action.LazyOwnelisRootSelect;
import br.com.mind5.business.ownerList.model.action.StdOwnelisMergeOwnarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootOwnelisSearch extends DeciTreeTemplateRead<OwnelisInfo> {

	public RootOwnelisSearch(DeciTreeOption<OwnelisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnelisInfo> buildCheckerHook(DeciTreeOption<OwnelisInfo> option) {
		List<ModelChecker<OwnelisInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnelisInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnelisInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnelisInfo> option) {
		List<ActionStd<OwnelisInfo>> actions = new ArrayList<>();

		ActionStd<OwnelisInfo> mergeOwnarch = new StdOwnelisMergeOwnarch(option);
		ActionLazy<OwnelisInfo> select = new LazyOwnelisRootSelect(option.conn, option.schemaName);
		
		mergeOwnarch.addPostAction(select);
		
		actions.add(mergeOwnarch);
		return actions;
	}
}
	