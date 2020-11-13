package br.com.mind5.business.employeeLeaveDateSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.business.employeeLeaveDateSearch.model.action.StdEmplarchMergeToSelect;
import br.com.mind5.business.employeeLeaveDateSearch.model.checker.EmplarchCheckLangu;
import br.com.mind5.business.employeeLeaveDateSearch.model.checker.EmplarchCheckOwner;
import br.com.mind5.business.employeeLeaveDateSearch.model.checker.EmplarchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public class RootEmplarchSelect extends DeciTreeTemplateRead<EmplarchInfo> {
	
	public RootEmplarchSelect(DeciTreeOption<EmplarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EmplarchInfo> buildCheckerHook(DeciTreeOption<EmplarchInfo> option) {
		List<ModelChecker<EmplarchInfo>> queue = new ArrayList<>();		
		ModelChecker<EmplarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new EmplarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplarchCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new EmplarchCheckOwner(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<EmplarchInfo>> buildActionsOnPassedHook(DeciTreeOption<EmplarchInfo> option) {
		List<ActionStd<EmplarchInfo>> actions = new ArrayList<>();
		
		ActionStd<EmplarchInfo> select = new StdEmplarchMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
