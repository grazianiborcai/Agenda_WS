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
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.action.SowalVisiMergeStolis;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.action.SowalVisiNodeSelectL1;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.checker.SowalCheckLangu;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.checker.SowalCheckOwner;
import br.com.mind5.stats.statsOwnerSale.ownerSale.model.checker.SowalCheckRead;


public final class SowalRootSelect extends DeciTreeTemplateWrite<SowalInfo> {
	
	public SowalRootSelect(DeciTreeOption<SowalInfo> option) {
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
		checker = new SowalCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowalCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new SowalCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowalInfo>> buildActionsOnPassedHook(DeciTreeOption<SowalInfo> option) {
		List<ActionStd<SowalInfo>> actions = new ArrayList<>();

		ActionStd<SowalInfo> mergeStolis = new ActionStdCommom<SowalInfo>(option, SowalVisiMergeStolis.class);
		ActionLazy<SowalInfo> nodeL1 = new ActionLazyCommom<SowalInfo>(option, SowalVisiNodeSelectL1.class);
		
		mergeStolis.addPostAction(nodeL1);
		
		actions.add(mergeStolis);
		return actions;
	}
}
