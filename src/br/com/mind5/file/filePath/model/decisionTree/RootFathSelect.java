package br.com.mind5.file.filePath.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.file.filePath.model.action.StdFathDaoSelect;
import br.com.mind5.file.filePath.model.checker.FathCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootFathSelect extends DeciTreeTemplateRead<FathInfo> {
	
	public RootFathSelect(DeciTreeOption<FathInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FathInfo> buildCheckerHook(DeciTreeOption<FathInfo> option) {
		List<ModelChecker<FathInfo>> queue = new ArrayList<>();		
		ModelChecker<FathInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FathCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FathInfo>> buildActionsOnPassedHook(DeciTreeOption<FathInfo> option) {
		List<ActionStd<FathInfo>> actions = new ArrayList<>();
		
		ActionStd<FathInfo> select = new StdFathDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
