package br.com.mind5.business.employeeRestricted.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeRestricted.info.EmplresInfo;
import br.com.mind5.business.employeeRestricted.model.action.EmplresVisiMergeEmplis;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class EmplresRootSelect extends DeciTreeTemplateRead<EmplresInfo> {
	
	public EmplresRootSelect(DeciTreeOption<EmplresInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplresInfo> buildCheckerHook(DeciTreeOption<EmplresInfo> option) {
		List<ModelChecker<EmplresInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplresInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplresInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplresInfo> option) {
		List<ActionStd<EmplresInfo>> actions = new ArrayList<>();

		ActionStd<EmplresInfo> mergeEmplis = new ActionStdCommom<EmplresInfo>(option, EmplresVisiMergeEmplis.class);
		
		actions.add(mergeEmplis);
		return actions;
	}
}
