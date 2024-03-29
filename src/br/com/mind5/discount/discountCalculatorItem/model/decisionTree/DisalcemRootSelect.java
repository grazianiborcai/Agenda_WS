package br.com.mind5.discount.discountCalculatorItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountCalculatorItem.info.DisalcemInfo;
import br.com.mind5.discount.discountCalculatorItem.model.action.DisalcemVisiMergeCartem;
import br.com.mind5.discount.discountCalculatorItem.model.action.DisalcemVisiMergeDisore;
import br.com.mind5.discount.discountCalculatorItem.model.checker.DisalcemCheckCartemarch;
import br.com.mind5.discount.discountCalculatorItem.model.checker.DisalcemCheckLangu;
import br.com.mind5.discount.discountCalculatorItem.model.checker.DisalcemCheckOwner;
import br.com.mind5.discount.discountCalculatorItem.model.checker.DisalcemCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class DisalcemRootSelect extends DeciTreeTemplateRead<DisalcemInfo> {
	
	public DisalcemRootSelect(DeciTreeOption<DisalcemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<DisalcemInfo> buildCheckerHook(DeciTreeOption<DisalcemInfo> option) {
		List<ModelChecker<DisalcemInfo>> queue = new ArrayList<>();		
		ModelChecker<DisalcemInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new DisalcemCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new DisalcemCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new DisalcemCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new DisalcemCheckCartemarch(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<DisalcemInfo>> buildActionsOnPassedHook(DeciTreeOption<DisalcemInfo> option) {
		List<ActionStd<DisalcemInfo>> actions = new ArrayList<>();
		
		ActionStd<DisalcemInfo> mergeCartem = new ActionStdCommom<DisalcemInfo>(option, DisalcemVisiMergeCartem.class);
		ActionLazy<DisalcemInfo> mergeDisore = new ActionLazyCommom<DisalcemInfo>(option, DisalcemVisiMergeDisore.class);		
		
		mergeCartem.addPostAction(mergeDisore);
		
		actions.add(mergeCartem);
		return actions;
	}
}
