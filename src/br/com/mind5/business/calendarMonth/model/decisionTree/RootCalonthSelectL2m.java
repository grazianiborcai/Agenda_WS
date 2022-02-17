package br.com.mind5.business.calendarMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.action.LazyCalonthRootSelect;
import br.com.mind5.business.calendarMonth.model.action.StdCalonthMergeCalontharchL2m;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootCalonthSelectL2m extends DeciTreeTemplateRead<CalonthInfo> {
	
	public RootCalonthSelectL2m(DeciTreeOption<CalonthInfo> option) {
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
		
		ActionStd<CalonthInfo> mergeCalontharchL2m = new StdCalonthMergeCalontharchL2m(option);
		ActionLazy<CalonthInfo> select = new LazyCalonthRootSelect(option.conn, option.schemaName);
		
		mergeCalontharchL2m.addPostAction(select);
		
		actions.add(mergeCalontharchL2m);
		return actions;
	}
}
