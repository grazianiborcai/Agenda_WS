package br.com.mind5.payment.systemPartnerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;
import br.com.mind5.payment.systemPartnerSearch.model.action.StdSysparchSelect;
import br.com.mind5.payment.systemPartnerSearch.model.checker.SysparchCheckRead;

public final class RootSysparchSelect extends DeciTreeTemplateReadV1<SysparchInfo> {
	
	public RootSysparchSelect(DeciTreeOption<SysparchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<SysparchInfo> buildCheckerHook(DeciTreeOption<SysparchInfo> option) {
		List<ModelCheckerV1<SysparchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<SysparchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new SysparchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<SysparchInfo>> buildActionsOnPassedHook(DeciTreeOption<SysparchInfo> option) {
		List<ActionStdV1<SysparchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<SysparchInfo> select = new StdSysparchSelect(option);
		
		actions.add(select);
		return actions;
	}
}
