package br.com.mind5.business.ownerSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.business.ownerSnapshot.model.action.StdOwnerapMergeToSelect;
import br.com.mind5.business.ownerSnapshot.model.checker.OwnerapCheckLangu;
import br.com.mind5.business.ownerSnapshot.model.checker.OwnerapCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

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
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
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
	
	
	
	@Override protected List<ActionStdV1<OwnerapInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnerapInfo> option) {
		List<ActionStdV1<OwnerapInfo>> actions = new ArrayList<>();

		ActionStdV1<OwnerapInfo> select = new StdOwnerapMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
	