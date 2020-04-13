package br.com.mind5.payment.payOrderList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV1;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.payOrderList.model.action.StdPayordistMergeToSelect;
import br.com.mind5.payment.payOrderList.model.checker.PayordistCheckLangu;
import br.com.mind5.payment.payOrderList.model.checker.PayordistCheckOwner;
import br.com.mind5.payment.payOrderList.model.checker.PayordistCheckRead;

public final class RootPayordistSelect extends DeciTreeTemplateReadV1<PayordistInfo> {
	
	public RootPayordistSelect(DeciTreeOption<PayordistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PayordistInfo> buildCheckerHook(DeciTreeOption<PayordistInfo> option) {
		List<ModelCheckerV1<PayordistInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PayordistInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PayordistCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordistCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PayordistCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PayordistInfo>> buildActionsOnPassedHook(DeciTreeOption<PayordistInfo> option) {
		List<ActionStdV1<PayordistInfo>> actions = new ArrayList<>();		

		ActionStdV1<PayordistInfo> mergeToSelect = new StdPayordistMergeToSelect(option);
		
		actions.add(mergeToSelect);		
		return actions;
	}
}
