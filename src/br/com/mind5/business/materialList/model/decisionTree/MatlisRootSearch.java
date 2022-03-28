package br.com.mind5.business.materialList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialList.model.action.MatlisVisiRootSelect;
import br.com.mind5.business.materialList.model.action.MatlisVisiMergeMatarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MatlisRootSearch extends DeciTreeTemplateRead<MatlisInfo> {
	
	public MatlisRootSearch(DeciTreeOption<MatlisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatlisInfo> buildCheckerHook(DeciTreeOption<MatlisInfo> option) {
		List<ModelChecker<MatlisInfo>> queue = new ArrayList<>();		
		ModelChecker<MatlisInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatlisInfo>> buildActionsOnPassedHook(DeciTreeOption<MatlisInfo> option) {
		List<ActionStd<MatlisInfo>> actions = new ArrayList<>();
		
		ActionStd<MatlisInfo> mergeMatarch = new ActionStdCommom<MatlisInfo>(option, MatlisVisiMergeMatarch.class);
		ActionLazy<MatlisInfo> select = new ActionLazyCommom<MatlisInfo>(option, MatlisVisiRootSelect.class);
		
		mergeMatarch.addPostAction(select);
		
		actions.add(mergeMatarch);
		return actions;
	}
}
