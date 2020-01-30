package br.com.mind5.file.filePath.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.file.filePath.model.action.StdFathSelect;
import br.com.mind5.file.filePath.model.checker.FathCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootFathSelect extends DeciTreeReadTemplate<FathInfo> {
	
	public RootFathSelect(DeciTreeOption<FathInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FathInfo> buildDecisionCheckerHook(DeciTreeOption<FathInfo> option) {
		List<ModelChecker<FathInfo>> queue = new ArrayList<>();		
		ModelChecker<FathInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FathCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FathInfo>> buildActionsOnPassedHook(DeciTreeOption<FathInfo> option) {
		List<ActionStd<FathInfo>> actions = new ArrayList<>();
		
		ActionStd<FathInfo> select = new StdFathSelect(option);
		
		actions.add(select);
		return actions;
	}
}
