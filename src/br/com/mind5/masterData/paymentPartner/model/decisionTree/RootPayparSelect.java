package br.com.mind5.masterData.paymentPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.masterData.paymentPartner.model.action.StdPayparDaoSelect;
import br.com.mind5.masterData.paymentPartner.model.checker.PayparCheckRead;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootPayparSelect extends DeciTreeTemplateReadV2<PayparInfo> {
	
	public RootPayparSelect(DeciTreeOption<PayparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayparInfo> buildCheckerHook(DeciTreeOption<PayparInfo> option) {
		List<ModelCheckerV1<PayparInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayparInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayparCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV1<PayparInfo>> buildActionsOnPassedHook(DeciTreeOption<PayparInfo> option) {
		List<ActionStdV1<PayparInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PayparInfo> select = new StdPayparDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
