package br.com.mind5.business.calendarMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.action.CalonthVisiMergeMonth;
import br.com.mind5.business.calendarMonth.model.action.CalonthVisiMergeToSelect;
import br.com.mind5.business.calendarMonth.model.checker.CalonthCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CalonthRootSelect extends DeciTreeTemplateRead<CalonthInfo> {
	
	public CalonthRootSelect(DeciTreeOption<CalonthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CalonthInfo> buildCheckerHook(DeciTreeOption<CalonthInfo> option) {
		List<ModelChecker<CalonthInfo>> queue = new ArrayList<>();
		ModelChecker<CalonthInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new CalonthCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<CalonthInfo>> buildActionsOnPassedHook(DeciTreeOption<CalonthInfo> option) {
		List<ActionStd<CalonthInfo>> actions = new ArrayList<>();
		
		ActionStd<CalonthInfo> mergeToSelect = new ActionStdCommom<CalonthInfo>(option, CalonthVisiMergeToSelect.class);
		ActionLazy<CalonthInfo> mergeMonth = new ActionLazyCommom<CalonthInfo>(option, CalonthVisiMergeMonth.class);
		
		mergeToSelect.addPostAction(mergeMonth);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
