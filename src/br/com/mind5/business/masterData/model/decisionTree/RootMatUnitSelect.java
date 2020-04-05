package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.business.masterData.model.action.StdMatUnitSelect;
import br.com.mind5.business.masterData.model.checker.MatUnitCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMatUnitSelect extends DeciTreeReadTemplate<MatUnitInfo> {
	
	public RootMatUnitSelect(DeciTreeOption<MatUnitInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatUnitInfo> buildCheckerHook(DeciTreeOption<MatUnitInfo> option) {
		List<ModelChecker<MatUnitInfo>> queue = new ArrayList<>();		
		ModelChecker<MatUnitInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatUnitCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatUnitInfo>> buildActionsOnPassedHook(DeciTreeOption<MatUnitInfo> option) {
		List<ActionStdV1<MatUnitInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatUnitInfo> select = new StdMatUnitSelect(option);
		
		actions.add(select);
		return actions;
	}
}
