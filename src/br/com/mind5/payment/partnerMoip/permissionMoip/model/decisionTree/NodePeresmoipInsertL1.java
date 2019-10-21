package br.com.mind5.payment.partnerMoip.permissionMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.payment.partnerMoip.permissionMoip.model.checker.PeresmoipCheckStopar;

public final class NodePeresmoipInsertL1 extends DeciTreeWriteTemplate<PeresmoipInfo> {
	
	public NodePeresmoipInsertL1(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PeresmoipInfo> buildDecisionCheckerHook(DeciTreeOption<PeresmoipInfo> option) {
		final boolean DONT_EXIST = false;
		
		List<ModelChecker<PeresmoipInfo>> queue = new ArrayList<>();		
		ModelChecker<PeresmoipInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST;	
		checker = new PeresmoipCheckStopar(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PeresmoipInfo>> buildActionsOnPassedHook(DeciTreeOption<PeresmoipInfo> option) {
		List<ActionStd<PeresmoipInfo>> actions = new ArrayList<>();		

		ActionStd<PeresmoipInfo> nodeInsertL2 = new NodePeresmoipInsertL2(option).toAction();	
		
		actions.add(nodeInsertL2);		
		return actions;
	}
}
