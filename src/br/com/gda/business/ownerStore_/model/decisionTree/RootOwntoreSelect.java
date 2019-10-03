package br.com.gda.business.ownerStore_.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.ownerStore_.info.OwntoreInfo;
import br.com.gda.business.ownerStore_.model.action.StdOwntoreMergeToSelect;
import br.com.gda.business.ownerStore_.model.checker.OwntoreCheckLangu;
import br.com.gda.business.ownerStore_.model.checker.OwntoreCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;


public final class RootOwntoreSelect extends DeciTreeReadTemplate<OwntoreInfo> {

	public RootOwntoreSelect(DeciTreeOption<OwntoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwntoreInfo> buildDecisionCheckerHook(DeciTreeOption<OwntoreInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<OwntoreInfo>> queue = new ArrayList<>();		
		ModelChecker<OwntoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new OwntoreCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new OwntoreCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwntoreInfo>> buildActionsOnPassedHook(DeciTreeOption<OwntoreInfo> option) {
		List<ActionStd<OwntoreInfo>> actions = new ArrayList<>();

		ActionStd<OwntoreInfo> select = new StdOwntoreMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
