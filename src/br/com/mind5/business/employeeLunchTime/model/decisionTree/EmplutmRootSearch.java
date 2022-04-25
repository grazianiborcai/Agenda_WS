package br.com.mind5.business.employeeLunchTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiRootSelect;
import br.com.mind5.business.employeeLunchTime.model.action.EmplutmVisiMergeEmplutmarch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmplutmRootSearch extends DeciTreeTemplateRead<EmplutmInfo> {
	
	public EmplutmRootSearch(DeciTreeOption<EmplutmInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplutmInfo> buildCheckerHook(DeciTreeOption<EmplutmInfo> option) {
		List<ModelChecker<EmplutmInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplutmInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplutmInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplutmInfo> option) {
		List<ActionStd<EmplutmInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplutmInfo> mergeEmplutmarch = new ActionStdCommom<EmplutmInfo>(option, EmplutmVisiMergeEmplutmarch.class);
		ActionLazy<EmplutmInfo> select = new ActionLazyCommom<EmplutmInfo>(option, EmplutmVisiRootSelect.class);
		
		mergeEmplutmarch.addPostAction(select);
		
		actions.add(mergeEmplutmarch);
		return actions;
	}
}
