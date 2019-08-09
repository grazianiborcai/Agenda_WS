package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.MatmovTypeInfo;
import br.com.gda.business.masterData.model.action.StdMatmovTypeSelect;
import br.com.gda.business.masterData.model.checker.MatmovTypeCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatmovTypeSelect extends DeciTreeReadTemplate<MatmovTypeInfo> {
	
	public RootMatmovTypeSelect(DeciTreeOption<MatmovTypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatmovTypeInfo> buildDecisionCheckerHook(DeciTreeOption<MatmovTypeInfo> option) {
		List<ModelChecker<MatmovTypeInfo>> queue = new ArrayList<>();		
		ModelChecker<MatmovTypeInfo> checker;
		
		checker = new MatmovTypeCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<MatmovTypeInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmovTypeInfo> option) {
		List<ActionStd<MatmovTypeInfo>> actions = new ArrayList<>();
		
		actions.add(new StdMatmovTypeSelect(option));
		return actions;
	}
}
