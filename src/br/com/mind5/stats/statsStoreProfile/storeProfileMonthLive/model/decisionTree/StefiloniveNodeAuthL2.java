package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.decisionTree;

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
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.action.StefiloniveVisiMergeSytotauh;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.checker.StefiloniveCheckSytotin;

public final class StefiloniveNodeAuthL2 extends DeciTreeTemplateWrite<StefiloniveInfo> {
	
	public StefiloniveNodeAuthL2(DeciTreeOption<StefiloniveInfo> option) {
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
		checker = new StefiloniveCheckSytotin(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StefiloniveInfo>> buildActionsOnPassedHook(DeciTreeOption<StefiloniveInfo> option) {
		List<ActionStd<StefiloniveInfo>> actions = new ArrayList<>();
		
		ActionStd<StefiloniveInfo> mergeSytotauh = new ActionStdCommom<StefiloniveInfo>(option, StefiloniveVisiMergeSytotauh.class);		
		
		actions.add(mergeSytotauh);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StefiloniveInfo>> buildActionsOnFailedHook(DeciTreeOption<StefiloniveInfo> option) {
		List<ActionStd<StefiloniveInfo>> actions = new ArrayList<>();
		
		ActionStd<StefiloniveInfo> success = new ActionStdSuccessCommom<StefiloniveInfo>(option);
		
		actions.add(success);
		return actions;
	}
}
