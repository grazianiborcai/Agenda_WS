package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.StdCrecardMergeAddress;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckAddarch;

public final class NodeCrecardAddress extends DeciTreeTemplateWrite<CrecardInfo> {
	
	public NodeCrecardAddress(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CrecardInfo> buildCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelCheckerV1<CrecardInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CrecardInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new CrecardCheckAddarch(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStdV1<CrecardInfo>> actions = new ArrayList<>();		

		ActionStdV1<CrecardInfo> mergeAddress = new  StdCrecardMergeAddress(option);
		
		actions.add(mergeAddress);		
		return actions;
	}
}
