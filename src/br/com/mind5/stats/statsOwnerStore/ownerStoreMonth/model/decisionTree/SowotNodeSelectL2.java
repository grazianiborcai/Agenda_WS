package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.action.SowotVisiEnforceZerofy;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.action.SowotVisiMergeSowotive;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.action.SowotVisiSowotagrInsert;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.checker.SowotCheckSowotive;


public final class SowotNodeSelectL2 extends DeciTreeTemplateWrite<SowotInfo> {
	
	public SowotNodeSelectL2(DeciTreeOption<SowotInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowotInfo> buildCheckerHook(DeciTreeOption<SowotInfo> option) {
		List<ModelChecker<SowotInfo>> queue = new ArrayList<>();
		ModelChecker<SowotInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowotCheckSowotive(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowotInfo>> buildActionsOnPassedHook(DeciTreeOption<SowotInfo> option) {
		List<ActionStd<SowotInfo>> actions = new ArrayList<>();

		ActionStd <SowotInfo> mergeSowotive  = new ActionStdCommom<SowotInfo>(option, SowotVisiMergeSowotive.class);
		ActionLazy<SowotInfo> insertSowotagr = new ActionLazyCommom<SowotInfo>(option, SowotVisiSowotagrInsert.class);
		
		mergeSowotive.addPostAction(insertSowotagr);
		
		
		actions.add(mergeSowotive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowotInfo>> buildActionsOnFailedHook(DeciTreeOption<SowotInfo> option) {
		List<ActionStd<SowotInfo>> actions = new ArrayList<>();

		ActionStd <SowotInfo> zerofy         = new ActionStdCommom <SowotInfo>(option, SowotVisiEnforceZerofy.class);
		ActionLazy<SowotInfo> insertSowotagr = new ActionLazyCommom<SowotInfo>(option, SowotVisiSowotagrInsert.class);
		
		zerofy.addPostAction(insertSowotagr);
		
		actions.add(zerofy);
		return actions;
	}
}
