package br.com.mind5.business.ownerList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.action.OwnelisVisiRootSelect;
import br.com.mind5.business.ownerList.model.action.OwnelisVisiMergeOwnarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OwnelisRootSearch extends DeciTreeTemplateRead<OwnelisInfo> {

	public OwnelisRootSearch(DeciTreeOption<OwnelisInfo> option) {
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

		ActionStd<OwnelisInfo> mergeOwnarch = new ActionStdCommom<OwnelisInfo>(option, OwnelisVisiMergeOwnarch.class);
		ActionLazy<OwnelisInfo> select = new ActionLazyCommom<OwnelisInfo>(option, OwnelisVisiRootSelect.class);
		
		mergeOwnarch.addPostAction(select);
		
		actions.add(mergeOwnarch);
		return actions;
	}
}
	