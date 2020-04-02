package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MatmovTypeInfo;
import br.com.mind5.business.masterData.model.action.StdMatmovTypeSelect;
import br.com.mind5.business.masterData.model.checker.MatmovTypeCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
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
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatmovTypeCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<MatmovTypeInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmovTypeInfo> option) {
		List<ActionStdV1<MatmovTypeInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatmovTypeInfo> select = new StdMatmovTypeSelect(option);
		
		actions.add(select);
		return actions;
	}
}
