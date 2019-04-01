package br.com.gda.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.model.action.LazyMatextEnforceDefaultOff;
import br.com.gda.business.materialText.model.action.LazyMatextSelect;
import br.com.gda.business.materialText.model.action.LazyMatextUpdate;
import br.com.gda.business.materialText.model.action.StdMatextEnforceMatKey;
import br.com.gda.business.materialText.model.action.StdMatextSuccess;
import br.com.gda.business.materialText.model.checker.MatextCheckHasDefault;
import br.com.gda.business.materialText.model.checker.MatextCheckIsDefault;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatextDefaultOn extends DeciTreeWriteTemplate<MatextInfo> {
	
	public NodeMatextDefaultOn(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextInfo> buildDecisionCheckerHook(DeciTreeOption<MatextInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new MatextCheckIsDefault();
		queue.add(checker);
		
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
		//TODO: incluir MergeToUpdate e adicionar LChanged e ChangedBy
		ActionStd<MatextInfo> enforceMatKey = new StdMatextEnforceMatKey(option);
		ActionLazy<MatextInfo> select = new LazyMatextSelect(option.conn, option.schemaName);
		ActionLazy<MatextInfo> enforceDefaultOff = new LazyMatextEnforceDefaultOff(option.conn, option.schemaName);
		ActionLazy<MatextInfo> update = new LazyMatextUpdate(option.conn, option.schemaName);
		
		enforceMatKey.addPostAction(select);
		select.addPostAction(enforceDefaultOff);
		enforceDefaultOff.addPostAction(update);
		
		actions.add(enforceMatKey);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnFailedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();

		ActionStd<MatextInfo> success = new StdMatextSuccess(option);		
		actions.add(success);
		
		return actions;
	}
}
