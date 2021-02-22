package br.com.mind5.business.materialPrice.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialPrice.info.MaticeInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootMaticeSelectByWeekday extends DeciTreeTemplateWrite<MaticeInfo> {
	
	public RootMaticeSelectByWeekday(DeciTreeOption<MaticeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MaticeInfo> buildCheckerHook(DeciTreeOption<MaticeInfo> option) {
		List<ModelChecker<MaticeInfo>> queue = new ArrayList<>();		
		ModelChecker<MaticeInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MaticeInfo>> buildActionsOnPassedHook(DeciTreeOption<MaticeInfo> option) {
		List<ActionStd<MaticeInfo>> actions = new ArrayList<>();
		
		ActionStd<MaticeInfo> select = new RootMaticeSelect(option).toAction();
		
		actions.add(select);
		return actions;
	}
}
