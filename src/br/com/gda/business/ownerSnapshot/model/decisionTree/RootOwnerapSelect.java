package br.com.gda.business.ownerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.business.ownerSnapshot.model.action.StdOwnerapMergeToSelect;
import br.com.gda.business.ownerSnapshot.model.checker.OwnerapCheckLangu;
import br.com.gda.business.ownerSnapshot.model.checker.OwnerapCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;

public final class RootOwnerapSelect extends DeciTreeReadTemplate<OwnerapInfo> {

	public RootOwnerapSelect(DeciTreeOption<OwnerapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnerapInfo> buildDecisionCheckerHook(DeciTreeOption<OwnerapInfo> option) {
		List<ModelChecker<OwnerapInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerapInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.RETURN_TRUE;	
		checker = new OwnerapCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OwnerapCheckLangu(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnerapInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerapInfo> option) {
		List<ActionStd<OwnerapInfo>> actions = new ArrayList<>();

		ActionStd<OwnerapInfo> select = new StdOwnerapMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
	