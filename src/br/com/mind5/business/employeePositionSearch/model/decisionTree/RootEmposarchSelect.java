package br.com.mind5.business.employeePositionSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.employeePositionSearch.model.action.StdEmposarchMergeToSelect;
import br.com.mind5.business.employeePositionSearch.model.checker.EmposarchCheckLangu;
import br.com.mind5.business.employeePositionSearch.model.checker.EmposarchCheckOwner;
import br.com.mind5.business.employeePositionSearch.model.checker.EmposarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootEmposarchSelect extends DeciTreeReadTemplate<EmposarchInfo> {
	
	public RootEmposarchSelect(DeciTreeOption<EmposarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmposarchInfo> buildDecisionCheckerHook(DeciTreeOption<EmposarchInfo> option) {
		List<ModelChecker<EmposarchInfo>> queue = new ArrayList<>();		
		ModelChecker<EmposarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new EmposarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposarchCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmposarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmposarchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmposarchInfo> option) {
		List<ActionStd<EmposarchInfo>> actions = new ArrayList<>();
		
		ActionStd<EmposarchInfo> select	= new StdEmposarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
