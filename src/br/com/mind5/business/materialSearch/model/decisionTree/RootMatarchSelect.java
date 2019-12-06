package br.com.mind5.business.materialSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.action.StdMatarchMergeToSelect;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMatarchSelect extends DeciTreeReadTemplate<MatarchInfo> {
	
	public RootMatarchSelect(DeciTreeOption<MatarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatarchInfo> buildDecisionCheckerHook(DeciTreeOption<MatarchInfo> option) {
		List<ModelChecker<MatarchInfo>> queue = new ArrayList<>();		
		ModelChecker<MatarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatarchInfo>> buildActionsOnPassedHook(DeciTreeOption<MatarchInfo> option) {
		List<ActionStd<MatarchInfo>> actions = new ArrayList<>();
		
		ActionStd<MatarchInfo> select = new StdMatarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
