package br.com.mind5.business.materialTextDefault.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextDefault.model.action.StdMatextaultMergeToSelect;
import br.com.mind5.business.materialTextDefault.model.checker.MatextaultCheckOwner;
import br.com.mind5.business.materialTextDefault.model.checker.MatextaultCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMatextaultSelect extends DeciTreeReadTemplate<MatextaultInfo> {
	
	public RootMatextaultSelect(DeciTreeOption<MatextaultInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextaultInfo> buildDecisionCheckerHook(DeciTreeOption<MatextaultInfo> option) {
		List<ModelChecker<MatextaultInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextaultInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextaultCheckRead(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new MatextaultCheckOwner(checkerOption);
		queue.add(checker);			
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextaultInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextaultInfo> option) {
		List<ActionStd<MatextaultInfo>> actions = new ArrayList<>();
		
		ActionStd<MatextaultInfo> select = new StdMatextaultMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
