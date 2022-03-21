package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.info.SowordInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action.SowordVisiEnforceZerofy;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action.SowordVisiMergeSowordive;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.action.SowordVisiSowordagrInsert;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonth.model.checker.SowordCheckSowordive;


public final class SowordNodeSelectL2 extends DeciTreeTemplateWrite<SowordInfo> {
	
	public SowordNodeSelectL2(DeciTreeOption<SowordInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowordInfo> buildCheckerHook(DeciTreeOption<SowordInfo> option) {
		List<ModelChecker<SowordInfo>> queue = new ArrayList<>();
		ModelChecker<SowordInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowordCheckSowordive(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowordInfo>> buildActionsOnPassedHook(DeciTreeOption<SowordInfo> option) {
		List<ActionStd<SowordInfo>> actions = new ArrayList<>();

		ActionStd<SowordInfo> mergeSowordive = new ActionStdCommom<SowordInfo>(option, SowordVisiMergeSowordive.class);
		ActionLazy<SowordInfo> insertSowordagr = new ActionLazyCommom<SowordInfo>(option, SowordVisiSowordagrInsert.class);
		
		mergeSowordive.addPostAction(insertSowordagr);
		
		
		actions.add(mergeSowordive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowordInfo>> buildActionsOnFailedHook(DeciTreeOption<SowordInfo> option) {
		List<ActionStd<SowordInfo>> actions = new ArrayList<>();

		ActionStd<SowordInfo> zerofy = new ActionStdCommom<SowordInfo>(option, SowordVisiEnforceZerofy.class);
		ActionLazy<SowordInfo> insertSowordagr = new ActionLazyCommom<SowordInfo>(option, SowordVisiSowordagrInsert.class);
		
		zerofy.addPostAction(insertSowordagr);
		
		actions.add(zerofy);
		return actions;
	}
}
