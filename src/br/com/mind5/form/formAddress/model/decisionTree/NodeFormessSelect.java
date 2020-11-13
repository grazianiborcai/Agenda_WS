package br.com.mind5.form.formAddress.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.model.action.StdFormessEnforceDefault;
import br.com.mind5.form.formAddress.model.action.StdFormessMergeToSelect;
import br.com.mind5.form.formAddress.model.checker.FormessCheckExist;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeFormessSelect extends DeciTreeTemplateWrite<FormessInfo> {
	
	public NodeFormessSelect(DeciTreeOption<FormessInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FormessInfo> buildCheckerHook(DeciTreeOption<FormessInfo> option) {
		List<ModelChecker<FormessInfo>> queue = new ArrayList<>();		
		ModelChecker<FormessInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FormessCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FormessInfo>> buildActionsOnPassedHook(DeciTreeOption<FormessInfo> option) {
		List<ActionStd<FormessInfo>> actions = new ArrayList<>();
		
		ActionStd<FormessInfo> select = new StdFormessMergeToSelect(option);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<FormessInfo>> buildActionsOnFailedHook(DeciTreeOption<FormessInfo> option) {
		List<ActionStd<FormessInfo>> actions = new ArrayList<>();
		
		ActionStd<FormessInfo> enforceDefault = new StdFormessEnforceDefault(option);
		
		actions.add(enforceDefault);
		return actions;
	}
}
