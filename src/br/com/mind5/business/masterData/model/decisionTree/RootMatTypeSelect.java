package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.business.masterData.model.action.StdMatTypeSelect;
import br.com.mind5.business.masterData.model.checker.MatTypeCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMatTypeSelect extends DeciTreeReadTemplate<MatTypeInfo> {
	
	public RootMatTypeSelect(DeciTreeOption<MatTypeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatTypeInfo> buildDecisionCheckerHook(DeciTreeOption<MatTypeInfo> option) {
		List<ModelChecker<MatTypeInfo>> queue = new ArrayList<>();		
		ModelChecker<MatTypeInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatTypeCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatTypeInfo>> buildActionsOnPassedHook(DeciTreeOption<MatTypeInfo> option) {
		List<ActionStd<MatTypeInfo>> actions = new ArrayList<>();
		
		ActionStd<MatTypeInfo> select = new StdMatTypeSelect(option);
		
		actions.add(select);
		return actions;
	}
}
