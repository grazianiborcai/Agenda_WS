package br.com.mind5.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.LazyMatextUpdate;
import br.com.mind5.business.materialText.model.action.StdMatextEnforceDefaultOn;
import br.com.mind5.business.materialText.model.action.StdMatextSuccess;
import br.com.mind5.business.materialText.model.checker.MatextCheckHasDefault;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatextHasDefault extends DeciTreeWriteTemplate<MatextInfo> {
	
	public NodeMatextHasDefault(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextInfo> buildDecisionCheckerHook(DeciTreeOption<MatextInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;	
		checker = new MatextCheckHasDefault(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();

		ActionStd<MatextInfo> success = new StdMatextSuccess(option);		
		actions.add(success);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnFailedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();

		ActionStd<MatextInfo> enforceDefaultOn = new StdMatextEnforceDefaultOn(option);	
		ActionLazy<MatextInfo> update = new LazyMatextUpdate(option.conn, option.schemaName);
		
		enforceDefaultOn.addPostAction(update);
		
		actions.add(enforceDefaultOn);
		return actions;
	}
}
