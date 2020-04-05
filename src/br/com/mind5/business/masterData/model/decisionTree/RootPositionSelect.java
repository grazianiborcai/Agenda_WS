package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.PositionInfo;
import br.com.mind5.business.masterData.model.action.StdPositionSelect;
import br.com.mind5.business.masterData.model.checker.PositionCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootPositionSelect extends DeciTreeReadTemplate<PositionInfo> {
	
	public RootPositionSelect(DeciTreeOption<PositionInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PositionInfo> buildCheckerHook(DeciTreeOption<PositionInfo> option) {
		List<ModelChecker<PositionInfo>> queue = new ArrayList<>();		
		ModelChecker<PositionInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PositionCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PositionInfo>> buildActionsOnPassedHook(DeciTreeOption<PositionInfo> option) {
		List<ActionStdV1<PositionInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PositionInfo> select = new StdPositionSelect(option);
		
		actions.add(select);
		return actions;
	}
}
