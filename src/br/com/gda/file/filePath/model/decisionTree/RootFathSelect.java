package br.com.gda.file.filePath.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.file.filePath.info.FathInfo;
import br.com.gda.file.filePath.model.action.StdFathSelect;
import br.com.gda.file.filePath.model.checker.FathCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootFathSelect extends DeciTreeReadTemplate<FathInfo> {
	
	public RootFathSelect(DeciTreeOption<FathInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FathInfo> buildDecisionCheckerHook(DeciTreeOption<FathInfo> option) {
		List<ModelChecker<FathInfo>> queue = new ArrayList<>();		
		ModelChecker<FathInfo> checker;
		
		checker = new FathCheckRead();
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
