package br.com.mind5.masterData.position.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.position.info.PositionInfo;
import br.com.mind5.masterData.position.model.action.StdPositionDaoSelect;
import br.com.mind5.masterData.position.model.checker.PositionCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPositionSelect extends DeciTreeTemplateRead<PositionInfo> {
	
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PositionInfo>> buildActionsOnPassedHook(DeciTreeOption<PositionInfo> option) {
		List<ActionStd<PositionInfo>> actions = new ArrayList<>();
		
		ActionStd<PositionInfo> select = new StdPositionDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
