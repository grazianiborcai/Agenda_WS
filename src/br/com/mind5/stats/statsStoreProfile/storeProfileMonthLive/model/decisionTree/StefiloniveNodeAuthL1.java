package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.checker.StefiloniveCheckAuthOwner;

public final class StefiloniveNodeAuthL1 extends DeciTreeTemplateWrite<StefiloniveInfo> {
	
	public StefiloniveNodeAuthL1(DeciTreeOption<StefiloniveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StefiloniveInfo> buildCheckerHook(DeciTreeOption<StefiloniveInfo> option) {
		List<ModelChecker<StefiloniveInfo>> queue = new ArrayList<>();		
		ModelChecker<StefiloniveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StefiloniveCheckAuthOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StefiloniveInfo>> buildActionsOnPassedHook(DeciTreeOption<StefiloniveInfo> option) {
		List<ActionStd<StefiloniveInfo>> actions = new ArrayList<>();
		
		ActionStd<StefiloniveInfo> success = new ActionStdSuccessCommom<StefiloniveInfo>(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StefiloniveInfo>> buildActionsOnFailedHook(DeciTreeOption<StefiloniveInfo> option) {
		List<ActionStd<StefiloniveInfo>> actions = new ArrayList<>();
		
		ActionStd<StefiloniveInfo> nodeL2 = new StefiloniveNodeAuthL2(option).toAction();
		
		actions.add(nodeL2);
		return actions;
	}
}
