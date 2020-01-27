package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.UserCategInfo;
import br.com.mind5.business.masterData.model.action.StdUserCategSelect;
import br.com.mind5.business.masterData.model.checker.UserCategCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootUserCategSelect extends DeciTreeReadTemplate<UserCategInfo> {
	
	public RootUserCategSelect(DeciTreeOption<UserCategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserCategInfo> buildDecisionCheckerHook(DeciTreeOption<UserCategInfo> option) {
		List<ModelChecker<UserCategInfo>> queue = new ArrayList<>();		
		ModelChecker<UserCategInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UserCategCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserCategInfo>> buildActionsOnPassedHook(DeciTreeOption<UserCategInfo> option) {
		List<ActionStd<UserCategInfo>> actions = new ArrayList<>();
		
		ActionStd<UserCategInfo> select = new StdUserCategSelect(option);
		
		actions.add(select);
		return actions;
	}
}
