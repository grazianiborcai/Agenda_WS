package br.com.mind5.masterData.monthSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.monthSearch.info.MontharchInfo;
import br.com.mind5.masterData.monthSearch.model.action.MontharchVisiDaoSelect;
import br.com.mind5.masterData.monthSearch.model.checker.MontharchCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MontharchRootSelect extends DeciTreeTemplateRead<MontharchInfo> {
	
	public MontharchRootSelect(DeciTreeOption<MontharchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MontharchInfo> buildCheckerHook(DeciTreeOption<MontharchInfo> option) {
		List<ModelChecker<MontharchInfo>> queue = new ArrayList<>();		
		ModelChecker<MontharchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MontharchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MontharchInfo>> buildActionsOnPassedHook(DeciTreeOption<MontharchInfo> option) {
		List<ActionStd<MontharchInfo>> actions = new ArrayList<>();
		
		ActionStd<MontharchInfo> select = new ActionStdCommom<MontharchInfo>(option, MontharchVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
