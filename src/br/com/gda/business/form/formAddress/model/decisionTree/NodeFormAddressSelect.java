package br.com.gda.business.form.formAddress.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.business.form.formAddress.model.action.StdFormAddressEnforceDefault;
import br.com.gda.business.form.formAddress.model.action.StdFormAddressSelect;
import br.com.gda.business.form.formAddress.model.checker.FormAddressCheckExist;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeFormAddressSelect extends DeciTreeReadTemplate<FormAddressInfo> {
	
	public NodeFormAddressSelect(DeciTreeOption<FormAddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FormAddressInfo> buildDecisionCheckerHook(DeciTreeOption<FormAddressInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<FormAddressInfo>> queue = new ArrayList<>();		
		ModelChecker<FormAddressInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new FormAddressCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FormAddressInfo>> buildActionsOnPassedHook(DeciTreeOption<FormAddressInfo> option) {
		List<ActionStd<FormAddressInfo>> actions = new ArrayList<>();
		
		actions.add(new StdFormAddressSelect(option));
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<FormAddressInfo>> buildActionsOnFailedHook(DeciTreeOption<FormAddressInfo> option) {
		List<ActionStd<FormAddressInfo>> actions = new ArrayList<>();
		
		actions.add(new StdFormAddressEnforceDefault(option));
		return actions;
	}
}
