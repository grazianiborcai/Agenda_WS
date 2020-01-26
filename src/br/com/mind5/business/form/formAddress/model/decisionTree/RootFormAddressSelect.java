package br.com.mind5.business.form.formAddress.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.business.form.formAddress.model.checker.FormAddressCheckCountry;
import br.com.mind5.business.form.formAddress.model.checker.FormAddressCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootFormAddressSelect extends DeciTreeReadTemplate<FormAddressInfo> {
	
	public RootFormAddressSelect(DeciTreeOption<FormAddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FormAddressInfo> buildDecisionCheckerHook(DeciTreeOption<FormAddressInfo> option) {
		List<ModelChecker<FormAddressInfo>> queue = new ArrayList<>();		
		ModelChecker<FormAddressInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new FormAddressCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FormAddressCheckCountry(checkerOption);
		queue.add(checker);
		
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<FormAddressInfo>> buildActionsOnPassedHook(DeciTreeOption<FormAddressInfo> option) {
		List<ActionStd<FormAddressInfo>> actions = new ArrayList<>();
		
		ActionStd<FormAddressInfo> nodeSelect = new NodeFormAddressSelect(option).toAction();
		
		actions.add(nodeSelect);
		return actions;
	}
}
