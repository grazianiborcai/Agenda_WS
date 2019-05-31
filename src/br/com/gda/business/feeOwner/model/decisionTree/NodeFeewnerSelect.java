package br.com.gda.business.feeOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeOwner.info.FeewnerInfo;
import br.com.gda.business.feeOwner.model.action.StdFeewnerMergeFeedef;
import br.com.gda.business.feeOwner.model.action.StdFeewnerMergeToSelect;
import br.com.gda.business.feeOwner.model.checker.FeewnerCheckExist;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class NodeFeewnerSelect extends DeciTreeReadTemplate<FeewnerInfo> {
	
	public NodeFeewnerSelect(DeciTreeOption<FeewnerInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FeewnerInfo> buildDecisionCheckerHook(DeciTreeOption<FeewnerInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<FeewnerInfo>> queue = new ArrayList<>();		
		ModelChecker<FeewnerInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new FeewnerCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FeewnerInfo>> buildActionsOnPassedHook(DeciTreeOption<FeewnerInfo> option) {
		List<ActionStd<FeewnerInfo>> actions = new ArrayList<>();
		
		ActionStd<FeewnerInfo> select = new StdFeewnerMergeToSelect(option);
		actions.add(select);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<FeewnerInfo>> buildActionsOnFailedHook(DeciTreeOption<FeewnerInfo> option) {
		List<ActionStd<FeewnerInfo>> actions = new ArrayList<>();
		
		ActionStd<FeewnerInfo> mergeFeedef = new StdFeewnerMergeFeedef(option);
		actions.add(mergeFeedef);
		
		return actions;
	}
}
