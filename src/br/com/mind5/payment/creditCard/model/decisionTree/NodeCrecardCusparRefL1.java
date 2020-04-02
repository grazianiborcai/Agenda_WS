package br.com.mind5.payment.creditCard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.model.action.LazyCrecardNodeCusparRefL2;
import br.com.mind5.payment.creditCard.model.action.StdCrecardMergeCuspar;
import br.com.mind5.payment.creditCard.model.checker.CrecardCheckDummy;

public final class NodeCrecardCusparRefL1 extends DeciTreeWriteTemplate<CrecardInfo> {
	
	public NodeCrecardCusparRefL1(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CrecardInfo> buildDecisionCheckerHook(DeciTreeOption<CrecardInfo> option) {
		List<ModelChecker<CrecardInfo>> queue = new ArrayList<>();		
		ModelChecker<CrecardInfo> checker;
		
		checker = new CrecardCheckDummy();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CrecardInfo>> buildActionsOnPassedHook(DeciTreeOption<CrecardInfo> option) {
		List<ActionStdV1<CrecardInfo>> actions = new ArrayList<>();		

		ActionStdV1<CrecardInfo> mergeCuspar = new  StdCrecardMergeCuspar(option);
		ActionLazyV1<CrecardInfo> nodeL2 = new LazyCrecardNodeCusparRefL2(option.conn, option.schemaName);
		
		mergeCuspar.addPostAction(nodeL2);
		
		actions.add(mergeCuspar);		
		return actions;
	}
}
