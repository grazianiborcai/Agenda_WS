package br.com.mind5.stats.statsOwnerSale.ownerSale.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.action.SowalVisiEnforceZerofy;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.action.SowalVisiMergeSowalive;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.action.SowalVisiSowalagrUpsert;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.checker.SowalCheckSowalive;


public final class SowalNodeUpsertL2 extends DeciTreeTemplateWrite<SowalInfo> {
	
	public SowalNodeUpsertL2(DeciTreeOption<SowalInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowalInfo> buildCheckerHook(DeciTreeOption<SowalInfo> option) {
		List<ModelChecker<SowalInfo>> queue = new ArrayList<>();
		ModelChecker<SowalInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowalCheckSowalive(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowalInfo>> buildActionsOnPassedHook(DeciTreeOption<SowalInfo> option) {
		List<ActionStd<SowalInfo>> actions = new ArrayList<>();

		ActionStd<SowalInfo> mergeSowalive = new ActionStdCommom<SowalInfo>(option, SowalVisiMergeSowalive.class);
		ActionLazy<SowalInfo> upsertSowalagr = new ActionLazyCommom<SowalInfo>(option, SowalVisiSowalagrUpsert.class);
		
		mergeSowalive.addPostAction(upsertSowalagr);
		
		
		actions.add(mergeSowalive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowalInfo>> buildActionsOnFailedHook(DeciTreeOption<SowalInfo> option) {
		List<ActionStd<SowalInfo>> actions = new ArrayList<>();

		ActionStd<SowalInfo> zerofy = new ActionStdCommom<SowalInfo>(option, SowalVisiEnforceZerofy.class);
		ActionLazy<SowalInfo> upsertSowalagr = new ActionLazyCommom<SowalInfo>(option, SowalVisiSowalagrUpsert.class);
		
		zerofy.addPostAction(upsertSowalagr);
		
		actions.add(zerofy);
		return actions;
	}
}
