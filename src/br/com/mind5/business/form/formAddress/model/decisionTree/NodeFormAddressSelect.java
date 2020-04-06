package br.com.mind5.business.form.formAddress.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.business.form.formAddress.model.action.StdFormAddressEnforceDefault;
import br.com.mind5.business.form.formAddress.model.action.StdFormAddressSelect;
import br.com.mind5.business.form.formAddress.model.checker.FormAddressCheckExist;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class NodeFormAddressSelect extends DeciTreeTemplateRead<FormAddressInfo> {
	
	public NodeFormAddressSelect(DeciTreeOption<FormAddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<FormAddressInfo> buildCheckerHook(DeciTreeOption<FormAddressInfo> option) {
		List<ModelCheckerV1<FormAddressInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<FormAddressInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new FormAddressCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FormAddressInfo>> buildActionsOnPassedHook(DeciTreeOption<FormAddressInfo> option) {
		List<ActionStdV1<FormAddressInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FormAddressInfo> select = new StdFormAddressSelect(option);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV1<FormAddressInfo>> buildActionsOnFailedHook(DeciTreeOption<FormAddressInfo> option) {
		List<ActionStdV1<FormAddressInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FormAddressInfo> enforceDefault = new StdFormAddressEnforceDefault(option);
		
		actions.add(enforceDefault);
		return actions;
	}
}
