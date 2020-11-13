package br.com.mind5.payment.customerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.StdCusparCreateCusmoip;
import br.com.mind5.payment.customerPartner.model.checker.CusparCheckIsMoip;

public final class NodeCusparCreateCusmoip extends DeciTreeTemplateWriteV2<CusparInfo> {
	
	public NodeCusparCreateCusmoip(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CusparInfo> buildCheckerHook(DeciTreeOption<CusparInfo> option) {
		List<ModelCheckerV1<CusparInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CusparInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new CusparCheckIsMoip(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<CusparInfo>> buildActionsOnPassedHook(DeciTreeOption<CusparInfo> option) {
		List<ActionStdV2<CusparInfo>> actions = new ArrayList<>();
		
		ActionStdV2<CusparInfo> createCusmoip = new StdCusparCreateCusmoip(option);
		
		actions.add(createCusmoip);
		return actions;
	}
}
