package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.checker.MatextCheckExist;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeMatextUpsertdelL2 extends DeciTreeTemplateWrite<MatextInfo> {
	
	public NodeMatextUpsertdelL2(DeciTreeOption<MatextInfo> option) {
		super(option);
	}	
	
	
	
	@Override protected ModelChecker<MatextInfo> buildCheckerHook(DeciTreeOption<MatextInfo> option) {
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new MatextCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();
		
		ActionStd<MatextInfo> delete = new RootMatextUpdate(option).toAction();
		
		actions.add(delete);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnFailedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();
		
		ActionStd<MatextInfo> insert = new RootMatextInsert(option).toAction();
		
		actions.add(insert);
		return actions;
	}
}
