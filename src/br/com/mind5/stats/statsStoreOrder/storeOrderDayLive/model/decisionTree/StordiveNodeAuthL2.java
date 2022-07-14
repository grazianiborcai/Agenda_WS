package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.action.StordiveVisiMergeSytotauh;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.checker.StordiveCheckSytotin;

public final class StordiveNodeAuthL2 extends DeciTreeTemplateWrite<StordiveInfo> {
	
	public StordiveNodeAuthL2(DeciTreeOption<StordiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StordiveInfo> buildCheckerHook(DeciTreeOption<StordiveInfo> option) {
		List<ModelChecker<StordiveInfo>> queue = new ArrayList<>();
		ModelChecker<StordiveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StordiveCheckSytotin(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StordiveInfo>> buildActionsOnPassedHook(DeciTreeOption<StordiveInfo> option) {
		List<ActionStd<StordiveInfo>> actions = new ArrayList<>();
		
		ActionStd<StordiveInfo> mergeSytotauh = new ActionStdCommom<StordiveInfo>(option, StordiveVisiMergeSytotauh.class);
		
		actions.add(mergeSytotauh);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StordiveInfo>> buildActionsOnFailedHook(DeciTreeOption<StordiveInfo> option) {
		List<ActionStd<StordiveInfo>> actions = new ArrayList<>();
		
		ActionStd<StordiveInfo> success = new ActionStdSuccessCommom<StordiveInfo>(option);
		
		actions.add(success);
		return actions;
	}
}
