package br.com.mind5.masterData.weekday.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.action.WeekdayVisiDaoSelect;
import br.com.mind5.masterData.weekday.model.checker.WeekdayCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class WeekdayRootSelect extends DeciTreeTemplateRead<WeekdayInfo> {
	
	public WeekdayRootSelect(DeciTreeOption<WeekdayInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<WeekdayInfo> buildCheckerHook(DeciTreeOption<WeekdayInfo> option) {
		List<ModelChecker<WeekdayInfo>> queue = new ArrayList<>();		
		ModelChecker<WeekdayInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new WeekdayCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<WeekdayInfo>> buildActionsOnPassedHook(DeciTreeOption<WeekdayInfo> option) {
		List<ActionStd<WeekdayInfo>> actions = new ArrayList<>();
		
		ActionStd<WeekdayInfo> select = new ActionStdCommom<WeekdayInfo>(option, WeekdayVisiDaoSelect.class);
		
		actions.add(select);
		return actions;
	}
}
