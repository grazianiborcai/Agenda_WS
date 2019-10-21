package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MatmovTypeInfo;
import br.com.mind5.business.masterData.model.action.StdMatmovTypeSelect;
import br.com.mind5.business.masterData.model.checker.MatmovTypeCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

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
