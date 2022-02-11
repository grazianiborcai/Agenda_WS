package br.com.mind5.stats.statsOwnerSale.ownerSale.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerSale.ownerSale.info.SowalInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.action.StdSowalEnforceZerofy;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.action.StdSowalSuccess;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.checker.SowalCheckHasData;


public final class NodeSowalZerofy extends DeciTreeTemplateWrite<SowalInfo> {
	
	public NodeSowalZerofy(DeciTreeOption<SowalInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowalInfo> buildCheckerHook(DeciTreeOption<SowalInfo> option) {
		List<ModelChecker<SowalInfo>> queue = new ArrayList<>();		
		ModelChecker<SowalInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowalCheckHasData(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowalInfo>> buildActionsOnPassedHook(DeciTreeOption<SowalInfo> option) {
		List<ActionStd<SowalInfo>> actions = new ArrayList<>();

		ActionStd<SowalInfo> success = new StdSowalSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SowalInfo>> buildActionsOnFailedHook(DeciTreeOption<SowalInfo> option) {
		List<ActionStd<SowalInfo>> actions = new ArrayList<>();

		ActionStd<SowalInfo> zerofy = new StdSowalEnforceZerofy(option);
		
		actions.add(zerofy);
		return actions;
	}
}
