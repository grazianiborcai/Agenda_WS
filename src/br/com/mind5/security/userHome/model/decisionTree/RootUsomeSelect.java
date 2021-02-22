package br.com.mind5.security.userHome.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.security.userHome.info.UsomeInfo;
import br.com.mind5.security.userHome.model.action.StdUsomeMergeUsername;

public final class RootUsomeSelect extends DeciTreeTemplateRead<UsomeInfo> {
	
	public RootUsomeSelect(DeciTreeOption<UsomeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UsomeInfo> buildCheckerHook(DeciTreeOption<UsomeInfo> option) {
		List<ModelChecker<UsomeInfo>> queue = new ArrayList<>();		
		ModelChecker<UsomeInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UsomeInfo>> buildActionsOnPassedHook(DeciTreeOption<UsomeInfo> option) {
		List<ActionStd<UsomeInfo>> actions = new ArrayList<>();
		
		ActionStd<UsomeInfo> mergeUsername = new StdUsomeMergeUsername(option);
		
		actions.add(mergeUsername);
		return actions;
	}
}
