package br.com.mind5.business.calendarMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.action.CalonthVisiMergeCalontharchLtm;
import br.com.mind5.business.calendarMonth.model.action.CalonthVisiRootSelect;
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

public final class CalonthRootSelectLtm extends DeciTreeTemplateRead<CalonthInfo> {
	
	public CalonthRootSelectLtm(DeciTreeOption<CalonthInfo> option) {
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
		
		ActionStd<CalonthInfo> mergeCalontharchLtm = new ActionStdCommom<CalonthInfo>(option, CalonthVisiMergeCalontharchLtm.class);
		ActionLazy<CalonthInfo> select = new  ActionLazyCommom<CalonthInfo>(option, CalonthVisiRootSelect.class);
		
		mergeCalontharchLtm.addPostAction(select);
		
		actions.add(mergeCalontharchLtm);
		return actions;
	}
}
