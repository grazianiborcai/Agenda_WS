package br.com.mind5.business.form.formAddress.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.business.form.formAddress.model.action.StdFormAddressEnforceDefault;
import br.com.mind5.business.form.formAddress.model.action.StdFormAddressSelect;
import br.com.mind5.business.form.formAddress.model.checker.FormAddressCheckExist;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class NodeFormAddressSelect extends DeciTreeReadTemplate<FormAddressInfo> {
	
	public NodeFormAddressSelect(DeciTreeOption<FormAddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FormAddressInfo> buildDecisionCheckerHook(DeciTreeOption<FormAddressInfo> option) {
		List<ModelChecker<FormAddressInfo>> queue = new ArrayList<>();		
		ModelChecker<FormAddressInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FormAddressCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FormAddressInfo>> buildActionsOnPassedHook(DeciTreeOption<FormAddressInfo> option) {
		List<ActionStd<FormAddressInfo>> actions = new ArrayList<>();
		
		ActionStd<FormAddressInfo> select = new StdFormAddressSelect(option);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<FormAddressInfo>> buildActionsOnFailedHook(DeciTreeOption<FormAddressInfo> option) {
		List<ActionStd<FormAddressInfo>> actions = new ArrayList<>();
		
		ActionStd<FormAddressInfo> enforceDefault = new StdFormAddressEnforceDefault(option);
		
		actions.add(enforceDefault);
		return actions;
	}
}
