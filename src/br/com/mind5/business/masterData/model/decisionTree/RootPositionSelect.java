package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.PositionInfo;
import br.com.mind5.business.masterData.model.action.StdPositionSelect;
import br.com.mind5.business.masterData.model.checker.PositionCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPositionSelect extends DeciTreeTemplateRead<PositionInfo> {
	
	public RootPositionSelect(DeciTreeOption<PositionInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PositionInfo> buildCheckerHook(DeciTreeOption<PositionInfo> option) {
		List<ModelCheckerV1<PositionInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PositionInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PositionCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PositionInfo>> buildActionsOnPassedHook(DeciTreeOption<PositionInfo> option) {
		List<ActionStdV1<PositionInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PositionInfo> select = new StdPositionSelect(option);
		
		actions.add(select);
		return actions;
	}
}
