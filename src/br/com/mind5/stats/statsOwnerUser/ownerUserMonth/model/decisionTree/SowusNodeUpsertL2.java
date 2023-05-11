package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action.SowusVisiEnforceZerofy;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action.SowusVisiMergeSowusive;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action.SowusVisiSowusagrUpsert;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.checker.SowusCheckSowusive;


public final class SowusNodeUpsertL2 extends DeciTreeTemplateWrite<SowusInfo> {
	
	public SowusNodeUpsertL2(DeciTreeOption<SowusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowusInfo> buildCheckerHook(DeciTreeOption<SowusInfo> option) {
		List<ModelChecker<SowusInfo>> queue = new ArrayList<>();
		ModelChecker<SowusInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowusCheckSowusive(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowusInfo>> buildActionsOnPassedHook(DeciTreeOption<SowusInfo> option) {
		List<ActionStd<SowusInfo>> actions = new ArrayList<>();

		ActionStd <SowusInfo> mergeSowusive  = new ActionStdCommom <SowusInfo>(option, SowusVisiMergeSowusive.class);
		ActionLazy<SowusInfo> upsertSowusagr = new ActionLazyCommom<SowusInfo>(option, SowusVisiSowusagrUpsert.class);
		
		mergeSowusive.addPostAction(upsertSowusagr);
		
		
		actions.add(mergeSowusive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowusInfo>> buildActionsOnFailedHook(DeciTreeOption<SowusInfo> option) {
		List<ActionStd<SowusInfo>> actions = new ArrayList<>();

		ActionStd <SowusInfo> zerofy         = new ActionStdCommom <SowusInfo>(option, SowusVisiEnforceZerofy.class);
		ActionLazy<SowusInfo> upsertSowusagr = new ActionLazyCommom<SowusInfo>(option, SowusVisiSowusagrUpsert.class);
		
		zerofy.addPostAction(upsertSowusagr);
		
		
		actions.add(zerofy);
		return actions;
	}
}
