package br.com.mind5.masterData.paymentStatusSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.masterData.paymentStatusSearch.info.PaymenusarchInfo;
import br.com.mind5.masterData.paymentStatusSearch.model.action.StdPaymenusarchDaoSelect;
import br.com.mind5.masterData.paymentStatusSearch.model.checker.PaymenusarchCheckRead;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;

public final class RootPaymenusarchSelect extends DeciTreeTemplateReadV1<PaymenusarchInfo> {
	
	public RootPaymenusarchSelect(DeciTreeOption<PaymenusarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PaymenusarchInfo> buildCheckerHook(DeciTreeOption<PaymenusarchInfo> option) {
		List<ModelCheckerV1<PaymenusarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PaymenusarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PaymenusarchCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}

		
	
	@Override protected List<ActionStdV2<PaymenusarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PaymenusarchInfo> option) {
		List<ActionStdV2<PaymenusarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<PaymenusarchInfo> select = new StdPaymenusarchDaoSelect(option);
		
		actions.add(select);
		return actions;
	}
}
