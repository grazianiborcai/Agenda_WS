package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.business.masterData.model.action.StdMatGroupSelect;
import br.com.mind5.business.masterData.model.checker.MatGroupCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMatGroupSelect extends DeciTreeReadTemplate<MatGroupInfo> {
	
	public RootMatGroupSelect(DeciTreeOption<MatGroupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatGroupInfo> buildDecisionCheckerHook(DeciTreeOption<MatGroupInfo> option) {
		List<ModelChecker<MatGroupInfo>> queue = new ArrayList<>();		
		ModelChecker<MatGroupInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatGroupCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatGroupInfo>> buildActionsOnPassedHook(DeciTreeOption<MatGroupInfo> option) {
		List<ActionStdV1<MatGroupInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatGroupInfo> select = new StdMatGroupSelect(option);
		
		actions.add(select);
		return actions;
	}
}
