package br.com.mind5.payment.payOrderSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.payOrderSearch.model.action.StdPayordarchMergeToSelect;
import br.com.mind5.payment.payOrderSearch.model.checker.PayordarchCheckLangu;
import br.com.mind5.payment.payOrderSearch.model.checker.PayordarchCheckOwner;
import br.com.mind5.payment.payOrderSearch.model.checker.PayordarchCheckRead;

public final class RootPayordarchSelect extends DeciTreeTemplateReadV2<PayordarchInfo> {
	
	public RootPayordarchSelect(DeciTreeOption<PayordarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayordarchInfo> buildCheckerHook(DeciTreeOption<PayordarchInfo> option) {
		List<ModelCheckerV1<PayordarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayordarchInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayordarchCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordarchCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordarchCheckLangu(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PayordarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordarchInfo> option) {
		List<ActionStdV2<PayordarchInfo>> actions = new ArrayList<>();		

		ActionStdV2<PayordarchInfo> mergeToSelect = new StdPayordarchMergeToSelect(option);
		
		actions.add(mergeToSelect);		
		return actions;
	}
}
