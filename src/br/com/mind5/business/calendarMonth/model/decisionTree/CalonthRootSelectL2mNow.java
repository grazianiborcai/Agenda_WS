package br.com.mind5.business.calendarMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.action.CalonthVisiRootSelect;
import br.com.mind5.business.calendarMonth.model.action.CalonthVisiMergeCalontharchL2mNow;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class CalonthRootSelectL2mNow extends DeciTreeTemplateRead<CalonthInfo> {
	
	public CalonthRootSelectL2mNow(DeciTreeOption<CalonthInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CalonthInfo> buildCheckerHook(DeciTreeOption<CalonthInfo> option) {
		List<ModelChecker<CalonthInfo>> queue = new ArrayList<>();
		ModelChecker<CalonthInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<CalonthInfo>> buildActionsOnPassedHook(DeciTreeOption<CalonthInfo> option) {
		List<ActionStd<CalonthInfo>> actions = new ArrayList<>();
		
		ActionStd<CalonthInfo> mergeCalontharchL2mNow = new ActionStdCommom<CalonthInfo>(option, CalonthVisiMergeCalontharchL2mNow.class);
		ActionLazy<CalonthInfo> select = new  ActionLazyCommom<CalonthInfo>(option, CalonthVisiRootSelect.class);
		
		mergeCalontharchL2mNow.addPostAction(select);
		
		actions.add(mergeCalontharchL2mNow);
		return actions;
	}
}
