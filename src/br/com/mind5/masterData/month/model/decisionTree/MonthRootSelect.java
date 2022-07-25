package br.com.mind5.masterData.month.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.action.MonthVisiDaoSelect;
import br.com.mind5.masterData.month.model.checker.MonthCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class MonthRootSelect extends DeciTreeTemplateRead<MonthInfo> {
	
	public MonthRootSelect(DeciTreeOption<MonthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MonthInfo> buildCheckerHook(DeciTreeOption<MonthInfo> option) {
		List<ModelChecker<MonthInfo>> queue = new ArrayList<>();		
		ModelChecker<MonthInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MonthCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MonthInfo>> buildActionsOnPassedHook(DeciTreeOption<MonthInfo> option) {
		List<ActionStd<MonthInfo>> actions = new ArrayList<>();
		
		ActionStd<MonthInfo> select = new ActionStdCommom<MonthInfo>(option, MonthVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
