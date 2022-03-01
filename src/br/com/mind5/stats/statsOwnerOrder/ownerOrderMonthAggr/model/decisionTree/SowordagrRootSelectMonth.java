package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action.SowordagrVisiMergeSowordarchMonth;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action.SowordagrVisiRootSelect;


public final class SowordagrRootSelectMonth extends DeciTreeTemplateWrite<SowordagrInfo> {
	
	public SowordagrRootSelectMonth(DeciTreeOption<SowordagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowordagrInfo> buildCheckerHook(DeciTreeOption<SowordagrInfo> option) {
		List<ModelChecker<SowordagrInfo>> queue = new ArrayList<>();
		ModelChecker<SowordagrInfo> checker;

		checker = new ModelCheckerDummy<SowordagrInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowordagrInfo>> buildActionsOnPassedHook(DeciTreeOption<SowordagrInfo> option) {
		List<ActionStd<SowordagrInfo>> actions = new ArrayList<>();

		ActionStd<SowordagrInfo> mergeSowordarchMonth = new ActionStdCommom<SowordagrInfo>(option, SowordagrVisiMergeSowordarchMonth.class);
		ActionLazy<SowordagrInfo> select = new ActionLazyCommom<SowordagrInfo>(option.conn, option.schemaName, SowordagrVisiRootSelect.class);
		
		mergeSowordarchMonth.addPostAction(select);
		
		actions.add(mergeSowordarchMonth);
		return actions;
	}
}
