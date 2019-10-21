package br.com.mind5.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.action.StdMatmovMergeToSelect;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckLangu;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckRead;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckStorauth;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;


public final class RootMatmovSelect extends DeciTreeReadTemplate<MatmovInfo> {
	
	public RootMatmovSelect(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatmovInfo> buildDecisionCheckerHook(DeciTreeOption<MatmovInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<MatmovInfo>> queue = new ArrayList<>();		
		ModelChecker<MatmovInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new MatmovCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatmovCheckLangu(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatmovCheckStorauth(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatmovInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmovInfo> option) {
		List<ActionStd<MatmovInfo>> actions = new ArrayList<>();

		ActionStd<MatmovInfo> select = new StdMatmovMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
}
